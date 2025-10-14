/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.controller;


import java.util.List;
import mx.itson_252049.models.ClienteModel;
import mx.itson_252049.models.ConsumoModel;
import mx.itson_252049.models.ReciboModel;
import mx.itson_252049.models.TarjetaModel;
import mx.itson_252049.models.entitys.Cliente;
import mx.itson_252049.models.entitys.Consumo;
import mx.itson_252049.models.entitys.Recibo;
import mx.itson_252049.models.entitys.Tarjeta;

/**
 *
 * @author Cricri
 */
public class PagoServicioController {
 
    private ClienteModel clienteModel;
    private ConsumoModel consumoModel;
    private TarjetaModel tarjetaModel;
    private ReciboModel reciboModel;

    public PagoServicioController(ClienteModel clienteModel, ConsumoModel consumoModel,
                                  TarjetaModel tarjetaModel, ReciboModel reciboModel) {
        this.clienteModel = clienteModel;
        this.consumoModel = consumoModel;
        this.tarjetaModel = tarjetaModel;
        this.reciboModel = reciboModel;
    }

    /**
     * Paso 1: Buscar clientes por número de servicio.
     */
    public List<Cliente> buscarPorNumeroServicio(String numeroServicio) {
        return clienteModel.buscarPorNumeroServicio(numeroServicio);
    }

    /**
     * Paso 2: Seleccionar cliente por ID.
     */
    public Cliente seleccionarCliente(int idCliente) {
        return clienteModel.seleccionarCliente(idCliente);
    }

    /**
     * Paso 3: Obtener datos de consumo de un cliente.
     */
    public Consumo obtenerDatosConsumo(String numeroServicio) {
        return consumoModel.obtenerDatosConsumo(numeroServicio);
    }

    /**
     * Paso 4: Validar tarjeta.
     */
    public boolean validarTarjeta(Tarjeta tarjeta) {
        return tarjetaModel.validarTarjeta(tarjeta);
    }

    /**
     * Paso 5: Generar recibo de pago.
     */
    public Recibo generarRecibo(Cliente cliente, Consumo consumo, Tarjeta tarjeta) {
        reciboModel.generaRecibo(cliente, consumo, tarjeta);
        return reciboModel.getReciboGenerado();
    }
}
   

