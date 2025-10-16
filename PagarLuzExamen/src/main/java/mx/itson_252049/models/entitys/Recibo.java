/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models.entitys;


import java.util.Date;

/**
 * Representa un recibo de pago generado tras realizar un consumo.
 * 
 * <p>El recibo contiene información sobre el pago efectuado, como su
 * identificador, fecha, monto, número de autorización y la tarjeta utilizada.</p>
 * 
 * <p>Esta clase forma parte del modelo de dominio y se asocia a la clase
 * {@link Consumo} para registrar el comprobante de un pago exitoso.</p>
 * 
 * @author Jose Aguilar
 */
public class Recibo {
    
    /** Identificador único del recibo. */
    private int idRecibo;

    /** Fecha en la que se realizó el pago. */
    private Date fechaPago;

    /** Monto total pagado en el recibo. */
    private double montoPagado;

    /** Número de autorización del pago (emitido por el sistema o entidad bancaria). */
    private String numeroAutorizacion;

    /** Tarjeta utilizada para realizar el pago. */
    private Tarjeta tarjeta;

    /**
     * Crea un nuevo recibo con los datos especificados.
     * 
     * @param idRecibo identificador único del recibo
     * @param fechaPago fecha en que se realizó el pago
     * @param montoPagado monto total pagado
     * @param numeroAutorizacion número de autorización del pago
     */
    public Recibo(int idRecibo, Date fechaPago, double montoPagado, String numeroAutorizacion) {
        this.idRecibo = idRecibo;
        this.fechaPago = fechaPago;
        this.montoPagado = montoPagado;
        this.numeroAutorizacion = numeroAutorizacion;
    }

    /** @return el identificador del recibo */
    public int getIdRecibo() { return idRecibo; }

    /** @param idRecibo nuevo identificador del recibo */
    public void setIdRecibo(int idRecibo) { this.idRecibo = idRecibo; }

    /** @return la fecha en que se realizó el pago */
    public Date getFechaPago() { return fechaPago; }

    /** @param fechaPago nueva fecha del pago */
    public void setFechaPago(Date fechaPago) { this.fechaPago = fechaPago; }

    /** @return el monto total pagado */
    public double getMontoPagado() { return montoPagado; }

    /** @param montoPagado nuevo monto total del pago */
    public void setMontoPagado(double montoPagado) { this.montoPagado = montoPagado; }

    /** @return el número de autorización del pago */
    public String getNumeroAutorizacion() { return numeroAutorizacion; }

    /** @param numeroAutorizacion nuevo número de autorización */
    public void setNumeroAutorizacion(String numeroAutorizacion) { this.numeroAutorizacion = numeroAutorizacion; }

    /** 
     * Asocia una tarjeta al recibo, representando el medio de pago utilizado.
     * 
     * @param tarjeta objeto {@link Tarjeta} usado para el pago
     */
    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    /** 
     * Obtiene la tarjeta asociada al recibo.
     * 
     * @return tarjeta utilizada para realizar el pago
     */
    public Tarjeta getTarjeta() {
        return this.tarjeta;
    }

    /**
     * Devuelve una representación textual del recibo, con su información
     * formateada en varias líneas.
     * 
     * @return cadena de texto con los datos principales del recibo
     */
    public String getFormateado() {
        return "=== RECIBO DE PAGO ===\n" +
               "ID Recibo: " + idRecibo + "\n" +
               "Fecha de pago: " + fechaPago + "\n" +
               "Monto pagado: $" + montoPagado + "\n" +
               "Número de autorización: " + numeroAutorizacion;
    }
}
