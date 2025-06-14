package TP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Lee archivo
            BufferedReader br = new BufferedReader(new FileReader(new File(System.getProperty("user.dir"), "input.txt")));
            int objetivo = Integer.parseInt(br.readLine().trim());

            List<maquina> maquinas = new ArrayList<>();
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                
                // Valida el formato del archivo
                if (partes.length != 2) {
                    System.out.println("Linea invalida en el archivo: \"" + linea + "\". Se ignora.");
                    continue;
                }

                try {
                    String nombre = partes[0].trim();
                    int piezas = Integer.parseInt(partes[1].trim());
                    maquinas.add(new maquina(nombre, piezas));
                } catch (NumberFormatException e) {
                    System.out.println("Error en el formato de piezas: \"" + linea + "\". Se ignora.");
                }
            }
            br.close();
            
            

            // Ejecuta Backtracking            
            BacktrackingMaquinas buscarConBT = new BacktrackingMaquinas(maquinas);
            solucionBacktracking solucionBT = buscarConBT.encontrarMejorSecuencia(objetivo);

            // EjecutaGreedy
            GreedyMaquinas buscarConGreedy = new GreedyMaquinas(maquinas);
            solucionGreedy solucionG = buscarConGreedy.encontrarSolucion(objetivo);

            // Muestra resultados Backtracking
            System.out.println("--- BACKTRACKING ---");
            if (!solucionBT.tieneSolucion()) {
                System.out.println("No se encontro una solucion posible.-");
            } else {
                solucionBT.imprimir();
            }
            
            System.out.println();
        

            // Muestra resultados Greedy
            System.out.println("--- GREEDY ---");
            if (!solucionG.tieneSolucion()) {
                System.out.println("No se encontro una solucion posible.-");
            } else {
                solucionG.imprimir();
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto en el archivo: " + e.getMessage());
        }
    }
}

