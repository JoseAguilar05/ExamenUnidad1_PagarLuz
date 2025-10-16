/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models.entitys;

import java.util.Date;
/**
 * Representa una tarjeta bancaria utilizada para realizar pagos.
 * 
 * <p>La clase almacena información básica de la tarjeta como su número,
 * tipo (por ejemplo, crédito o débito), banco emisor y fecha de vencimiento.
 * También incluye métodos para validar el formato del número y verificar
 * si la tarjeta sigue vigente.</p>
 * 
 * <p>Esta clase es utilizada por {@link Recibo} para registrar el medio de pago
 * asociado a un consumo.</p>
 * 
 * @author Cricri
 */
public class Tarjeta {
  
    /** Número de la tarjeta bancaria (16 dígitos). */
    private String numeroTarjeta;

    /** Tipo de tarjeta (por ejemplo: "Crédito" o "Débito"). */
    private String tipo;

    /** Nombre del banco emisor de la tarjeta. */
    private String banco;

    /** Fecha de vencimiento de la tarjeta. */
    private Date fechaVencimiento;

    /**
     * Crea una nueva tarjeta con los datos especificados.
     * 
     * @param numeroTarjeta número de tarjeta (debe tener 16 dígitos)
     * @param tipo tipo de tarjeta (Crédito/Débito)
     * @param banco banco emisor
     * @param fechaVencimiento fecha de vencimiento de la tarjeta
     */
    public Tarjeta(String numeroTarjeta, String tipo, String banco, Date fechaVencimiento) {
        this.numeroTarjeta = numeroTarjeta;
        this.tipo = tipo;
        this.banco = banco;
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Valida si la tarjeta es válida.
     * 
     * <p>Para que una tarjeta se considere válida debe cumplir con los siguientes criterios:
     * <ul>
     *   <li>El número no debe ser nulo.</li>
     *   <li>Debe tener exactamente 16 dígitos numéricos.</li>
     *   <li>Debe encontrarse vigente (no vencida).</li>
     * </ul></p>
     * 
     * @return {@code true} si la tarjeta es válida, {@code false} en caso contrario
     */
    public boolean validarTarjeta() {
        return numeroTarjeta != null && numeroTarjeta.matches("\\d{16}") && esVigente();
    }

    /**
     * Verifica si la tarjeta se encuentra vigente.
     * 
     * <p>Una tarjeta se considera vigente si su fecha de vencimiento es posterior
     * a la fecha actual.</p>
     * 
     * @return {@code true} si la tarjeta está vigente, {@code false} si está vencida
     */
    public boolean esVigente() {
        return fechaVencimiento.after(new Date());
    }

    /** @return el número de la tarjeta */
    public String getNumeroTarjeta() { return numeroTarjeta; }

    /** @param numeroTarjeta nuevo número de la tarjeta */
    public void setNumeroTarjeta(String numeroTarjeta) { this.numeroTarjeta = numeroTarjeta; }

    /** @return el tipo de la tarjeta */
    public String getTipo() { return tipo; }

    /** @param tipo nuevo tipo de la tarjeta */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /** @return el banco emisor de la tarjeta */
    public String getBanco() { return banco; }

    /** @param banco nuevo banco emisor */
    public void setBanco(String banco) { this.banco = banco; }

    /** @return la fecha de vencimiento de la tarjeta */
    public Date getFechaVencimiento() { return fechaVencimiento; }

    /** @param fechaVencimiento nueva fecha de vencimiento */
    public void setFechaVencimiento(Date fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    /**
     * Devuelve una representación textual de la tarjeta, mostrando su número,
     * tipo, banco y fecha de vencimiento.
     * 
     * @return cadena con los datos principales de la tarjeta
     */
    @Override
    public String toString() {
        return "Tarjeta{" +
                "numeroTarjeta=" + numeroTarjeta +
                ", tipo=" + tipo +
                ", banco=" + banco +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }
}