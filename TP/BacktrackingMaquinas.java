package TP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Estrategia Backtracking:
 *
 * - El arbol de exploracion se crea probando todas las posibles secuencias
 *   de maquinas que sumen la cantidad de piezas solicitadas.-
 *
 * - Cada nodo representa una maquina puesta en funcionamiento y un nuevo estado
 *   con la suma acumulada de piezas.-
 *
 * - Los estados solucion son los que el total de piezas acumuladas
 *   es igual al objetivo.-
 *
 * - Se permite repetir maquinas, entonces en cada llamada recursiva se prueban
 *   todas las maquinas disponibles.-
 *
 * - Se aplican las siguientes podas:
 *     1) Si el total de piezas acumulado es mayor que el objetivo -> se descarta la rama.-
 *     2) Si ya usamos mas puestas en marcha que la mejor solucion encontrada -> se descarta.-
 *
 * - Se mide el costo de la solucion como la cantidad de estados generados
 *   (cada llamada al metodo recursivo cuenta como un estado).-
 *
 * - Se guarda la mejor solucion que es la de menor cantidad de puestas en marcha.-
 *   
 */


public class BacktrackingMaquinas {
	
	// Lista de maquinas disponibles, cada una produce un numero determinado de piezas
	private List<maquina> maquinas;
	
	// Va almacenando la mejor secuencia de maquinas, la secuencia de menor puestas en marcha
	private List<maquina> mejorSecuencia;
	
	// Va guardando la menor cantidad de puesta en marcha de maquinas
	private Integer menorPuesta;
	
	// Guarda la cantidad de estados generados en el recorrido (para comparar luego con Greedy)
	private int estadosGenerados;
	
	
	
	public BacktrackingMaquinas(List<maquina> maquinas) {
		this.maquinas = maquinas;
		this.mejorSecuencia = new LinkedList<>();
		this.menorPuesta = null;
		this.estadosGenerados = 0;
	}
	
	
/*
 * Metodo publico
 * 
 * Recibe como parametro: "objetivo" que es el total de piezas a fabricar
 * 
 * Retorna: un objeto SolucionBacktracking "resultado" que tiene:
 * 
 * 							- Mejor secuencia de maquinas
 * 							- Total de piezas fabricadas
 * 							- cantidad de puestas en marcha
 * 							- Cantidad de estados generados en el recorrido
 * */	
	
	public solucionBacktracking encontrarMejorSecuencia(int objetivo) {

	    mejorSecuencia.clear();
	    estadosGenerados = 0;
	    menorPuesta = null;

	    List<maquina> actual = new LinkedList<>();

	    // Caso general: solo se usa backtracking si el objetivo es mayor a 0
	    if (objetivo > 0) {
	        backtracking(actual, 0, objetivo);
	    }

	    // Si no encuentra solucion, dejamos la secuencia vacía y puesta en 0
	    if (menorPuesta == null) {
	        menorPuesta = 0;
	        mejorSecuencia = new ArrayList<>();
	    }

	    solucionBacktracking resultado = new solucionBacktracking(mejorSecuencia, menorPuesta, objetivo, estadosGenerados);
	    return resultado;
	}

/*
* Algoritmo recursivo de Backtracking
* 
* Parametros que recibe:
* 
*                  "actual" - secuencia parcial de máquinas usada hasta ahora
*                  "acumulado" - total de piezas acumuladas hasta ahora
*                  "objetivo" - total de piezas a fabricar
*/
	private void backtracking(List<maquina> actual, int acumulado, int objetivo) {
		
		estadosGenerados ++;
		
		if(acumulado > objetivo) return;    // Poda 1: Si la cantidad de piezas acumuladas supera el objetivo de piezas no sigo
		
		if(acumulado == objetivo) {			// Condicion de corte
			if(esMejor(actual.size(), menorPuesta)){ //Si llegue al objetivo me fijo si es la mejor solucion
				
				mejorSecuencia.clear();
				mejorSecuencia.addAll(actual);
				menorPuesta = actual.size();
			}
			return; //corta la rama actual porque ya llegue a la solucion, no tiene sentido seguir sumando maquinas			
		}		
		
		if((menorPuesta != null) && (actual.size()>= menorPuesta)) return; //Poda 2: Si ya use mas maquinas que las que tengo en 
																		   //en la mejor solucion no tiene sentido seguir
		
		
		// En cada paso, pruebo TODAS las máquinas disponibles como proxima opcion
        
		for(maquina m : maquinas) {			
			int piezas = m.getPiezas();
			
			actual.add(m);
			acumulado += piezas;
			
			backtracking(actual, acumulado, objetivo);
			//Se deshace lo que se hizo antes del llamado recursivo
			acumulado -= piezas;
			actual.remove(actual.size()-1);
			
		}		
	}


/*
 * Metodo para comparar si una solucion es mejor que la anterior
 * 
 * Recibe: "actual" (cantidad actual de puestas en marcha) y "mejor" (mejor cantidad de puesta guardada)
 *
 * Devuelve: verdadero  si la actual es mejor (menor)
 */

	private boolean esMejor(int actual, Integer mejor) {
		
		return mejor == null || actual < mejor;
	}
	

}
