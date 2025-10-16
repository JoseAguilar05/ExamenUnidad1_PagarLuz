/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import mx.itson_252049.models.entitys.Cliente;
import mx.itson_252049.models.entitys.Consumo;
import mx.itson_252049.models.enums.EstadoConsumo;


/**
 * Modelo que administra la información de los clientes en el sistema.
 * 
 * <p>Esta clase forma parte de la capa de modelo del patrón MVC (Model-View-Controller)
 * y se encarga de manejar la lista de clientes, así como las operaciones de búsqueda,
 * selección y registro de nuevos clientes.</p>
 * 
 * <p>Durante su creación, inicializa algunos datos de ejemplo con clientes y consumos
 * asociados, para propósitos de demostración o prueba.</p>
 * 
 * @author Jose Aguilar
 */
public class ClienteModel {
   
    /** Lista de clientes registrados en el sistema. */
    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Constructor que inicializa el modelo con algunos clientes de ejemplo.
     */
    public ClienteModel() {
        inicializarClientes();
    }

    /**
     * Inicializa una lista de clientes de ejemplo con consumos asociados.
     * 
     * <p>Este método carga datos de manera manual con el fin de simular
     * un conjunto inicial de clientes registrados en el sistema.</p>
     */
    private void inicializarClientes() {
        Cliente c1 = new Cliente(1, "Juan Pérez", "12345", "Calle 1");
        c1.agregarConsumo(new Consumo(1, new Date(), 500.0, EstadoConsumo.PENDIENTE));

        Cliente c2 = new Cliente(2, "María López", "12346", "Calle 2");
        c2.agregarConsumo(new Consumo(2, new Date(), 750.0, EstadoConsumo.PENDIENTE));

        Cliente c3 = new Cliente(3, "Carlos Ruiz", "98765", "Calle 3");
        c3.agregarConsumo(new Consumo(3, new Date(), 1200.0, EstadoConsumo.VENCIDO));

        clientes.addAll(Arrays.asList(c1, c2, c3));
    }

    /**
     * Busca clientes cuyo número de servicio contenga el texto especificado.
     * 
     * @param numero texto parcial o completo del número de servicio a buscar
     * @return lista de clientes cuyo número de servicio coincide con el texto buscado
     */
    public List<Cliente> buscarPorNumeroServicio(String numero) {
        return clientes.stream()
                .filter(c -> c.getNumeroServicio().contains(numero))
                .collect(Collectors.toList());
    }

    /**
     * Selecciona un cliente según su identificador único.
     * 
     * @param idCliente identificador del cliente a buscar
     * @return el cliente con el id especificado, o {@code null} si no existe
     */
    public Cliente seleccionarCliente(int idCliente) {
        return clientes.stream()
                .filter(c -> c.getIdCliente() == idCliente)
                .findFirst()
                .orElse(null);
    }

    /**
     * Agrega un nuevo cliente a la lista de clientes registrados.
     * 
     * @param cliente objeto {@link Cliente} que se desea registrar
     */
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
     * Obtiene la lista completa de clientes registrados en el sistema.
     * 
     * @return lista de objetos {@link Cliente}
     */
    public List<Cliente> obtenerTodos() {
        return clientes;
    }
}