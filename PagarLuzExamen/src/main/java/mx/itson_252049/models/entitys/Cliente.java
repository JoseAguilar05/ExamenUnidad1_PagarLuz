/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models.entitys;

import java.util.ArrayList;
import java.util.List;
/**
 * Representa a un cliente del sistema que cuenta con un número de servicio,
 * dirección y una lista de consumos registrados.
 * 
 * <p>Esta clase almacena la información básica de identificación de un cliente
 * y permite registrar y obtener los consumos asociados a dicho cliente.</p>
 * 
 * @author Jose Aguilar
 */
public class Cliente {
   
   
    /** Identificador único del cliente. */
    private int idCliente;

    /** Nombre completo del cliente. */
    private String nombre;

    /** Número de servicio asociado al cliente (por ejemplo, número de cuenta). */
    private String numeroServicio;

    /** Dirección del cliente. */
    private String direccion;

    /** Lista de consumos asociados al cliente. */
    private List<Consumo> consumos = new ArrayList<>();

    /**
     * Crea un nuevo cliente con los datos especificados.
     * 
     * @param idCliente identificador único del cliente
     * @param nombre nombre del cliente
     * @param numeroServicio número de servicio asociado
     * @param direccion dirección del cliente
     */
    public Cliente(int idCliente, String nombre, String numeroServicio, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.numeroServicio = numeroServicio;
        this.direccion = direccion;
    }

    /**
     * Obtiene la lista de consumos del cliente.
     * 
     * @return lista de objetos {@link Consumo} asociados al cliente
     */
    public List<Consumo> obtenerConsumos() {
        return consumos;
    }

    /** @return el identificador del cliente */
    public int getIdCliente() { return idCliente; }

    /** @param idCliente nuevo identificador del cliente */
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    /** @return el nombre del cliente */
    public String getNombre() { return nombre; }

    /** @param nombre nuevo nombre del cliente */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return el número de servicio del cliente */
    public String getNumeroServicio() { return numeroServicio; }

    /** @param numeroServicio nuevo número de servicio */
    public void setNumeroServicio(String numeroServicio) { this.numeroServicio = numeroServicio; }

    /** @return la dirección del cliente */
    public String getDireccion() { return direccion; }

    /** @param direccion nueva dirección del cliente */
    public void setDireccion(String direccion) { this.direccion = direccion; }

    /**
     * Agrega un nuevo consumo a la lista de consumos del cliente.
     * 
     * @param consumo objeto {@link Consumo} que se desea registrar
     */
    public void agregarConsumo(Consumo consumo) {
        this.consumos.add(consumo);
    }

    /**
     * Devuelve una representación en texto del cliente, incluyendo su id,
     * nombre y número de servicio.
     * 
     * @return cadena con la información básica del cliente
     */
    @Override
    public String toString() {
        return idCliente + " - " + nombre + " (Numero de Servicio: " + numeroServicio + ")";
    }
}