package Model;

import java.util.Date;

/**
 *
 * @author Andres Mora
 */
public class Tbl_query_pay_ins {
    private int num_formulario;
    private String num_identificacion;
    private String nombre_largo;
    private String email;
    private Date fecha_venta;
    private String nombre_unidad;
    private String valor_inscripcion;
    private Date fecha_pago_inscripcion;
    private String valor_pagado;
    
    public Tbl_query_pay_ins() {
    }
    
    public Tbl_query_pay_ins(String num_identificacion) {
        this.num_identificacion = num_identificacion;
    }

    public Tbl_query_pay_ins(int num_formulario, String num_identificacion, String nombre_largo, String email, Date fecha_venta, String nombre_unidad, String valor_inscripcion, Date fecha_pago_inscripcion, String valor_pagado) {
        this.num_formulario = num_formulario;
        this.num_identificacion = num_identificacion;
        this.nombre_largo = nombre_largo;
        this.email = email;
        this.fecha_venta = fecha_venta;
        this.nombre_unidad = nombre_unidad;
        this.valor_inscripcion = valor_inscripcion;
        this.fecha_pago_inscripcion = fecha_pago_inscripcion;
        this.valor_pagado = valor_pagado;
    }

    public int getNum_formulario() {
        return num_formulario;
    }

    public void setNum_formulario(int num_formulario) {
        this.num_formulario = num_formulario;
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

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getNombre_unidad() {
        return nombre_unidad;
    }

    public void setNombre_unidad(String nombre_unidad) {
        this.nombre_unidad = nombre_unidad;
    }

    public String getValor_inscripcion() {
        return valor_inscripcion;
    }

    public void setValor_inscripcion(String valor_inscripcion) {
        this.valor_inscripcion = valor_inscripcion;
    }

    public Date getFecha_pago_inscripcion() {
        return fecha_pago_inscripcion;
    }

    public void setFecha_pago_inscripcion(Date fecha_pago_inscripcion) {
        this.fecha_pago_inscripcion = fecha_pago_inscripcion;
    }    
    
    public String getValor_pagado(){
        return valor_pagado;
    }
    
    public void setValor_pagado(String valor_pagado){
        this.valor_pagado = valor_pagado;
    }
}
