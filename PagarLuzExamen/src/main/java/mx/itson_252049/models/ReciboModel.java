/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models;


import mx.itson_252049.models.entitys.Cliente;
import mx.itson_252049.models.entitys.Consumo;
import mx.itson_252049.models.entitys.Recibo;
import mx.itson_252049.models.entitys.Tarjeta;
import mx.itson_252049.models.enums.EstadoConsumo;
import mx.itson_252049.models.observer.Observer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Modelo encargado de la generación y gestión de recibos dentro del sistema.
 * 
 * <p>Esta clase forma parte de la capa de modelo en el patrón MVC (Model-View-Controller)
 * y se encarga de crear recibos de pago a partir de un consumo realizado por un cliente,
 * utilizando los datos de la tarjeta de pago asociada.</p>
 * 
 * <p>Además, implementa el patrón <strong>Observer</strong>, notificando a los observadores
 * registrados cada vez que se genera un nuevo recibo.</p>
 * 
 * @author Cricri
 */
public class ReciboModel {
   
    /** Último recibo generado por el modelo. */
    private Recibo reciboGenerado;

    /** Lista de observadores que serán notificados al generarse un nuevo recibo. */
    private final List<Observer> observers = new ArrayList<>();

    /**
     * Registra un nuevo observador para recibir notificaciones
     * cuando se genere un nuevo recibo.
     * 
     * @param observer instancia del observador que desea suscribirse
     */
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * Notifica a todos los observadores registrados sobre un cambio en el modelo,
     * generalmente cuando se ha generado un nuevo recibo.
     */
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    /**
     * Genera un nuevo recibo de pago para un cliente y su consumo asociado.
     * 
     * <p>El método crea un recibo con un identificador aleatorio, fecha actual,
     * monto basado en el consumo, y un número de autorización único.
     * Luego asocia el recibo al consumo, actualiza su estado a <code>PAGADO</code>,
     * y notifica a los observadores del cambio.</p>
     * 
     * @param cliente cliente asociado al consumo
     * @param consumo consumo por el cual se realiza el pago
     * @param tarjeta tarjeta utilizada para efectuar el pago
     */
    public void generaRecibo(Cliente cliente, Consumo consumo, Tarjeta tarjeta) {
        String numeroAutorizacion = UUID.randomUUID()
                                        .toString()
                                        .substring(0, 8)
                                        .toUpperCase();

        reciboGenerado = new Recibo(
                (int) (Math.random() * 10000), // ID aleatorio de recibo
                new Date(),                    // Fecha actual
                consumo.calcularMonto(),       // Monto del consumo
                numeroAutorizacion             // Código de autorización
        );

        // Asociar tarjeta y actualizar estado
        reciboGenerado.setTarjeta(tarjeta);
        consumo.setRecibo(reciboGenerado);
        consumo.actualizarEstado(EstadoConsumo.PAGADO);

        // Notificar a los observadores del cambio
        notifyObservers();
    }

    /**
     * Obtiene el último recibo generado.
     * 
     * @return el objeto {@link Recibo} más reciente, o {@code null} si no existe
     */
    public Recibo getReciboGenerado() {
        return reciboGenerado;
    }

    /**
     * Devuelve una representación textual del recibo más reciente.
     * 
     * @return una cadena con la información del recibo generado,
     * o un mensaje indicando que aún no se ha generado ninguno
     */
    public String mostrarRecibo() {
        if (reciboGenerado != null) {
            return reciboGenerado.toString();
        } else {
            return "No se ha generado ningún recibo.";
        }
    }
}
