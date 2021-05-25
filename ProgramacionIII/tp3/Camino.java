package ProgramacionIII.tp3;

import java.util.ArrayList;

public class Camino {

	private int totalDeKm;
	private ArrayList<Integer> listCiudades;
	
	public Camino () {
		this.totalDeKm = 999999999;
		this.listCiudades = new ArrayList<Integer>();
	}
	
	public void setTotalDeKm(int km) {
		this.totalDeKm = km;
	}
	
	public int getTotalDeKm() {
		return totalDeKm;
	}

	public ArrayList<Integer> getListCiudades() {
		return listCiudades;
	}

	public void setIdCiudades(ArrayList<Integer> listCiudades) {
		this.listCiudades = listCiudades;
	}
	
	
}
