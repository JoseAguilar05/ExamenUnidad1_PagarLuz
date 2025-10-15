/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import mx.itson_252049.models.entitys.Cliente;
import mx.itson_252049.models.entitys.Consumo;
import mx.itson_252049.models.entitys.Recibo;
import mx.itson_252049.models.entitys.Tarjeta;
import mx.itson_252049.models.enums.EstadoConsumo;
import mx.itson_252049.models.observer.Observer;

/**
 *
 * @author Cricri
 */
public class ReciboModel {
   

   private Recibo reciboGenerado;

    private final List<Observer> observers = new ArrayList<>();

  
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

   
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this); 
        }
    }

   
    public void generaRecibo(Cliente cliente, Consumo consumo, Tarjeta tarjeta) {
        String numeroAutorizacion = UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        reciboGenerado = new Recibo(
                (int) (Math.random() * 10000),
                new Date(),
                consumo.calcularMonto(),
                numeroAutorizacion
        );

        reciboGenerado.setTarjeta(tarjeta);
        consumo.setRecibo(reciboGenerado);
        consumo.actualizarEstado(EstadoConsumo.PAGADO);

       
        notifyObservers();
    }

    public Recibo getReciboGenerado() {
        return reciboGenerado;
    }
       public String mostrarRecibo() {
        if (reciboGenerado != null) {
            return reciboGenerado.toString();
        } else {
            return "No se ha generado ningún recibo.";
        }
    }
    
}


