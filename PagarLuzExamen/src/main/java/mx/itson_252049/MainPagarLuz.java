/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.itson_252049;

import mx.itson_252049.controller.PagoServicioController;
import mx.itson_252049.models.ClienteModel;
import mx.itson_252049.models.ConsumoModel;
import mx.itson_252049.models.ReciboModel;
import mx.itson_252049.models.TarjetaModel;
import mx.itson_252049.views.PagoServicioFrame;

import javax.swing.SwingUtilities;
/**
 * Clase principal que inicia la aplicación de pago de servicios de luz.
 * 
 * <p>Este punto de entrada realiza la inicialización de todos los modelos
 * ({@link ClienteModel}, {@link ConsumoModel}, {@link TarjetaModel}, {@link ReciboModel}),
 * el controlador {@link PagoServicioController} y la interfaz gráfica {@link PagoServicioFrame}.</p>
 * 
 * <p>Se asegura que la interfaz gráfica se ejecute en el hilo de despacho de eventos
 * de Swing utilizando <code>SwingUtilities.invokeLater</code>.</p>
 * 
 * <p>También se registra la vista como observadora del modelo de recibos
 * para recibir notificaciones cada vez que se genere un nuevo recibo.</p>
 * 
 * Autor: Cricri
 */
public class MainPagarLuz {

    /**
     * Método principal de la aplicación.
     * 
     * @param args argumentos de línea de comando (no utilizados)
     */
    public static void main(String[] args) {
       
        // Inicialización de modelos
        ClienteModel clienteModel = new ClienteModel();
        ConsumoModel consumoModel = new ConsumoModel(clienteModel);
        TarjetaModel tarjetaModel = new TarjetaModel();
        ReciboModel reciboModel = new ReciboModel();

        // Inicialización del controlador
        PagoServicioController controller = new PagoServicioController(
                clienteModel, consumoModel, tarjetaModel, reciboModel
        );

        // Inicialización y despliegue de la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            PagoServicioFrame frame = new PagoServicioFrame(controller);
            reciboModel.addObserver(frame);  // Registro de la vista como observadora
            frame.setVisible(true);
        });
    }
}