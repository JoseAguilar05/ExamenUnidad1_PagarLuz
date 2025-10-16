/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson_252049.views;

import mx.itson_252049.controller.PagoServicioController;
import mx.itson_252049.models.entitys.Cliente;
import mx.itson_252049.models.entitys.Consumo;
import mx.itson_252049.models.entitys.Recibo;
import mx.itson_252049.models.entitys.Tarjeta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.List;
import mx.itson_252049.models.ReciboModel;
import mx.itson_252049.models.exception.ValidacionTarjetaException;
import mx.itson_252049.models.observer.Observer;


/**
 *
 * @author Cricri
 */
public class PagoServicioFrame extends JFrame implements Observer{
  private final PagoServicioController controller;
    
    
  
    private JTextField txtNumeroServicio;
    private DefaultListModel<Cliente> modeloListaClientes;
    private JList<Cliente> listaClientes;
    private JTextArea areaDatosConsumo;
    private JTextField txtNumeroTarjeta;
    private JTextArea areaRecibo;


    private Cliente clienteSeleccionado;
    private Consumo consumoSeleccionado;

    
    public PagoServicioFrame(PagoServicioController controller) {
        this.controller = controller;        
        inicializarUI();
    }

    private void inicializarUI() {
        setTitle("Pago de Servicio de Luz");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelBusqueda = new JPanel(new BorderLayout());
        panelBusqueda.add(new JLabel("Número de servicio:"), BorderLayout.WEST);

        txtNumeroServicio = new JTextField();
        panelBusqueda.add(txtNumeroServicio, BorderLayout.CENTER);

        modeloListaClientes = new DefaultListModel<>();
        listaClientes = new JList<>(modeloListaClientes);
        JScrollPane scrollClientes = new JScrollPane(listaClientes);
        scrollClientes.setPreferredSize(new Dimension(250, 100));

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

        add(panelBusqueda, BorderLayout.NORTH);
        add(scrollClientes, BorderLayout.EAST);
        add(panelCentro, BorderLayout.CENTER);

     
        txtNumeroServicio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String criterio = txtNumeroServicio.getText();
                modeloListaClientes.clear();
                List<Cliente> clientes = controller.buscarPorNumeroServicio(criterio);
                clientes.forEach(modeloListaClientes::addElement);
            }
        });

    
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

  @Override
    public void update(ReciboModel recibo) {

        if (recibo != null) {
            areaRecibo.setText(recibo.getReciboGenerado().getFormateado());
        }
    }
}