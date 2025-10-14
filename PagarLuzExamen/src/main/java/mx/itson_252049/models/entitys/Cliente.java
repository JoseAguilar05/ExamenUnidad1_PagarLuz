/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models.entitys;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose Aguilar
 */
public class Cliente {
   
    private int idCliente;
    private String nombre;
    private String numeroServicio;
    private String direccion;
    private List<Consumo> consumos = new ArrayList<>();

    public Cliente(int idCliente, String nombre, String numeroServicio, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.numeroServicio = numeroServicio;
        this.direccion = direccion;
    }

    public List<Consumo> obtenerConsumos() {
        return consumos;
    }

  
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNumeroServicio() { return numeroServicio; }
    public void setNumeroServicio(String numeroServicio) { this.numeroServicio = numeroServicio; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public void agregarConsumo(Consumo consumo) {
        this.consumos.add(consumo);
    }

        @Override
    public String toString() {
        return idCliente + " - " + nombre + " (Numero de Servicio: " + numeroServicio + ")";
    }

    
}


