/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models.entitys;

import java.util.Date;

/**
 *
 * @author Cricri
 */
public class Tarjeta {
  
    private String numeroTarjeta;
    private String tipo;
    private String banco;
    private Date fechaVencimiento;

    public Tarjeta(String numeroTarjeta, String tipo, String banco, Date fechaVencimiento) {
        this.numeroTarjeta = numeroTarjeta;
        this.tipo = tipo;
        this.banco = banco;
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean validarTarjeta() {
        return numeroTarjeta != null && numeroTarjeta.matches("\\d{16}") && esVigente();
    }

    public boolean esVigente() {
        return fechaVencimiento.after(new Date());
    }

   
    public String getNumeroTarjeta() { return numeroTarjeta; }
    public void setNumeroTarjeta(String numeroTarjeta) { this.numeroTarjeta = numeroTarjeta; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getBanco() { return banco; }
    public void setBanco(String banco) { this.banco = banco; }

    public Date getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(Date fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    @Override
    public String toString() {
        return "Tarjeta{" + "numeroTarjeta=" + numeroTarjeta + ", tipo=" + tipo + ", banco=" + banco + ", fechaVencimiento=" + fechaVencimiento + '}';
    }
    
    
}



