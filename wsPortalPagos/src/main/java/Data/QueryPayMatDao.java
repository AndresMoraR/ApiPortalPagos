/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Tbl_query_pay_mat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estfa
 */
public class QueryPayMatDao {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String SQL_SELECT
            = "SELECT v.NUM_DOCUMENTO AS num_recibo, "
            + "v.identificacion AS num_identificacion, "
            + "b.NOM_LARGO, "
            + "b.dir_email_per AS email, "
            + "FEC_PLAZO AS fecha_vencimiento, "
            + "v.FEC_LIQUIDACION AS fecha_liquidacion, "
            + "v.PROGRAMA as programa, "
            + "v.total AS valor_con_iva, "
            + "v.VAL_PAGADO AS valor_final_pagado "
            + "FROM USINU.SRC_VIS_LIQ_MATRICULA v, usinu.bas_tercero b "
            + "WHERE b.num_identificacion=v.IDENTIFICACION "
            + "AND v.PERIODO = ? "
            + "AND v.NOM_EST_LIQUIDACION LIKE '%Liquid%' "
            + "AND v.IDENTIFICACION = ? "
            + "AND (v.CONCEPTO LIKE '%MATRICULA %PREGRA%' OR v.CONCEPTO LIKE '%MATRICULA %POST%') "
            + "AND v.VAL_PAGADO IS null";
    
    /**
     * Return data of pay pending inscription
     *
     * @param query_pay
     * @return *
     */
    public List<Tbl_query_pay_mat> get_pay(Tbl_query_pay_mat query_pay, String cod_period) {
        Tbl_query_pay_mat tbl_qpay;
        List<Tbl_query_pay_mat> list_tbl_qpay = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, cod_period);
            stmt.setString(2, query_pay.getNum_identificacion());
            rs = stmt.executeQuery();

            while (rs.next()) {
                tbl_qpay = new Tbl_query_pay_mat();
                tbl_qpay.setNum_recibo(rs.getInt("num_recibo"));
                tbl_qpay.setNum_identificacion(rs.getString("num_identificacion"));
                tbl_qpay.setNombre_largo(rs.getString("NOM_LARGO"));
                tbl_qpay.setEmail(rs.getString("email"));
                tbl_qpay.setFecha_liquidacion(rs.getDate("fecha_liquidacion"));
                tbl_qpay.setFecha_pago_matricula(rs.getDate("fecha_vencimiento"));
                tbl_qpay.setNombre_unidad(rs.getString("programa"));                
                tbl_qpay.setValor_matricula(rs.getString("valor_con_iva"));
                tbl_qpay.setValor_pagado(rs.getString("valor_final_pagado"));
                list_tbl_qpay.add(tbl_qpay);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return list_tbl_qpay;
    }
}
