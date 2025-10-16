/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models.entitys;

import java.util.Date;
import mx.itson_252049.models.enums.EstadoConsumo;

/**
 * Representa un consumo realizado por un cliente dentro del sistema.
 * 
 * <p>Un consumo contiene información sobre la fecha en que ocurrió,
 * el monto asociado, su estado actual y el recibo vinculado (si aplica).</p>
 * 
 * <p>Esta clase forma parte del modelo de dominio y permite calcular
 * el monto, actualizar su estado y acceder a sus datos asociados.</p>
 * 
 * @author Jose Aguilar
 */
public class Consumo {
 

    /** Identificador único del consumo. */
    private int idConsumo;

    /** Fecha en la que se registró el consumo. */
    private Date fechaConsumo;

    /** Monto total del consumo. */
    private double montoConsumo;

    /** Estado actual del consumo (por ejemplo: PENDIENTE, PAGADO, CANCELADO). */
    private EstadoConsumo estado;

    /** Recibo asociado al consumo, si existe. */
    private Recibo recibo; 

    /**
     * Crea un nuevo consumo con los datos especificados.
     * 
     * @param idConsumo identificador único del consumo
     * @param fechaConsumo fecha en la que ocurrió el consumo
     * @param montoConsumo monto total del consumo
     * @param estado estado actual del consumo
     */
    public Consumo(int idConsumo, Date fechaConsumo, double montoConsumo, EstadoConsumo estado) {
        this.idConsumo = idConsumo;
        this.fechaConsumo = fechaConsumo;
        this.montoConsumo = montoConsumo;
        this.estado = estado;
    }

    /**
     * Calcula el monto total del consumo.
     * 
     * <p>En esta implementación devuelve directamente el monto,
     * pero puede ser extendida para aplicar descuentos o recargos.</p>
     * 
     * @return monto total del consumo
     */
    public double calcularMonto() {
        return montoConsumo;
    }

    /**
     * Actualiza el estado actual del consumo.
     * 
     * @param nuevoEstado nuevo estado a asignar al consumo
     */
    public void actualizarEstado(EstadoConsumo nuevoEstado) {
        this.estado = nuevoEstado;
    }

    /** @return el identificador del consumo */
    public int getIdConsumo() { return idConsumo; }

    /** @param idConsumo nuevo identificador del consumo */
    public void setIdConsumo(int idConsumo) { this.idConsumo = idConsumo; }

    /** @return la fecha del consumo */
    public Date getFechaConsumo() { return fechaConsumo; }

    /** @param fechaConsumo nueva fecha del consumo */
    public void setFechaConsumo(Date fechaConsumo) { this.fechaConsumo = fechaConsumo; }

    /** @return el monto del consumo */
    public double getMontoConsumo() { return montoConsumo; }

    /** @param montoConsumo nuevo monto del consumo */
    public void setMontoConsumo(double montoConsumo) { this.montoConsumo = montoConsumo; }

    /** @return el estado del consumo */
    public EstadoConsumo getEstado() { return estado; }

    /** @param estado nuevo estado del consumo */
    public void setEstado(EstadoConsumo estado) { this.estado = estado; }

    /** @return el recibo asociado al consumo */
    public Recibo getRecibo() { return recibo; }

    /** @param recibo nuevo recibo asociado al consumo */
    public void setRecibo(Recibo recibo) { this.recibo = recibo; }

    /**
     * Devuelve una representación textual del consumo, mostrando
     * su identificador, fecha, monto y estado actual.
     * 
     * @return cadena con los datos básicos del consumo
     */
    @Override
    public String toString() {
        return "Consumo{" +
                "idConsumo=" + idConsumo +
                ", fechaConsumo=" + fechaConsumo +
                ", montoConsumo=" + montoConsumo +
                ", estado=" + estado +
                '}';
    }
}


