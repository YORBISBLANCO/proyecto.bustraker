package aplicacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestordeArchivos extends RutasyBuses{
    private String nombreArchivo1 = "C:\\Users\\HP\\Desktop\\Aula\\informacion\\Rejistros\\Usuarios.txt";
    private String nombreArchivo2 = "C:\\Users\\HP\\Desktop\\Aula\\informacion\\Rejistros\\Admin.txt";
    private final String rutaRejistros = "C:\\Users\\HP\\Desktop\\Aula\\informacion\\Rejistros\\";

    // guardarUsuario Usuario.txt
    public void guardarUsuario(String nombre, String apellido, String telefono, String email, String usuario, String contrasena) {
        try (BufferedWriter linea = new BufferedWriter(new FileWriter(nombreArchivo1, true))) {
            linea.write(nombre + "," + apellido + "," + telefono + ","+ email + "," + usuario + "," + contrasena);
            linea.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Verifica si existe el administrador en el archivo Admin.txt
    public String verificarAdmin(String usuario, String contrasena) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo2))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[3].equals(usuario) && datos[4].equals(contrasena)) {
                    // Retorna el nombre del archivo asociado al administrador
                    return datos[0] + "_" + datos[1] + ".txt"; // nombre_apellido.txt
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Verifica si exite el usuario en Usuarios.txt
    public String verificarUsuario(String usuario, String contrasena) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo1))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[4].equals(usuario) && datos[5].equals(contrasena)) {
                    // Retorna el nombre del archivo asociado al usuario
                    return datos[0] + "_" + datos[1] + ".txt"; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }

    // crear archivo de salida para usuarios
    public void creadordeArchivos(String nombre, String apellido) {
    String nombreArchivoSalida = rutaRejistros + nombre + "_" + apellido + ".txt";
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivoSalida))) {
        writer.write("Información del usuario: " + nombre + " " + apellido);
        writer.newLine();

        // Escribir la información de rutas, vehículos, y horarios
        for (String lista : anterior) {
            writer.write(lista);
            writer.newLine();
        }

        for (String coche : vehiculo) {
            writer.write(coche);
            writer.newLine();
        }

        for (String clave : rutas().keySet()) {
            writer.write(clave + ": ");
            ArrayList<String> rutas = rutas().get(clave);
            writer.write(String.join(", ", rutas));
            writer.newLine();
        }

        writer.write("Tarifa: " + tarifa);
        writer.newLine();
        writer.write("Horarios:");
        writer.newLine();
        writer.write("Semana: " + semana1 + " - " + semana2);
        writer.newLine();
        writer.write("Sábado: " + sabado1 + " - " + sabado2);
        writer.newLine();
        writer.write("Domingo: " + domingo1 + " - " + domingo2);
        writer.newLine();

        JOptionPane.showMessageDialog(null, "Archivo creado exitosamente para el usuario: " + nombre + " " + apellido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // crear archivo de salida para administradores
    public void creadordeArchivos2(String nombre) {
    String nombreArchivoSalida = rutaRejistros + nombre + ".txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo2))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivoSalida))) {
                writer.write(linea);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Consigue los nombres de administradores y crea archivos de salida
    public void archivoAdmin() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\Aula\\informacion\\Rejistros\\adminstradores.txt"))) {
            String nombre;
            while ((nombre = br.readLine()) != null) {
                nombre = nombre.trim();
                if (!nombre.isEmpty()) {
                    String[] partes = nombre.split(",");
                    String nombreCompleto = partes[0] + "_" + partes[1];
                    String apellido = partes[1];
                    String nombreArchivoSalida = nombreCompleto + ".txt";
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivoSalida))) {
                        writer.write(nombreCompleto + "," + apellido);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void documentoguia() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\HP\\Desktop\\Aula\\informacion\\Rejistros\\guia.txt"))) {
            try {
                for (String lista : anterior) {
                    writer.write(lista);
                    writer.newLine();
                }

                for (String coche : vehiculo) {
                    writer.write(coche);
                    writer.newLine();
                }

                for (String clave : rutas().keySet()) {
                writer.write(clave + ": "); 
                ArrayList<String> rutas = rutas().get(clave);
                writer.write(String.join(", ", rutas)); 
                writer.newLine(); 
                }

                writer.write(tarifa);
                writer.newLine();
                writer.write(semana1);
                writer.newLine();
                writer.write(semana2);
                writer.newLine();   
                writer.write(sabado1);
                writer.newLine();
                writer.write(sabado2);
                writer.newLine();
                writer.write(domingo1);
                writer.newLine();
                writer.write(domingo2);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void crearArchivoUsuario(String usuario, String nombre, String apellido, String telefono, String email) {
    try {
        File archivo = new File(rutaRejistros + usuario + ".txt");
        if (archivo.createNewFile()) {
            FileWriter writer = new FileWriter(archivo);
            writer.write("Nombre: " + nombre + "\n");
            writer.write("Apellido: " + apellido + "\n");
            writer.write("Teléfono: " + telefono + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Historial:\n");
            writer.close();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}