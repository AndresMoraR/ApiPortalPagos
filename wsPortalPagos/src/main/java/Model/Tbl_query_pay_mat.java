/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author estfa
 */
public class Tbl_query_pay_mat {
    private int num_recibo;
    private String num_identificacion;
    private String nombre_largo;
    private String email;
    private Date fecha_liquidacion;
    private String nombre_unidad;
    private String valor_matricula;
    private Date fecha_pago_matricula;
    private String valor_pagado;

    public Tbl_query_pay_mat() {
    }

    public Tbl_query_pay_mat(String num_identificacion) {
        this.num_identificacion = num_identificacion;
    }
    
    public Tbl_query_pay_mat(int num_recibo, String num_identificacion, String nombre_largo, String email, Date fecha_liquidacion,String nombre_unidad, String valor_matricula, Date fecha_pago_matricula) {
        this.num_recibo = num_recibo;
        this.num_identificacion = num_identificacion;
        this.nombre_largo = nombre_largo;
        this.email = email;
        this.fecha_liquidacion = fecha_liquidacion;
        this.nombre_unidad = nombre_unidad;
        this.valor_matricula = valor_matricula;
        this.fecha_pago_matricula = fecha_pago_matricula;
    }

    public int getNum_recibo() {
        return num_recibo;
    }

    public void setNum_recibo(int num_recibo) {
        this.num_recibo = num_recibo;
    }

    public String getNum_identificacion() {
        return num_identificacion;
    }

    public void setNum_identificacion(String num_identificacion) {
        this.num_identificacion = num_identificacion;
    }

    public String getNombre_largo() {
        return nombre_largo;
    }

    public void setNombre_largo(String nombre_largo) {
        this.nombre_largo = nombre_largo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getFecha_liquidacion() {
        return fecha_liquidacion;
    }

    public void setFecha_liquidacion(Date fecha_liquidacion) {
        this.fecha_liquidacion = fecha_liquidacion;
    }

    public String getNombre_unidad() {
        return nombre_unidad;
    }

    public void setNombre_unidad(String nombre_unidad) {
        this.nombre_unidad = nombre_unidad;
    }

    public String getValor_matricula() {
        return valor_matricula;
    }

    public void setValor_matricula(String valor_matricula) {
        this.valor_matricula = valor_matricula;
    }

    public Date getFecha_pago_matricula() {
        return fecha_pago_matricula;
    }

    public void setFecha_pago_matricula(Date fecha_pago_matricula) {
        this.fecha_pago_matricula = fecha_pago_matricula;
    }

    public String getValor_pagado() {
        return valor_pagado;
    }

    public void setValor_pagado(String valor_pagado) {
        this.valor_pagado = valor_pagado;
    }        
}
