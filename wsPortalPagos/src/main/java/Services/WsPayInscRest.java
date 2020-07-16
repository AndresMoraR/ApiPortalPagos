package Services;

import Data.QueryPayInsDAO;
import Model.Tbl_query_pay_ins;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("aspirante/v1.0.0")
@Stateless
public class WsPayInscRest {

    /**
     * Pay Pending Inscription
     *
     * @param idpersona
     * @param periodo
     * @return
     */
    @GET
    @Path("inscripcion/{idpersona}/{periodo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPayInsc(@PathParam("idpersona") String idpersona, @PathParam("periodo") String periodo) {
        List<Tbl_query_pay_ins> rs_query_pay = new QueryPayInsDAO().get_pay(new Tbl_query_pay_ins(idpersona), periodo);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String json = gson.toJson(rs_query_pay);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
}
