package TP;

import java.util.List;

public class solucionBacktracking {
	
	
    private List<maquina> secuencia;
    private int puestas;
    private int piezasTotales;
    private int estadosGenerados;

    public solucionBacktracking(List<maquina> secuencia, int puestas, int piezasTotales, int estadosGenerados) {
        this.secuencia = secuencia;
        this.puestas = puestas;
        this.piezasTotales = piezasTotales;
        this.estadosGenerados = estadosGenerados;
    }
    
    public List<maquina> getMejorSecuencia() {
        return this.secuencia;
    }
    
    public boolean tieneSolucion() {
        return piezasTotales == 0 || !secuencia.isEmpty();
    }

    public void imprimir() {
        
        System.out.println("Secuencia: " + secuencia);
        System.out.println("Cantidad de piezas producidas: " + piezasTotales);
        System.out.println("Puestas en marcha: " + puestas);
        System.out.println("Total de estados generados: " + estadosGenerados);
    }

}
