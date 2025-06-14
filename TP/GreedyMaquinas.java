package TP;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

 /*
 * Estrategia Greedy:
 * 
 * - Candidatos: cada tipo de maquina disponible.-
 * 
 * - Seleccion de candidatos: se ordenan las maquinas de mayor a menor segun la cantidad de piezas que fabrican.-
 * 
 * - En cada paso se elige la maquina que mas piezas produce sin pasarse del objetivo, cada maquina se puede utilizar 
 * mas de una vez.-
 * 
 * El corte se produce cuando se llega al objetivo o si no se puede agregar ninguna maquina sin pasarse.-
 * 
 * No siempre se llega a una solucion.-
 * 
 */

public class GreedyMaquinas {
	
	// Lista de maquinas disponibles, cada una produce un numero determinado de piezas
	private List<maquina> maquinas;

    public GreedyMaquinas(List<maquina> maquinas) {
        this.maquinas = maquinas;
    }

    
/*
 * Metodo publico
 * 
 * Recibe como parametro: "objetivo" que es el total de piezas a fabricar
 * 
 * Retorna: un objeto SolucionGreedy "resultado" que tiene:
 * 
 * 							- Mejor secuencia de maquinas
 * 							- Total de piezas fabricadas
 * 							- cantidad de puestas en marcha
 * 							- Cantidad de bcandidatos considerados
 *
 */	
    
    public solucionGreedy encontrarSolucion(int objetivo) {
    	
        List<maquina> seleccionadas = new LinkedList<>();
        int acumulado = 0;
        int candidatosConsiderados = 0;

        // Ordena las maquinas de mayor a menor de a cuerdo a la cantidad de piezas producidas
        Collections.sort(maquinas, Comparator.comparingInt(maquina::getPiezas).reversed());

        // Seleccion de las maquinas (como estan ordenadas siempre primero agarra las que mas piezas fabrican)
        for (maquina m : maquinas) {
        	
            int suma = acumulado + m.getPiezas();  
            
            while (suma <= objetivo) {   // Se pueden repetir maquinas
                seleccionadas.add(m);
                acumulado += m.getPiezas();
                candidatosConsiderados++;
               
                suma = acumulado + m.getPiezas();
            }
        }

        solucionGreedy resultado = new solucionGreedy(seleccionadas, acumulado, candidatosConsiderados, objetivo);
        return resultado;
    }

}
