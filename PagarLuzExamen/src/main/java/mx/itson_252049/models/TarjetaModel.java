/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.models;

import java.util.Date;
import mx.itson_252049.models.entitys.Tarjeta;
import mx.itson_252049.models.exception.ValidacionTarjetaException;

/**
 * Modelo encargado de la gestión y validación de tarjetas bancarias.
 * 
 * <p>Esta clase forma parte de la capa de modelo dentro del patrón MVC
 * (Model-View-Controller) y proporciona métodos para validar tarjetas
 * y crear nuevas tarjetas con características predeterminadas.</p>
 * 
 * <p>El modelo lanza excepciones específicas en caso de que una tarjeta
 * no sea válida, utilizando {@link ValidacionTarjetaException}.</p>
 * 
 * @author Cricri
 */
public class TarjetaModel {
   
    /**
     * Valida una tarjeta bancaria.
     * 
     * <p>Se asegura de que el objeto {@link Tarjeta} no sea nulo y que cumpla
     * con los criterios de validez: tener 16 dígitos y estar vigente.</p>
     * 
     * @param tarjeta objeto {@link Tarjeta} a validar
     * @throws ValidacionTarjetaException si la tarjeta es nula o no válida
     */
    public void validarTarjeta(Tarjeta tarjeta) {
        if (tarjeta == null) {
            throw new ValidacionTarjetaException("La tarjeta no puede ser nula.");
        }

        if (!tarjeta.validarTarjeta()) {
            throw new ValidacionTarjetaException("Tarjeta no válida. Debe tener 16 dígitos y estar vigente.");
        }
    }

    /**
     * Crea una nueva tarjeta bancaria con vencimiento a 3 años a partir de la fecha actual.
     * 
     * <p>La tarjeta generada tiene tipo "Débito", banco predeterminado "Banco X",
     * y la fecha de vencimiento se calcula automáticamente a 3 años desde hoy.</p>
     * 
     * @param numero número de tarjeta (16 dígitos)
     * @return objeto {@link Tarjeta} creado con los datos predeterminados
     */
    public Tarjeta crearTarjeta(String numero) {
        Date fechaVencimiento = new Date(System.currentTimeMillis() + (3L * 365 * 24 * 60 * 60 * 1000)); // 3 años en milisegundos
        return new Tarjeta(numero, "Débito", "Banco X", fechaVencimiento);
    }
}