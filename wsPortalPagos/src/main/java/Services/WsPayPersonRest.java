package Services;

import Data.PersonDataDAO;
import Model.Tbl_person_data;
import com.google.gson.Gson;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("persona/v1.0.0")
@Stateless
public class WsPayPersonRest {

    /**
     * Personal Data
     *
     * @param idpersona
     * @return
     */
    @GET
    @Path("persona/{idpersona}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("idpersona") String idpersona) {
        Tbl_person_data person_data = new PersonDataDAO().findOnePerson(new Tbl_person_data(idpersona));
        String json = new Gson().toJson(person_data);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
}
