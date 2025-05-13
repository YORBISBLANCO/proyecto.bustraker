package aplicacion;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MenudeUsuario extends RutasyBuses {

    Scanner scanner = new Scanner(System.in);

    // eleccion1 . vehiculo
    public void eleccion1(){
        String ubicacion = JOptionPane.showInputDialog(null, "Escribe el nombre del barrio donde te encuentras:").toLowerCase();
        String destino = JOptionPane.showInputDialog(null, "Hacia dónde te diriges?").toLowerCase();
        anterior.add(destino);

        // Aquí implementamos tu lógica de vehículos (simplificada como ejemplo)
        if (Caracoles.contains(ubicacion) && Caracoles.contains(destino)) {
            vehiculo.set(0, "Caracoles");
        } else if (bayunca.contains(ubicacion) && bayunca.contains(destino)) {
            vehiculo.set(0, "Bayunca");
        } else if (pasacaballo.contains(ubicacion) && pasacaballo.contains(destino)) {
            vehiculo.set(0, "Pasacaballo");
        } else if (socorro.contains(ubicacion) && socorro.contains(destino)) {
            vehiculo.set(0, "Socorro");
        } else if (vehitrasn.contains(ubicacion) && vehitrasn.contains(destino)) {
            vehiculo.set(0, "Vehitrasn");
        } else if (microBus.contains(ubicacion) && microBus.contains(destino)) {
            vehiculo.set(0, "MicroBus");
        } else if (sanFernando.contains(ubicacion) && sanFernando.contains(destino)) {
            vehiculo.set(0, "San Fernando");
        } else {
            vehiculo.set(0, "No existe información para esa ruta");
        }

        JOptionPane.showMessageDialog(null, "Mejor opción: " + vehiculo.get(0));
        }

    // eleccion2. horarios 
    public void eleccion2(){
        JOptionPane.showMessageDialog(null, 
            "Horarios de transporte público:\n" +
            "Lunes a viernes: 6:15 a 21:00\n" +
            "Sábados: 6:30 a 12:00 y 14:15 a 17:45\n" +
            "Domingos: 8:15 a 12:00 y 13:45 a 18:00");
    }

    // eleccion3. tarifas
    public void eleccion3(){
        JOptionPane.showMessageDialog(null, "La tarifa es de: $3.400");
    }

    // eleccion4. historial
    public void eleccion4(){
        StringBuilder historial = new StringBuilder("Historial de destinos anteriores:\n");
        for (String destino : anterior) {
            historial.append(destino).append("\n");
        }
        JOptionPane.showMessageDialog(null, historial.toString());
    }

    // eleccion5. busqueda
    public void eleccion5(){
        String busqueda = JOptionPane.showInputDialog(null, "¿Por qué barrio te gustaría preguntar?").toLowerCase();
        // Aquí podrías incluir tus listas de localidades y compararlas
        if (localidad1.contains(busqueda) || localidad2.contains(busqueda) || localidad3.contains(busqueda)) {
            JOptionPane.showMessageDialog(null, "Sí, se encuentra en las rutas.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra en las rutas.");
        }
    }

    public void Menu1(){
        while (true) {
            // Bienvenida
            System.out.println("\n+=====================================================+");
            System.out.println("| ¡Bienvenido a \"BusTracker\", tu aplicación de confianza! |");
            System.out.println("+=====================================================+\n");

            // Menú
            System.out.println("*=====================================================*");
            System.out.println("|                       Opciones                      |");
            System.out.println("|                                                     |");
            System.out.println("|            1. Qué vehículo pasa por aquí?           |");
            System.out.println("|            2. Ver horarios de transporte            |");
            System.out.println("|            3. Ver tarifas                           |");
            System.out.println("|            4. Historial                             |");
            System.out.println("|            5. Búsqueda                              |");
            System.out.println("|            6. Salir                                 |");
            System.out.println("|                                                     |");
            System.out.println("*=====================================================*");

            // Entrada del usuario
            System.out.print("Qué prefieres?: ");
            int eleccion = scanner.nextInt();
            switch (eleccion) {
                case 1:
                    eleccion1();
                    System.exit(eleccion);
                case 2:
                    eleccion2();
                    System.exit(eleccion);
                case 3:
                    eleccion3();
                    System.exit(eleccion);
                case 4:
                    eleccion4();
                    System.exit(eleccion);
                case 5:
                    eleccion5();
                    System.exit(eleccion);
                case 6:
                    System.exit(eleccion);
                default:
                    JOptionPane.showMessageDialog(null,"Opción no válida");
                    System.exit(eleccion);
                }
            }
        }
    }