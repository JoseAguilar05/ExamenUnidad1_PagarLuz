/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models.entitys;

import java.util.Date;
import mx.itson_252049.models.enums.EstadoConsumo;

/**
 *
 * @author Jose Aguilar
 */
public class Consumo {
 

    private int idConsumo;
    private Date fechaConsumo;
    private double montoConsumo;
    private EstadoConsumo estado;

    public Consumo(int idConsumo, Date fechaConsumo, double montoConsumo, EstadoConsumo estado) {
        this.idConsumo = idConsumo;
        this.fechaConsumo = fechaConsumo;
        this.montoConsumo = montoConsumo;
        this.estado = estado;
    }

    public double calcularMonto() {
        return montoConsumo;
    }

    public void actualizarEstado(EstadoConsumo nuevoEstado) {
        this.estado = nuevoEstado;
    }

    
    public int getIdConsumo() { return idConsumo; }
    public void setIdConsumo(int idConsumo) { this.idConsumo = idConsumo; }

    public Date getFechaConsumo() { return fechaConsumo; }
    public void setFechaConsumo(Date fechaConsumo) { this.fechaConsumo = fechaConsumo; }

    public double getMontoConsumo() { return montoConsumo; }
    public void setMontoConsumo(double montoConsumo) { this.montoConsumo = montoConsumo; }

    public EstadoConsumo getEstado() { return estado; }
    public void setEstado(EstadoConsumo estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Consumo{" + "idConsumo=" + idConsumo + ", fechaConsumo=" + fechaConsumo + ", montoConsumo=" + montoConsumo + ", estado=" + estado + '}';
    }
    
    
}


