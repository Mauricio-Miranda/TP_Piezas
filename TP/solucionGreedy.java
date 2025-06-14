package TP;

import java.util.List;

public class solucionGreedy {
	
	private List<maquina> secuencia;
    private int piezasProducidas;
    private int candidatosConsiderados;
 

    public solucionGreedy(List<maquina> secuencia, int piezasProducidas, int candidatosConsiderados, int objetivo) {
        this.secuencia = secuencia;
        this.piezasProducidas = piezasProducidas;
        this.candidatosConsiderados = candidatosConsiderados;
 
    }

    
    public void imprimir() {
        System.out.print("Secuencia: ");
        for (maquina m : secuencia) {
            System.out.print(m.getNombre() + " ");
        }
        
        System.out.println();
        System.out.println("Cantidad de piezas producidas: " + piezasProducidas);
        System.out.println("Puestas en marcha: " + secuencia.size());
        System.out.println("Candidatos considerados: " + candidatosConsiderados);
    }
    
    
    public boolean tieneSolucion() {
        return secuencia != null && !secuencia.isEmpty();
    }


}
