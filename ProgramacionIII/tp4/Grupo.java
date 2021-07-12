package ProgramacionIII.tp4;

import java.util.ArrayList;
import java.util.Iterator;

public class Grupo {
	private ArrayList<Empleado> grupo;
	private int fuerzaGrupo;
	
	public Grupo () {
		this.grupo = new ArrayList<Empleado>();
		this.fuerzaGrupo = 0;
	}
	
	public Iterator<Empleado> getEmpleados(){
		Iterator<Empleado> it = this.grupo.iterator();
		return it;
	}
	
	public int getCantEmpleados() {
		return grupo.size();
	}
	
	public int getFuerzaGrupo() {
		return this.fuerzaGrupo;
	}
	
	public void agregarEmpleado(Empleado e) {
		this.grupo.add(e);
		this.fuerzaGrupo += e.getFuerza_de_trabajo();
	}
	
	public void quitarEmpleado(Empleado e) {
		if (this.grupo.contains(e)) {
			this.grupo.remove(e);
			this.fuerzaGrupo -= e.getFuerza_de_trabajo();
		}
	}
}
