package Services;

import com.google.gson.JsonObject;
import io.jsonwebtoken.*;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Protected Resource API with Token
 * Vlidate JWT Token generated
 */
@Provider
//@PreMatching
public class Intercepter implements ContainerRequestFilter {

    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private String SECRET = "";
        
    /**
     * Override filter request
     * @param request
     * @throws IOException 
     */
    @Override
    public void filter(ContainerRequestContext request) throws IOException { 
        String url = request.getUriInfo().getAbsolutePath().toString();
        if (url.contains("/auth")) {
            return;
        } else {
            MultivaluedMap<String, String> pathParameters = request.getUriInfo().getPathParameters();
            SECRET = pathParameters.get("idpersona").toString();
            String token = request.getHeaderString(HEADER);
            if (token != null){
                if(!validateToken(token.replace(PREFIX, ""))){
                    JsonObject json = new JsonObject();
                    json.addProperty("mensaje", "Credenciales incorrectas");
                    request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
                    return;
                }           
            }else{
                JsonObject json = new JsonObject();
                json.addProperty("mensaje", "Credenciales son necesarias");
                request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(json.toString()).type(MediaType.APPLICATION_JSON).build());
                return;
            }   
        }
    }

    /**
     * Validate Token with Exceptions
     * @param jwt
     * @return 
     */
    public boolean validateToken(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        try{
            Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(jwt).getBody();            
            return true;
            
        } catch (ExpiredJwtException | MalformedJwtException | SignatureException 
                | UnsupportedJwtException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
