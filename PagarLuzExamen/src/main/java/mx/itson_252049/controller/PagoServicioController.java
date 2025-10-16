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
 * Controlador encargado de coordinar el flujo de pago de servicios
 * dentro del sistema.
 * 
 * <p>Esta clase forma parte de la capa Controller del patrón MVC y se encarga
 * de mediar entre los modelos ({@link ClienteModel}, {@link ConsumoModel}, 
 * {@link TarjetaModel}, {@link ReciboModel}) y la lógica de negocio relacionada
 * con la búsqueda de clientes, obtención de consumos y generación de pagos.</p>
 * 
 * <p>El controlador expone métodos para buscar clientes, seleccionar clientes,
 * obtener datos de consumo y confirmar pagos mediante tarjetas bancarias.</p>
 * 
 * <p>Responsabilidades:
 * <ul>
 *   <li>Buscar clientes por número de servicio.</li>
 *   <li>Obtener el consumo actual de un cliente.</li>
 *   <li>Validar tarjetas y generar recibos de pago.</li>
 *   <li>Seleccionar clientes por su identificador.</li>
 * </ul>
 * </p>
 * 
 * @author Cricri
 */
public class PagoServicioController {
 
    /** Modelo que gestiona los clientes. */
    private ClienteModel clienteModel;

    /** Modelo que gestiona los consumos de los clientes. */
    private ConsumoModel consumoModel;

    /** Modelo que gestiona la creación y validación de tarjetas. */
    private TarjetaModel tarjetaModel;

    /** Modelo que gestiona la generación de recibos. */
    private ReciboModel reciboModel;

    /**
     * Crea una nueva instancia del controlador de pago de servicios.
     * 
     * @param clienteModel modelo de clientes
     * @param consumoModel modelo de consumos
     * @param tarjetaModel modelo de tarjetas
     * @param reciboModel modelo de recibos
     */
    public PagoServicioController(ClienteModel clienteModel, ConsumoModel consumoModel,
                                  TarjetaModel tarjetaModel, ReciboModel reciboModel) {
        this.clienteModel = clienteModel;
        this.consumoModel = consumoModel;
        this.tarjetaModel = tarjetaModel;
        this.reciboModel = reciboModel;
    }

    /**
     * Busca clientes cuyo número de servicio contenga el texto especificado.
     * 
     * @param numeroServicio número de servicio parcial o completo
     * @return lista de {@link Cliente} cuyo número de servicio coincide
     */
    public List<Cliente> buscarPorNumeroServicio(String numeroServicio) {
        return clienteModel.buscarPorNumeroServicio(numeroServicio);
    }

    /**
     * Obtiene el consumo más reciente de un cliente a partir de su número de servicio.
     * 
     * @param numeroServicio número de servicio del cliente
     * @return objeto {@link Consumo} más reciente, o {@code null} si no existe
     */
    public Consumo obtenerDatosConsumo(String numeroServicio) {
        return consumoModel.obtenerDatosConsumo(numeroServicio);
    }

    /**
     * Confirma el pago de un consumo realizado por un cliente.
     * 
     * <p>El método realiza los siguientes pasos:
     * <ol>
     *   <li>Crea una tarjeta a partir del número proporcionado.</li>
     *   <li>Valida la tarjeta mediante {@link TarjetaModel}.</li>
     *   <li>Genera un recibo y actualiza el estado del consumo a PAGADO mediante {@link ReciboModel}.</li>
     * </ol></p>
     * 
     * @param cliente cliente que realiza el pago
     * @param consumo consumo que se está pagando
     * @param numeroTarjeta número de la tarjeta utilizada para el pago
     * @throws ValidacionTarjetaException si la tarjeta no es válida
     */
    public void confirmarPago(Cliente cliente, Consumo consumo, String numeroTarjeta) {
        Tarjeta tarjeta = tarjetaModel.crearTarjeta(numeroTarjeta);
        tarjetaModel.validarTarjeta(tarjeta);
        reciboModel.generaRecibo(cliente, consumo, tarjeta);
    }

    /**
     * Selecciona un cliente según su identificador único.
     * 
     * @param idCliente identificador del cliente
     * @return objeto {@link Cliente} correspondiente al ID, o {@code null} si no existe
     */
    public Cliente seleccionarCliente(int idCliente) {
        return clienteModel.seleccionarCliente(idCliente);
    }
}