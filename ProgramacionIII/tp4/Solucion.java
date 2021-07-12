package ProgramacionIII.tp4;

import java.util.Iterator;

public class Solucion {
	private Grupo grupo1;
	private Grupo grupo2;
	private int cantEmpleados;
	
	public Solucion() {
		this.grupo1 = new Grupo();
		this.grupo2 = new Grupo();
		this.cantEmpleados = 0;
	}
	
	public void resetSolucion() {
		this.grupo1 = new Grupo();
		this.grupo2 = new Grupo();
		this.cantEmpleados = 0;
	}
	
	public void setGrupo1(Grupo g){
		this.grupo1 = g;
		this.cantEmpleados += g.getCantEmpleados(); 
	}
	
	public void setGrupo2(Grupo g){
		this.grupo2 = g;
		this.cantEmpleados += g.getCantEmpleados(); 
	}
	
	//retorna una copia
	public Grupo getGrupo1() {
		Grupo g = new Grupo();
		Iterator<Empleado> it = this.grupo1.getEmpleados();
		
		while(it.hasNext()) {
			g.agregarEmpleado(it.next());
		}
		
		return g;
		
	}
	
	//retorna una copia
	public Grupo getGrupo2(){
		Grupo g = new Grupo();
		Iterator<Empleado> it = this.grupo2.getEmpleados();
		
		while(it.hasNext()) {
			g.agregarEmpleado(it.next());
		}
		
		return g;
	}
	
	public int getCantidadEmpleados() {
		return this.cantEmpleados;
	}
	
	public void removeEmpleadoG1(Empleado e) {
		this.grupo1.quitarEmpleado(e);
		this.cantEmpleados--;
	}
	
	public void removeEmpleadoG2(Empleado e) {
		this.grupo2.quitarEmpleado(e);
		this.cantEmpleados--;
	}

	public void addEmpleadoG1(Empleado e) {
		this.grupo1.agregarEmpleado(e);
		this.cantEmpleados++;
	}
	
	public void addEmpleadoG2(Empleado e) {
		this.grupo2.agregarEmpleado(e);
		this.cantEmpleados++;
	}
	
	public int getDiferenciaGrupos() {
		int dif = this.grupo1.getFuerzaGrupo() - this.grupo2.getFuerzaGrupo();
		return 	Math.abs(dif);
	}
	
	public boolean esSolucion(int empleadosEmpresa) {
		return empleadosEmpresa == this.cantEmpleados;
	}
	
	public boolean esGrupo1Menor() {
		return (this.grupo1.getFuerzaGrupo() < this.grupo2.getFuerzaGrupo());
	}
	
}
