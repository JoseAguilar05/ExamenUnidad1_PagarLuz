/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import mx.itson_252049.models.entitys.Cliente;
import mx.itson_252049.models.entitys.Consumo;
import mx.itson_252049.models.enums.EstadoConsumo;

/**
 *
 * @author Cricri
 */
public class ClienteModel {
   

    // Simulación de base de datos en memoria
    private List<Cliente> clientes = new ArrayList<>();

    public ClienteModel() {
        // Cliente 1 con consumo pendiente
        Cliente c1 = new Cliente(1, "Juan Pérez", "12345", "Calle 1");
        c1.agregarConsumo(new Consumo(1, new Date(), 500.0, EstadoConsumo.PENDIENTE));

        // Cliente 2 con consumo pendiente
        Cliente c2 = new Cliente(2, "María López", "12346", "Calle 2");
        c2.agregarConsumo(new Consumo(2, new Date(), 750.0, EstadoConsumo.PENDIENTE));

        // Cliente 3 con consumo vencido
        Cliente c3 = new Cliente(3, "Carlos Ruiz", "98765", "Calle 3");
        c3.agregarConsumo(new Consumo(3, new Date(), 1200.0, EstadoConsumo.VENCIDO));

        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
    }

    /**
     * Busca clientes cuyo número de servicio contenga el criterio ingresado.
     * @param numero Número de servicio (o parte de él).
     * @return Lista de clientes que cumplen con el criterio.
     */
    public List<Cliente> buscarPorNumeroServicio(String numero) {
        return clientes.stream()
                .filter(c -> c.getNumeroServicio().contains(numero))
                .collect(Collectors.toList());
    }

    /**
     * Selecciona un cliente por su ID.
     * @param idCliente Identificador único del cliente.
     * @return Cliente encontrado o null si no existe.
     */
    public Cliente seleccionarCliente(int idCliente) {
        return clientes.stream()
                .filter(c -> c.getIdCliente() == idCliente)
                .findFirst()
                .orElse(null);
    }

    /**
     * Método auxiliar para agregar clientes a la lista (simulación de persistencia).
     */
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
     * Devuelve todos los clientes registrados.
     */
    public List<Cliente> obtenerTodos() {
        return clientes;
    }
}



