package aplicacion;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class AdminGUI extends JFrame {
    private MenudeAdministrador menu = new MenudeAdministrador();
    private JButton btnModificar;

    public void Admin() {
        setTitle("Menú de Administrador");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel lblTitulo = new JLabel("Menú de Administrador");
        lblTitulo.setFont(new java.awt.Font("Arial", 1, 20));
        lblTitulo.setBounds(200, 20, 500, 30);
        add(lblTitulo);
        
        // Crear botones para cada opción

        JButton btnUsuario = new JButton("usuario");
        btnUsuario.setFont(new java.awt.Font("Arial", 1, 10));
        btnUsuario.setBackground(new java.awt.Color(230, 210, 230));
        btnUsuario.setBounds(450, 15, 110, 30);
        add(btnUsuario);
        // listo 

        JButton btnHorarios = new JButton("Editar horarios");
        btnHorarios.setFont(new java.awt.Font("Arial", 1, 15));
        btnHorarios.setBackground(new java.awt.Color(50, 100, 200));
        btnHorarios.setBounds(320, 350, 200, 60);
        add(btnHorarios);

        JButton btnTarifas = new JButton("Editar tarifas");
        btnTarifas.setFont(new java.awt.Font("Arial", 1, 15));
        btnTarifas.setBackground(new java.awt.Color(20, 100, 200));
        btnTarifas.setBounds(70, 350, 200, 60);
        add(btnTarifas);

        JButton btnHistorial = new JButton("Editar Historial");
        btnHistorial.setFont(new java.awt.Font("Arial", 1, 15));
        btnHistorial.setBackground(new java.awt.Color(0, 255, 200));
        btnHistorial.setBounds(320, 275, 200, 60);
        add(btnHistorial);

        JButton btnBusqueda = new JButton("Editar barrios");
        btnBusqueda.setFont(new java.awt.Font("Arial", 1, 15));
        btnBusqueda.setBackground(new java.awt.Color(0, 255, 200));
        btnBusqueda.setBounds(70, 275, 200, 60);
        add(btnBusqueda);

        JButton btnSalir = new JButton("Salir de la aplicación");
        btnSalir.setFont(new java.awt.Font("Arial", 1, 15));
        btnSalir.setBackground(new java.awt.Color(255, 200, 200));
        btnSalir.setBounds(195, 450, 200, 60);
        add(btnSalir);

        btnModificar = new JButton("Modificar ruta ");
        btnModificar.setFont(new java.awt.Font("Arial", 1, 15));
        btnModificar.setBackground(new java.awt.Color(40, 100, 25));
        btnModificar.setForeground(java.awt.Color.WHITE);
        btnModificar.setBounds(70, 200, 200, 60);
        add(btnModificar);

        JButton btnEliminar = new JButton("Eliminar ruta");
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 15));
        btnEliminar.setBackground(new java.awt.Color(255, 30, 50));
        btnEliminar.setForeground(java.awt.Color.WHITE);
        btnEliminar.setBounds(320, 200, 200, 60);
        add(btnEliminar);
        
        JButton btnAgregar = new JButton("Agregar nueva ruta");
        btnAgregar.setFont(new java.awt.Font("Arial", 1, 17));
        btnAgregar.setBackground(new java.awt.Color(50, 20, 40));
        btnAgregar.setForeground(java.awt.Color.WHITE);
        btnAgregar.setBounds(70, 70, 220, 100);
        add(btnAgregar);

        JButton btnprueba = new JButton("Realizar Prueba");
        btnprueba.setFont(new java.awt.Font("Arial", 1, 17));
        btnprueba.setBackground(new java.awt.Color(50, 20, 40));
        btnprueba.setForeground(java.awt.Color.WHITE);
        btnprueba.setBounds(305, 70, 219, 100);
        add(btnprueba);
        
        // accion de horario
        btnHorarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.opcion4();
            }

        });
        // accion de tarifas
        btnTarifas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.opcion5();
            }
        });
        // accion de historial
        btnHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.opcion6();
            }
        });
        // accion de usuario 
        btnUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Menu de Usuario");
                    MenuGUI usuario = new MenuGUI();
                    usuario.setVisible(true);
                
            }
        });
        // accion busqueda
        btnBusqueda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.opcion7();
            }
        });
        // accion de salir
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // accion de agregar 
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.opcion1();
            }
        });
        // aacion de modificar
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.opcion3();
            }   
        });
        // accion de eliminar
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.opcion2();
                }
            });
        // accion de prueba
        btnprueba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.opcion8();
            }
            });
        }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        AdminGUI menu = new AdminGUI();
        menu.Admin();
        menu.setVisible(true);
        });
    }
}