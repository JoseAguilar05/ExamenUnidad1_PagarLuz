/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models;

import java.util.Date;
import java.util.UUID;
import mx.itson_252049.models.entitys.Cliente;
import mx.itson_252049.models.entitys.Consumo;
import mx.itson_252049.models.entitys.Recibo;
import mx.itson_252049.models.entitys.Tarjeta;

/**
 *
 * @author Cricri
 */
public class ReciboModel {
   

    private Recibo reciboGenerado;

    /**
     * Genera un recibo a partir de un cliente, su consumo y la tarjeta usada.
     * @param cliente Cliente que realiza el pago
     * @param consumo Consumo que se está pagando
     * @param tarjeta Tarjeta con la que se realiza el pago
     */
    public void generaRecibo(Cliente cliente, Consumo consumo, Tarjeta tarjeta) {
    // Generamos un número de autorización único
    String numeroAutorizacion = UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        // Creamos el recibo
    reciboGenerado = new Recibo(
            (int) (Math.random() * 10000), // id aleatorio
            new Date(),                    // fecha actual
            consumo.calcularMonto(),       // monto pagado
            numeroAutorizacion             // número de autorización
    );

    
    reciboGenerado.setTarjeta(tarjeta);

    
    consumo.setRecibo(reciboGenerado);

 
    consumo.actualizarEstado(mx.itson_252049.models.enums.EstadoConsumo.PAGADO);
    }

    
    public String mostrarRecibo() {
        if (reciboGenerado != null) {
            return reciboGenerado.toString();
        } else {
            return "No se ha generado ningún recibo.";
        }
    }

    /**
     * Devuelve el objeto Recibo generado (para la Vista o el Controlador).
     */
    public Recibo getReciboGenerado() {
        return reciboGenerado;
    }
    
}


