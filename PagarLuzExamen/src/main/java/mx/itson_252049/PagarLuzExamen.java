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
 *
 * @author Cricri
 */
public class PagarLuzExamen {

     public static void main(String[] args) {
        
        ClienteModel clienteModel = new ClienteModel();
        ConsumoModel consumoModel = new ConsumoModel(clienteModel);
        TarjetaModel tarjetaModel = new TarjetaModel();
        ReciboModel reciboModel = new ReciboModel();

      
        PagoServicioController controller = new PagoServicioController(
                clienteModel, consumoModel, tarjetaModel, reciboModel
        );

        
        SwingUtilities.invokeLater(() -> {
            PagoServicioFrame frame = new PagoServicioFrame(controller);
            frame.setVisible(true);
        });
    }
}
