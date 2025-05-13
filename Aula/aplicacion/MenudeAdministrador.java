package aplicacion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MenudeAdministrador extends RutasyBuses {

    Scanner scanner = new Scanner(System.in);
    // 1. Agregar ruta
    public void opcion1 () {
        
        // Solicitar el nombre del nuevo bus
        String nuevoBus = JOptionPane.showInputDialog(null, "Ingrese el nombre del bus de la nueva ruta:");
        if (nuevoBus == null || nuevoBus.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del bus no puede estar vacío.");
            return;
            }
    
            // Crear la lista de barrios para el nuevo bus
            ArrayList<String> barrios = new ArrayList<>();
    
            while (true) {    
            // Solicitar el nombre del barrio
            String barrio = JOptionPane.showInputDialog(null, "Ingrese el nombre del barrio (o escriba 'salir' para finalizar):").toLowerCase();
            if (barrio == null || barrio.equals("salir")) {
                break;
            } else if (barrio.trim().isEmpty())

                    // Verificar si el barrio pertenece a alguna localidad
                    if (localidad1.contains(barrio)) {
                        JOptionPane.showMessageDialog(null, "El barrio '" + barrio + "' se encuentra en Localidad 1, posición: " + localidad1.indexOf(barrio));
                    } else if (localidad2.contains(barrio)) {
                        JOptionPane.showMessageDialog(null, "El barrio '" + barrio + "' se encuentra en Localidad 2, posición: " + localidad2.indexOf(barrio));
                    } else if (localidad3.contains(barrio)) {
                        JOptionPane.showMessageDialog(null, "El barrio '" + barrio + "' se encuentra en Localidad 3, posición: " + localidad3.indexOf(barrio));
                    } else {
                        JOptionPane.showMessageDialog(null, "El barrio '" + barrio + "' no se encuentra en ninguna localidad.");
                        continue; 
                    }
        
                    barrios.add(barrio);
                }
    
                rutas().put(nuevoBus,barrios);
        
                // Mostrar la ruta creada
                JOptionPane.showMessageDialog(null, "Ruta agregada exitosamente:\nBus: " + nuevoBus + "\nBarrios: " + barrios);
            }

    // 2. Eliminar ruta
    public void opcion2 () {
        for (String lectura : rutas().keySet()) {
            JOptionPane.showMessageDialog(null, "Bus: " + lectura + "\nBarrios: " + rutas().get(lectura));
            }
            String rutaEliminar = JOptionPane.showInputDialog(null, "Ingrese la ruta a eliminar:");
            if (rutaEliminar == null || rutaEliminar.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre de la ruta no puede estar vacío.");
                return;
            }
            for(String bus : rutas().keySet()) {
                if (bus.equalsIgnoreCase(rutaEliminar)) {
                rutas().remove(bus);
                JOptionPane.showMessageDialog(null, "Ruta eliminada exitosamente.");
                return;
                }
                JOptionPane.showMessageDialog(null, "Bus: " + bus + "\nBarrios: " + rutas().get(bus));
            }
        JOptionPane.showMessageDialog(null, "Ruta no encontrada.");
    }

    // 3. Modificar ruta
    public void opcion3 () {
        for(String ver : rutas().keySet()) {
            JOptionPane.showMessageDialog(null, "Bus: " + ver + "\nBarrios: " + rutas().get(ver));
        }
        String busModificar = JOptionPane.showInputDialog(null, "Ingrese el nombre del bus a modificar:");
        if (busModificar == null || busModificar.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del bus no puede estar vacío.");
            return;
        }
        ArrayList<String> barriosModificar = rutas().get(busModificar);
        if (barriosModificar == null) {
            JOptionPane.showMessageDialog(null, "El bus '" + busModificar + "' no se encuentra en las rutas.");
            return;
        }
        String nuevoBarrio = JOptionPane.showInputDialog(null, "Ingrese el nuevo barrio:");
        if (nuevoBarrio == null || nuevoBarrio.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El barrio no puede estar vacío.");
            return;
        }
        barriosModificar.add(nuevoBarrio);
        JOptionPane.showMessageDialog(null, "Ruta modificada exitosamente:\nBus: " + busModificar + "\nBarrios: " + barriosModificar);
        // Actualizar el HashMap con la nueva lista de barrios  
        rutas().put(busModificar, barriosModificar);
        // Mostrar la ruta actualizada
        StringBuilder sb = new StringBuilder("Ruta actualizada:\nBus: " + busModificar + "\nBarrios: ");
        for (String barrio : barriosModificar) {
        sb.append(barrio).append(", ");
        }
        for (String mira : rutas().keySet()) {
            JOptionPane.showMessageDialog(null, "Bus: " + mira + "\nBarrios: " + rutas().get(mira));    
        }
    }

    // 4. Editar horarios de transporte
    public void opcion4 () {
        semana1 = "6:15"; semana2 = "21:00";
        sabado1 = "6:30 "; sabado2 = "17:45";
        domingo1 = "8:15"; domingo2 = "18:00";

        JOptionPane.showMessageDialog(null, 
            "Horarios de transporte público:\n" +
            "Lunes a viernes: "+semana1+" a "+semana2+"\n"+
            "Sábados: "+sabado1+" a "+sabado2+"\n" +
            "Domingos: "+domingo1+" a "+domingo2);
            
        String[] opciones = {"Lunes a viernes", "Sábados", "Domingos"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Horarios de transporte público", JOptionPane.QUESTION_MESSAGE, null, opciones, null);

        if(opcion == null){
            JOptionPane.showMessageDialog(null,"Ningun valor ingresado: "+opcion);
        } else if (opcion.equals("Lunes a viernes")){
            // semanal 
            String lunesyviernes_inicio = JOptionPane.showInputDialog(null,"A que hora se inicia la semana?: ");
            String lunesyviernes_final = JOptionPane.showInputDialog(null,"A que hora se termina la semana?: ");
            semana1 = lunesyviernes_inicio;
            semana2 = lunesyviernes_final;
        } else if (opcion.equals("Sábados")){
            // sabados 
            String sabados_inicio = JOptionPane.showInputDialog(null,"A que hora se inicia el sabado?: ");
            String sabados_final = JOptionPane.showInputDialog(null,"A que hora se termina el sabado?: ");  
            sabado1 = sabados_inicio;
            sabado2 = sabados_final;
        } else if (opcion.equals("Domingos")){
            // domingos 
            String domingos_inicio = JOptionPane.showInputDialog(null,"A que hora se inicia el domingos?: ");
            String domingos_final = JOptionPane.showInputDialog(null,"A que hora se termina el domingos?: "); 
            domingo1 = domingos_inicio;
            domingo2 = domingos_final;    
        } else {
            JOptionPane.showMessageDialog(null,"Opcion no valida: "+opcion);
        }
        JOptionPane.showMessageDialog(null, 
        "Horarios de transporte público:\n" +
        "Lunes a viernes: "+semana1+" a "+semana2+"\n"+
        "Sábados: "+sabado1+" a "+sabado2+"\n" +
        "Domingos: "+domingo1+" a "+domingo2);
    }

    // 5. Editar tarifas
    public void opcion5() {
    tarifa = "La tarifa es de: $3.400";
    JOptionPane.showMessageDialog(null, tarifa);
    String tarifaNueva = JOptionPane.showInputDialog(null, "¿Cuál es la nueva tarifa?");
    if (tarifaNueva == null || tarifaNueva.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "No se ingresó un valor válido.");
    } else {
        tarifa = "La tarifa es de: $" + tarifaNueva;
        JOptionPane.showMessageDialog(null, "La nueva tarifa es: " + tarifa);

        // Actualizar la tarifa en los archivos de los usuarios
        File carpetaUsuarios = new File("c:\\Users\\HP\\Desktop\\Aula\\informacion\\Usuarios");
        File[] archivosUsuarios = carpetaUsuarios.listFiles();
        if (archivosUsuarios != null) {
            for (File archivo : archivosUsuarios) {
                try {
                    List<String> lineas = Files.readAllLines(archivo.toPath());
                    BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
                    for (String linea : lineas) {
                        if (linea.startsWith("Tarifa:")) {
                            writer.write("Tarifa: " + tarifaNueva + "\n");
                        } else {
                            writer.write(linea + "\n");
                        }
                    }
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

    // 6. Editar Historial
    public void opcion6 () {
        JOptionPane.showMessageDialog(null, "Destinos anteriores: " + anterior.toString());
            String[] opciones = {"Agregar", "Eliminar"};
            String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Historial de destinos", JOptionPane.QUESTION_MESSAGE, null, opciones, null);
                
            if(opcion == null){
                JOptionPane.showMessageDialog(null,"Ningun valor ingresado: "+opcion);
            } else if (opcion.equals("Agregar")){
                String nuevoDestino = JOptionPane.showInputDialog(null, "Ingrese el nuevo destino:");

            if(nuevoDestino == null){
                    JOptionPane.showMessageDialog(null,"Ningun valor ingresado: "+nuevoDestino);
            } else {
                anterior.add(nuevoDestino);
                JOptionPane.showMessageDialog(null, "Destino agregado: " + nuevoDestino);
            }
            } else if (opcion.equals("Eliminar")){
                String destinoEliminar = JOptionPane.showInputDialog(null, "Ingrese el destino a eliminar:");
                if(destinoEliminar == null){
                    JOptionPane.showMessageDialog(null,"Ningun valor ingresado: "+destinoEliminar);
                } else {
                    anterior.remove(destinoEliminar);
                    JOptionPane.showMessageDialog(null, "Destino eliminado: " + destinoEliminar);
                }
                } else {
                    JOptionPane.showMessageDialog(null,"Opcion no valida: "+opcion);
                }
                JOptionPane.showMessageDialog(null, "Destinos anteriores: " + anterior.toString());
    }

    // 7. Búsqueda
    public void opcion7 () {
        String busqueda = JOptionPane.showInputDialog(null, "¿Por qué barrio te gustaría preguntar?").toLowerCase();
            // Aquí podrías incluir tus listas de localidades y compararlas
            if (localidad1.contains(busqueda) || localidad2.contains(busqueda) || localidad3.contains(busqueda)) {
                JOptionPane.showMessageDialog(null, "Sí, se encuentra en las rutas.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encuentra en las rutas.");
            }
    }
    // realiazar prueba de la ruta
    public void opcion8(){
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

    public void Menu2(){
        while (true) {
            // Bienvenida
            System.out.println("\n+=====================================================+");
            System.out.println("|¡Bienvenido a \"BusTracker\", tu aplicación de confianza! |");
            System.out.println("+=====================================================+\n");

            // Menú
            System.out.println("*=====================================================*");
            System.out.println("|                       Opciones                      |");
            System.out.println("|                                                     |");
            System.out.println("|            1. Agregar ruta                          |");
            System.out.println("|            2. Eliminar ruta                         |");
            System.out.println("|            3. Modificar ruta                        |");
            System.out.println("|            4. Editar horarios de transporte         |");
            System.out.println("|            5. Editar tarifas                        |");
            System.out.println("|            6. Editar Historial                      |");
            System.out.println("|            7. Búsqueda                              |");
            System.out.println("|            8. Realizar prueba de ruta               |");
            System.out.println("|            9. Salir                                 |");
            System.out.println("|                                                     |");
            System.out.println("*=====================================================*");

            // Entrada del usuario
            System.out.print("Qué prefieres?: ");
            int eleccion = scanner.nextInt();

            switch (eleccion) {
                case 1:
                    opcion1();
                    System.exit(eleccion);
                case 2:
                    opcion2();
                    System.exit(eleccion);
                case 3:
                    opcion3();
                    System.exit(eleccion);
                case 4:
                    opcion4();
                    System.exit(eleccion);
                case 5:
                    opcion5();
                    System.exit(eleccion);
                case 6:
                    opcion6();
                    System.exit(eleccion);
                case 7:
                    opcion7();
                    System.exit(eleccion);
                case 8:
                    opcion8();
                    System.exit(eleccion);
                case 9:
                    System.exit(eleccion);
                default:
                    JOptionPane.showMessageDialog(null,"Eso no se encuentra entre las opciones");
                    System.exit(eleccion);
                }
            }
        }
    }