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
public class Recibo {

    private int idRecibo;
    private Date fechaPago;
    private double montoPagado;
    private String numeroAutorizacion;

    public Recibo(int idRecibo, Date fechaPago, double montoPagado, String numeroAutorizacion) {
        this.idRecibo = idRecibo;
        this.fechaPago = fechaPago;
        this.montoPagado = montoPagado;
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public int getIdRecibo() { return idRecibo; }
    public void setIdRecibo(int idRecibo) { this.idRecibo = idRecibo; }

    public Date getFechaPago() { return fechaPago; }
    public void setFechaPago(Date fechaPago) { this.fechaPago = fechaPago; }

    public double getMontoPagado() { return montoPagado; }
    public void setMontoPagado(double montoPagado) { this.montoPagado = montoPagado; }

    public String getNumeroAutorizacion() { return numeroAutorizacion; }
    public void setNumeroAutorizacion(String numeroAutorizacion) { this.numeroAutorizacion = numeroAutorizacion; }

        @Override
     public String toString() {
         return "=== RECIBO DE PAGO ===\n" +
                "ID Recibo: " + idRecibo + "\n" +
                "Fecha de pago: " + fechaPago + "\n" +
                "Monto pagado: $" + montoPagado + "\n" +
                "Número de autorización: " + numeroAutorizacion;
     }

    
}


