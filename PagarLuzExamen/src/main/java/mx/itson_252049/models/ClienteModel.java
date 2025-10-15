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
 *
 * @author Cricri
 */
public class ClienteModel {
   
    private List<Cliente> clientes = new ArrayList<>();

    public ClienteModel() {
        inicializarClientes();
    }

    private void inicializarClientes() {
        Cliente c1 = new Cliente(1, "Juan Pérez", "12345", "Calle 1");
        c1.agregarConsumo(new Consumo(1, new Date(), 500.0, EstadoConsumo.PENDIENTE));

        Cliente c2 = new Cliente(2, "María López", "12346", "Calle 2");
        c2.agregarConsumo(new Consumo(2, new Date(), 750.0, EstadoConsumo.PENDIENTE));

        Cliente c3 = new Cliente(3, "Carlos Ruiz", "98765", "Calle 3");
        c3.agregarConsumo(new Consumo(3, new Date(), 1200.0, EstadoConsumo.VENCIDO));

        clientes.addAll(Arrays.asList(c1, c2, c3));
    }

    public List<Cliente> buscarPorNumeroServicio(String numero) {
        return clientes.stream()
                .filter(c -> c.getNumeroServicio().contains(numero))
                .collect(Collectors.toList());
    }

    public Cliente seleccionarCliente(int idCliente) {
        return clientes.stream()
                .filter(c -> c.getIdCliente() == idCliente)
                .findFirst()
                .orElse(null);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> obtenerTodos() {
        return clientes;
    }
}
