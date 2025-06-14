package TP;

public class maquina {
	
	private String nombre;
	private int piezas;
	
	public maquina(String nombre, int piezas) {
		this.nombre = nombre;
		this.piezas = piezas;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPiezas() {
		return piezas;
	}
	
	public String toString() {
		return nombre;
	}

}
