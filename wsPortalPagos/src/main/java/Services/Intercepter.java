/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.google.gson.JsonObject;
import io.jsonwebtoken.*;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author estfa
 */
@Provider
@PreMatching
public class Intercepter implements ContainerRequestFilter {

    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "1019112739";
        
    @Override
    public void filter(ContainerRequestContext request) throws IOException { 
        String url = request.getUriInfo().getAbsolutePath().toString();
        if (url.contains("/auth")) {
            return;
        } else {            
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
