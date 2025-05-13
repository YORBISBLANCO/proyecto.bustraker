package aplicacion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class RegistroGUI extends JFrame {
    // tipo de ingreso
    public void Ingreso() {
        JFrame frame = new JFrame("Ingreso");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true); 

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(10, 5, 10));
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout( 0, 1, 10, 10));
        // Etiqueta de bienvenida
        JLabel welcome = new JLabel("Bienvenido a BusTracker", JLabel.CENTER);
        welcome.setBounds(100, 20, 200, 25);
        welcome.setFont(new Font("Arial", Font.BOLD, 16));
        welcome.setForeground(Color.WHITE);
        panel.add(welcome);

        // rejistro de usuario
        JButton iniciarUsuariButton = new JButton("Registrar Usuario");
        iniciarUsuariButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Llenar informacion");
                Registro();
                setVisible(true); 
            }
        });
        iniciarUsuariButton.setBounds(50, 60, 300, 40);
        iniciarUsuariButton.setFont(new Font("Geometrías", Font.BOLD, 15));
        iniciarUsuariButton.setForeground(Color.black);
        panel.add(iniciarUsuariButton);  
        
        // iniciar sesion usuario
        JButton iniciarUsuarioButton  = new JButton("Iniciar Sesión Usuario");
        iniciarUsuarioButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame, "Rellenar información");
            GestordeArchivos archivos = new GestordeArchivos();
            
            // Usuario
            String usuario = JOptionPane.showInputDialog("Ingrese su usuario:");
            if (usuario == null || usuario.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Usuario no puede estar vacío");
                return;
            }
            
            // Contraseña
            String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña:");
            if (contraseña == null || contraseña.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Contraseña no puede estar vacía");
                return;
            }
            
            // Verificar usuario y contraseña
            String archivoUsuario = archivos.verificarUsuario(usuario, contraseña);
            if (archivoUsuario != null) {
                JOptionPane.showMessageDialog(frame, "Bienvenido " + usuario);
                JOptionPane.showMessageDialog(frame, "Archivo asociado: " + archivoUsuario);
                MenuGUI menu = new MenuGUI();
                menu.Menu();
                menu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos");
            }
        }
        });
        iniciarUsuarioButton.setBounds(50, 120, 300, 40);
        iniciarUsuarioButton.setFont(new Font("Geometrías", Font.BOLD, 15));
        iniciarUsuarioButton.setForeground(Color.black);
        panel.add(iniciarUsuarioButton);

        // inicio de secion administrador
        JButton iniciarAdminButton = new JButton("Iniciar Sesión Administrador");
        iniciarAdminButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame, "Iniciar sesión como administrador");
            GestordeArchivos archivos = new GestordeArchivos();
            
            // Usuario
            String usuario = JOptionPane.showInputDialog("Ingrese su usuario:");
            if (usuario == null || usuario.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Usuario no puede estar vacío");
                return;
            }
            
            // Contraseña
            String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña:");
            if (contraseña == null || contraseña.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Contraseña no puede estar vacía");
                return;
            }
            
            // Verificar usuario y contraseña
            String archivoAdmin = archivos.verificarAdmin(usuario, contraseña);
            if (archivoAdmin != null) {
                JOptionPane.showMessageDialog(frame, "Bienvenido " + usuario);
                JOptionPane.showMessageDialog(frame, "Archivo asociado: " + archivoAdmin);
                AdminGUI admin = new AdminGUI();
                admin.Admin();
                admin.setVisible(true);
                // Lógica para trabajar con el archivo del administrador
            } else {
                JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos");
            }
        }
        });
        iniciarAdminButton.setBounds(50, 180, 300, 40);
        iniciarAdminButton.setFont(new Font("Geometrías", Font.BOLD, 15));
        iniciarAdminButton.setForeground(Color.black);
        panel.add(iniciarAdminButton);
    }

    // datos de rejistro
    public void Registro() {
        initComponents();
        setTitle("Registro de Usuario");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(420, 450);
        setLayout(null);
        setLocationRelativeTo(rootPane);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 400, 400);
        add(panel);

        JLabel label_6 = new JLabel("Registro de Usuario");
        label_6.setBounds(120, 10, 200, 30);
        panel.add(label_6);

        JLabel label = new JLabel("Ingrese su nombre:");
        label.setFont(new Font(null, 1, 14));
        label.setBounds(50, 50, 150, 30);
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(200, 50, 180, 30);
        panel.add(textField);

        JLabel label_1 = new JLabel("Ingrese su apellido:");
        label_1.setFont(new Font(null, 1, 14));
        label_1.setBounds(50, 100, 150, 30);
        panel.add(label_1);

        JTextField textField_1 = new JTextField();
        textField_1.setBounds(200, 100, 180, 30);
        panel.add(textField_1);

        JLabel label_2 = new JLabel("Ingrese su telefono:");
        label_2.setBounds(50, 150, 150, 30);
        label_2.setFont(new Font(null, 1, 14));
        panel.add(label_2);

        JTextField textField_2 = new JTextField();
        textField_2.setBounds(200, 150, 180, 30);
        panel.add(textField_2);

        JLabel label_3 = new JLabel("Ingrese su email:");
        label_3.setBounds(50, 200, 150, 30);
        label_3.setFont(new Font(null, 1, 14));
        panel.add(label_3);

        JTextField textField_3 = new JTextField();
        textField_3.setBounds(200, 200, 180, 30);
        panel.add(textField_3);

        JLabel label_4 = new JLabel("Ingrese su usuario:");
        label_4.setBounds(50, 250, 150, 30);
        label_4.setFont(new Font(null, 1, 14));
        panel.add(label_4);

        JTextField textField_4 = new JTextField();
        textField_4.setBounds(200, 250, 180, 30);
        panel.add(textField_4);

        JLabel label_5 = new JLabel("Su contraseña:");
        label_5.setFont(new Font(null, 1, 14));
        label_5.setBounds(50, 300, 150, 30);
        panel.add(label_5);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 300, 180, 30);
        panel.add(passwordField);
        
        JButton button = new JButton("Registrar");
        button.setBounds(150, 350, 100, 30);
        panel.add(button);

        button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String nombre = textField.getText();
            String apellido = textField_1.getText();
            String telefono = textField_2.getText();
            String email = textField_3.getText();
            String usuario = textField_4.getText();
            String contraseña = new String(passwordField.getPassword());

            if (nombre.equals("") || apellido.equals("") || telefono.equals("") || email.equals("") || usuario.equals("") || contraseña.equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                // Guardar los datos de registro
                GestordeArchivos gestor = new GestordeArchivos();
                gestor.guardarUsuario(nombre, apellido, telefono, email, usuario, contraseña);

                // Crear archivo individual para el usuario
                gestor.crearArchivoUsuario(usuario, nombre, apellido, telefono, email);

                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
            }
        }
    });
    }

    private void initComponents() {
        // Initialize components if needed
    }

    public static void main(String[] args) {
        RegistroGUI re = new RegistroGUI();
        re.Ingreso();
        re.Registro();
    }
}