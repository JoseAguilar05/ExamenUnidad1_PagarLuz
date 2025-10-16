/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models;

import mx.itson_252049.models.entitys.Cliente;
import mx.itson_252049.models.entitys.Consumo;
/**
 * Modelo encargado de administrar la información de los consumos
 * asociados a los clientes del sistema.
 * 
 * <p>Esta clase pertenece a la capa de modelo dentro del patrón MVC
 * (Model-View-Controller) y se encarga de obtener los datos de consumo
 * relacionados con un cliente específico, utilizando el modelo de clientes.</p>
 * 
 * <p>El objetivo principal de este modelo es proveer métodos de consulta
 * para acceder a los consumos actuales o históricos de los clientes.</p>
 * 
 * @author Cricri
 */
public class ConsumoModel {

    /** Referencia al modelo de clientes, utilizado para acceder a sus datos. */
    private ClienteModel clienteModel;

    /**
     * Crea una nueva instancia del modelo de consumos, asociada a un modelo de clientes.
     * 
     * @param clienteModel instancia de {@link ClienteModel} utilizada para acceder a los datos de los clientes
     */
    public ConsumoModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    /**
     * Obtiene el consumo más reciente de un cliente a partir de su número de servicio.
     * 
     * <p>Este método busca al cliente cuyo número de servicio coincida con el valor proporcionado.
     * Si el cliente tiene consumos registrados, se retorna el último consumo (considerado el más actual).</p>
     * 
     * @param numeroServicio número de servicio del cliente
     * @return el último {@link Consumo} registrado del cliente, o {@code null} si no se encuentra el cliente o no tiene consumos
     */
    public Consumo obtenerDatosConsumo(String numeroServicio) {
        Cliente cliente = clienteModel.buscarPorNumeroServicio(numeroServicio)
                                      .stream()
                                      .findFirst()
                                      .orElse(null);

        if (cliente != null && !cliente.obtenerConsumos().isEmpty()) {
            // Retorna el último consumo registrado del cliente
            return cliente.obtenerConsumos()
                          .get(cliente.obtenerConsumos().size() - 1);
        }
        return null;
    }
}
