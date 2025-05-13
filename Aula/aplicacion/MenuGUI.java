package aplicacion;

import javax.swing.*;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame {
    private MenudeUsuario menu = new MenudeUsuario();

    public void Menu() {
        // Configuración de la ventana
        setTitle("Menú de Transporte");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Diseño absoluto
        setLayout(null);
        // Centrar ventana
        setLocationRelativeTo(null); 

        // titulo
        JLabel lblTitulo = new JLabel("Menú de Transporte");
        lblTitulo.setFont(new java.awt.Font("Arial", 1, 20));
        lblTitulo.setBounds(200, 20, 500, 30);
        add(lblTitulo);

        //textos informativos
        TextArea lbltransporte = new TextArea("Ingresa para saber que bus te es de mayor utilidad y asi lograr mucho\n                                          más rapido llegar a tu destino");
        lbltransporte.setFont(new java.awt.Font("Comic Sans MS",1,13));
        lbltransporte.setBounds(70, 60, 450, 50);
        add(lbltransporte);

        // Crear botones para cada opción
        JButton btnVehiculo = new JButton("Mejor alternativa de transporte");
        btnVehiculo.setFont(new java.awt.Font("Arial", 1, 15));
        btnVehiculo.setBackground(new java.awt.Color(200, 200, 100));
        btnVehiculo.setBounds(70, 120, 450, 100);
        add(btnVehiculo);

        JButton btnadministrador = new JButton("Administrador");
        btnadministrador.setFont(new java.awt.Font("Arial", 1, 10));
        btnadministrador.setBackground(new java.awt.Color(230, 210, 230));
        btnadministrador.setBounds(450, 15, 110, 30);
        add(btnadministrador);

        JButton btnHorarios = new JButton("Ver horarios");
        btnHorarios.setFont(new java.awt.Font("Arial", 1, 15));
        btnHorarios.setBackground(new java.awt.Color(50, 100, 200));
        btnHorarios.setBounds(320, 250, 200, 80);
        add(btnHorarios);

        JButton btnTarifas = new JButton("Ver tarifas");
        btnTarifas.setFont(new java.awt.Font("Arial", 1, 15));
        btnTarifas.setBackground(new java.awt.Color(20, 100, 200));
        btnTarifas.setBounds(70, 250, 200, 80);
        add(btnTarifas);

        JButton btnHistorial = new JButton("Historial de destinos");
        btnHistorial.setFont(new java.awt.Font("Arial", 1, 15));
        btnHistorial.setBackground(new java.awt.Color(0, 255, 200));
        btnHistorial.setBounds(320, 350, 200, 80);
        add(btnHistorial);

        JButton btnBusqueda = new JButton("Búsqueda de barrios");
        btnBusqueda.setFont(new java.awt.Font("Arial", 1, 15));
        btnBusqueda.setBackground(new java.awt.Color(0, 255, 200));
        btnBusqueda.setBounds(70, 350, 200, 80);
        add(btnBusqueda);

        JButton btnSalir = new JButton("Salir de la aplicación");
        btnSalir.setFont(new java.awt.Font("Arial", 1, 15));
        btnSalir.setBackground(new java.awt.Color(255, 200, 200));
        btnSalir.setBounds(195, 450, 200, 50);
        add(btnSalir);

        // Añadir funcionalidad a los botones
        btnVehiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.eleccion1();
            }
        });

        btnHorarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.eleccion2();
            }
        });

        btnTarifas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.eleccion3();
            }
        });

        btnHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.eleccion4();
            }
        });

        btnadministrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String adminUsuario = "proyecto123";
                String adminContraseña = "123456";
                String usuario = JOptionPane.showInputDialog(null, "Ingrese su usuario:").toLowerCase();
                String contraseña = JOptionPane.showInputDialog(null, "Ingrese su contraseña:").toLowerCase();

                if (usuario.equals(adminUsuario) && contraseña.equals(adminContraseña)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido administrador");
                    AdminGUI admin = new AdminGUI();
                    admin.setVisible(true);
                } else if (usuario == null || contraseña == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada.");
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });

        btnBusqueda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.eleccion5();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuGUI menu = new MenuGUI();
            menu.Menu();
            menu.setVisible(true);
        });
    }
}