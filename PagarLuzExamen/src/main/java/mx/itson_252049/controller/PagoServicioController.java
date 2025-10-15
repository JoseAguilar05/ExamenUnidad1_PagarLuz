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
import mx.itson_252049.models.exception.ValidacionTarjetaException;

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

    
    public List<Cliente> buscarPorNumeroServicio(String numeroServicio) {
        return clienteModel.buscarPorNumeroServicio(numeroServicio);
    }

 
    public Consumo obtenerDatosConsumo(String numeroServicio) {
        return consumoModel.obtenerDatosConsumo(numeroServicio);
    }

  
    public void confirmarPago(Cliente cliente, Consumo consumo, String numeroTarjeta) {
      
        Tarjeta tarjeta = tarjetaModel.crearTarjeta(numeroTarjeta);

     
        if (!tarjetaModel.validarTarjeta(tarjeta)) {
  
            throw new IllegalArgumentException("Tarjeta no válida. Debe tener 16 dígitos y estar vigente.");
        }

        reciboModel.generaRecibo(cliente, consumo, tarjeta);
    }
    
    
    public Cliente seleccionarCliente(int idCliente) {
        return clienteModel.seleccionarCliente(idCliente);
    }
}