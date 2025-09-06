// Realizar programas de devueltas que
// Primero debe leer las entradas
// Luego la devuelta
// Imprimir cuales billetes y monedas

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Devuelta extends JFrame {

    //Variable globales:
    // Serán usadas para la ComboBox 
    private int[] denominacion = new int[]{100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50};
    private int[] existencia = new int[denominacion.length];
    private JComboBox cmbDenominacion;
    private JTextField txtExistencia, txtDevuelta;
    private String[] encabezados = new String[]{"Cantidad", "Presentación", "Denominación"};


    // Método constructor:
    public Devuelta() {
        setTitle("Calculo de devueltas"); //Titulo de la ventana
        setSize(500, 400); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Como se comporta cuando cierre la ventana
        setLayout(null);

        // Agregar etiquetas:
        JLabel lblDenominacion = new JLabel("Denominación: ");
        lblDenominacion.setBounds(125, 10, 100, 25);
        getContentPane().add(lblDenominacion);

        // Agregar lista desplegable
        cmbDenominacion = new JComboBox();
        cmbDenominacion.setBounds(220, 10, 100, 25);
        getContentPane().add(cmbDenominacion); // Agrega el panel

        // Crear un modelo de datos para dicha lista desplegable
        String[] strDenominacion = new String[denominacion.length]; // Obtener tamaño del vector
        for (int i = 0; i < denominacion.length; i++) { // Bucle FOR
            strDenominacion[i] = String.valueOf(denominacion[i]); // Se convierten los datos del String con .valueOf
        }
        cmbDenominacion.setModel(new DefaultComboBoxModel(strDenominacion));

        // Agregar botón
        JButton btnActualizarExistencia = new JButton("Actualizar existencia");
        btnActualizarExistencia.setBounds(10, 40, 200, 25);
        getContentPane().add(btnActualizarExistencia);

        // Agregar una caja de texto
        txtExistencia = new JTextField();
        txtExistencia.setBounds(220, 40, 100, 25);
        getContentPane().add(txtExistencia);

        // Agregar eventos(JS concept) para actualizar existencias
        cmbDenominacion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                consultarExistencia();
            }
        });

        btnActualizarExistencia.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarExistencia();
            }

        });

        // Agregar elementos para leer la devuelta:
        // Texto
        JLabel lblDevuelta = new JLabel("Valor a devolver: ");
        lblDevuelta.setBounds(10, 70, 100, 25);
        getContentPane().add(lblDevuelta);
        // Caja
        txtDevuelta = new JTextField();
        txtDevuelta.setBounds(220, 70, 100, 25);
        getContentPane().add(txtDevuelta);
        // Botón
        JButton btnDevuelta = new JButton("Actualizar existencia");
        btnDevuelta.setBounds(330, 70, 100, 25);
        getContentPane().add(btnDevuelta);
        

        // Agregar rejilla de datos
        JTable tblDevuelta = new JTable();
        JScrollPane spDevuelta = new JScrollPane(tblDevuelta);
        spDevuelta.setBounds(10, 100, 465, 200);
        getContentPane().add(spDevuelta);

        // Asignar datos de la rejilla
        DefaultTableModel dtm= new DefaultTableModel(null, encabezados);
        tblDevuelta.setModel((dtm));
    }

    private void consultarExistencia() {
        int existenciaActual = existencia[cmbDenominacion.getSelectedIndex()];
        txtExistencia.setText(String.valueOf(existenciaActual));
    }

    private void actualizarExistencia() {
        int existenciaActual = Integer.parseInt(txtExistencia.getText());
        existencia[cmbDenominacion.getSelectedIndex()] = existenciaActual;
    }

}
