/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.views;

import mx.itson_252049.controller.PagoServicioController;
import mx.itson_252049.models.entitys.Cliente;
import mx.itson_252049.models.entitys.Consumo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mx.itson_252049.models.ReciboModel;
import mx.itson_252049.models.exception.ValidacionTarjetaException;
import mx.itson_252049.models.observer.Observer;


import java.util.List;

/**
 * Interfaz gráfica de usuario (GUI) para el pago de servicios de luz.
 * 
 * <p>Esta clase representa la vista en el patrón MVC y permite al usuario:
 * <ul>
 *   <li>Buscar clientes por número de servicio.</li>
 *   <li>Visualizar los datos de consumo de un cliente seleccionado.</li>
 *   <li>Ingresar el número de tarjeta para confirmar el pago.</li>
 *   <li>Visualizar el recibo generado tras el pago.</li>
 * </ul>
 * </p>
 * 
 * <p>Implementa la interfaz {@link Observer} para recibir notificaciones
 * del modelo {@link ReciboModel} cada vez que se genera un nuevo recibo.</p>
 * 
 * <p>Se comunica con el controlador {@link PagoServicioController} para realizar
 * las operaciones de búsqueda, selección de cliente, obtención de consumos
 * y confirmación de pagos.</p>
 * 
 * Autor: Cricri
 */
public class PagoServicioFrame extends JFrame implements Observer {

    /** Controlador que coordina la interacción entre la vista y los modelos. */
    private final PagoServicioController controller;

    /** Campo de texto para ingresar el número de servicio del cliente. */
    private JTextField txtNumeroServicio;

    /** Modelo de lista para mostrar los clientes que coinciden con la búsqueda. */
    private DefaultListModel<Cliente> modeloListaClientes;

    /** Lista que despliega los clientes encontrados. */
    private JList<Cliente> listaClientes;

    /** Área de texto que muestra los datos del consumo seleccionado. */
    private JTextArea areaDatosConsumo;

    /** Campo de texto para ingresar el número de tarjeta para el pago. */
    private JTextField txtNumeroTarjeta;

    /** Área de texto que muestra el recibo generado tras el pago. */
    private JTextArea areaRecibo;

    /** Cliente actualmente seleccionado en la lista. */
    private Cliente clienteSeleccionado;

    /** Consumo actualmente seleccionado del cliente. */
    private Consumo consumoSeleccionado;

    /**
     * Crea la ventana principal de pago de servicio y la inicializa.
     * 
     * @param controller controlador que gestiona la lógica del pago de servicios
     */
    public PagoServicioFrame(PagoServicioController controller) {
        this.controller = controller;        
        inicializarUI();
    }

    /**
     * Inicializa todos los componentes de la interfaz gráfica,
     * define el layout y configura los eventos de interacción.
     */
    private void inicializarUI() {
        setTitle("Pago de Servicio de Luz");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de búsqueda
        JPanel panelBusqueda = new JPanel(new BorderLayout());
        panelBusqueda.add(new JLabel("Número de servicio:"), BorderLayout.WEST);

        txtNumeroServicio = new JTextField();
        panelBusqueda.add(txtNumeroServicio, BorderLayout.CENTER);

        // Lista de clientes
        modeloListaClientes = new DefaultListModel<>();
        listaClientes = new JList<>(modeloListaClientes);
        JScrollPane scrollClientes = new JScrollPane(listaClientes);
        scrollClientes.setPreferredSize(new Dimension(250, 100));

        // Panel central con datos de consumo, tarjeta y recibo
        JPanel panelCentro = new JPanel(new GridLayout(3, 1));
        areaDatosConsumo = new JTextArea("Datos de consumo aparecerán aquí...");
        areaDatosConsumo.setEditable(false);

        txtNumeroTarjeta = new JTextField();
        txtNumeroTarjeta.setBorder(BorderFactory.createTitledBorder("Número de tarjeta"));

        areaRecibo = new JTextArea("Recibo aparecerá aquí...");
        areaRecibo.setEditable(false);

        panelCentro.add(new JScrollPane(areaDatosConsumo));
        panelCentro.add(txtNumeroTarjeta);
        panelCentro.add(new JScrollPane(areaRecibo));

        // Agregar componentes al frame
        add(panelBusqueda, BorderLayout.NORTH);
        add(scrollClientes, BorderLayout.EAST);
        add(panelCentro, BorderLayout.CENTER);

        // Evento de búsqueda en tiempo real
        txtNumeroServicio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String criterio = txtNumeroServicio.getText();
                modeloListaClientes.clear();
                List<Cliente> clientes = controller.buscarPorNumeroServicio(criterio);
                clientes.forEach(modeloListaClientes::addElement);
            }
        });

        // Evento de selección de cliente
        listaClientes.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                clienteSeleccionado = listaClientes.getSelectedValue();
                if (clienteSeleccionado != null) {
                    consumoSeleccionado = controller.obtenerDatosConsumo(clienteSeleccionado.getNumeroServicio());
                    if (consumoSeleccionado != null) {
                        areaDatosConsumo.setText("=== DATOS DE CONSUMO ===\n" +
                                "Cliente: " + clienteSeleccionado.getNombre() + "\n" +
                                "Periodo: " + consumoSeleccionado.getFechaConsumo() + "\n" +
                                "Monto a pagar: $" + consumoSeleccionado.getMontoConsumo() + "\n" +
                                "Estado: " + consumoSeleccionado.getEstado());
                    } else {
                        areaDatosConsumo.setText("No se encontraron consumos para este cliente.");
                    }
                }
            }
        });

        // Evento para confirmar pago al ingresar la tarjeta
        txtNumeroTarjeta.addActionListener(e -> {
            if (clienteSeleccionado != null && consumoSeleccionado != null) {
                try {
                    controller.confirmarPago(
                        clienteSeleccionado,
                        consumoSeleccionado,
                        txtNumeroTarjeta.getText()
                    );
                } catch (ValidacionTarjetaException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), 
                        "Error de validación", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Método llamado cuando el modelo {@link ReciboModel} notifica cambios.
     * 
     * <p>Actualiza el área de texto con la información del recibo generado.</p>
     * 
     * @param recibo modelo de recibo que envía la notificación
     */
    @Override
    public void update(ReciboModel recibo) {
        if (recibo != null && recibo.getReciboGenerado() != null) {
            areaRecibo.setText(recibo.getReciboGenerado().getFormateado());
        }
    }
}
