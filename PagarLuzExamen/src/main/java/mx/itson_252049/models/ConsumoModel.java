/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models;

import mx.itson_252049.models.entitys.Cliente;
import mx.itson_252049.models.entitys.Consumo;

/**
 *
 * @author Cricri
 */
public class ConsumoModel {

    private ClienteModel clienteModel;

    public ConsumoModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    /**
     * Obtiene el consumo actual de un cliente a partir de su número de servicio.
     * @param numeroServicio Número de servicio del cliente.
     * @return Consumo actual o null si no se encuentra.
     */
    public Consumo obtenerDatosConsumo(String numeroServicio) {
        Cliente cliente = clienteModel.buscarPorNumeroServicio(numeroServicio)
                                      .stream()
                                      .findFirst()
                                      .orElse(null);

        if (cliente != null && !cliente.obtenerConsumos().isEmpty()) {
            // Retorna el último consumo registrado
            return cliente.obtenerConsumos()
                          .get(cliente.obtenerConsumos().size() - 1);
        }
        return null;
    }
}


