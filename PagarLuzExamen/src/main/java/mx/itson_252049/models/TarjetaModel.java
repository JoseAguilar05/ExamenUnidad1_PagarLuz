/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models;

import java.util.Date;
import mx.itson_252049.models.entitys.Tarjeta;

/**
 *
 * @author Cricri
 */
public class TarjetaModel {
   
    /**
     * Valida una tarjeta bancaria.
     * @param tarjeta Objeto Tarjeta a validar
     * @return true si la tarjeta es válida, false en caso contrario
     */
    public boolean validarTarjeta(Tarjeta tarjeta) {
        if (tarjeta == null) {
            return false;
        }
        return tarjeta.validarTarjeta();
    }
    
    
    /**
     * Crea una tarjeta con vencimiento a 3 años.
     * @param numero
     * @return 
     */
    public Tarjeta crearTarjeta(String numero) {
        Date fechaVencimiento = new Date(System.currentTimeMillis() + (3L * 365 * 24 * 60 * 60 * 1000));
        return new Tarjeta(numero, "Débito", "Banco X", fechaVencimiento);
    }
}


