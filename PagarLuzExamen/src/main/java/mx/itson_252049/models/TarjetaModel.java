/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models;

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
}


