/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Data.QueryPayMatDao;
import Model.Tbl_query_pay_mat;
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

@Path("matriculado/v1.0.0")
@Stateless
public class WsPayMatRest {

    /**
     * Pay Pending Student Registration.
     *
     * @param idpersona
     * @param periodo
     * @return
     */
    @GET
    @Path("matricula/{idpersona}/{periodo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPayMat(@PathParam("idpersona") String idpersona, @PathParam("periodo") String periodo) {
        List<Tbl_query_pay_mat> rs_query_pay = new QueryPayMatDao().get_pay(new Tbl_query_pay_mat(idpersona), periodo);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String json = gson.toJson(rs_query_pay);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
}
