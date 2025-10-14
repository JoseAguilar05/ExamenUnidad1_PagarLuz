/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mx.itson_252049.models.entitys.Cliente;

/**
 *
 * @author Cricri
 */
public class ClienteModel {
   

    // Simulación de base de datos en memoria
    private List<Cliente> clientes = new ArrayList<>();

    public ClienteModel() {
       
        clientes.add(new Cliente(1, "Juan Pérez", "12345", "Calle 1"));
        clientes.add(new Cliente(2, "María López", "12346", "Calle 2"));
        clientes.add(new Cliente(3, "Carlos Ruiz", "98765", "Calle 3"));
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
     * @param cliente
     */
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
     * Devuelve todos los clientes registrados.
     * @return 
     */
    public List<Cliente> obtenerTodos() {
        return clientes;
    }
}


