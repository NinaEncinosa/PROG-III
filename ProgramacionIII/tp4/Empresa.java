package ProgramacionIII.tp4;

import java.util.Collections;
import java.util.List;

public class Empresa {

	private List<Empleado> entrada;
	private Grupo empleadosSinUsar;
	private Solucion solucion;
	private int iteraciones;
	
	public Empresa(List<Empleado> entrada) {
		this.entrada = entrada;
		this.empleadosSinUsar = cargarTodosLosEmpleados();
		this.solucion = new Solucion();
		this.iteraciones = 0;
	}
	
	//quiero los empleados sin usar almacenados en un grupo por los metodos que este tiene 
	//y me sirven a futuro (ej: fuerzagrupo)
	private Grupo cargarTodosLosEmpleados() {
		Grupo g = new Grupo();
		for (Empleado e: this.entrada) {
			g.agregarEmpleado(e);
		}
		return g;
	}
	
	public Solucion getSolucion() {
		return this.solucion;
	}
	
	//GREEDY
	public void greedy() {
		int index = 0;
		
		ordenarEntrada();
		
		//es solucion cuando ya ubique a todos los empleados
		while(! this.solucion.esSolucion(this.entrada.size())) {
			
			Empleado e = this.entrada.get(index);
			iteraciones++;
			
			//es factuble agregarlo al grupo 1 cuando este tiene menor fuerza de grupo que el grupo 2
			if (this.solucion.esGrupo1Menor())   
				this.solucion.addEmpleadoG1(e);
			else
				this.solucion.addEmpleadoG2(e);
			
			index++;
		}	
		System.out.println("itero : " + this.iteraciones);
	}
	
	public void ordenarEntrada () {
		Collections.sort(entrada,new ComparatorFuerza());
	}
	
	//BACKTRACKING
	public void back () {
		Solucion solucionActual = new Solucion();
		back(0,solucionActual);
		System.out.println("itero : "+ this.iteraciones);
	}
	
	private void back (int indexActual, Solucion solucionActual) {
		iteraciones++;
		//si estoy en estado solucion, es decir, ya distribui el total de empleados en los dos grupos
		if(solucionActual.esSolucion(this.entrada.size())) {
			//si no tenia ninguna solucion almacenada o la solucion antual es mejor a la que tenia almacenada como mejor solucion
			if(!this.solucion.esSolucion(this.entrada.size()) || (solucionActual.getDiferenciaGrupos() < this.solucion.getDiferenciaGrupos())) {
				this.solucion.resetSolucion();
				this.solucion.setGrupo1(solucionActual.getGrupo1());
				this.solucion.setGrupo2(solucionActual.getGrupo2());
			}
		}
		
		else {
			//empleado a agregar
			Empleado e = entrada.get(indexActual);
			indexActual++;


			
			//primer opcion es agregarlo al G1
			solucionActual.addEmpleadoG1(e);
			if (!poda(solucionActual))
				back(indexActual,solucionActual);
			solucionActual.removeEmpleadoG1(e);	
			
			//actualizo mi lista de empleados sin usar, ya que este empleado esta siendo usado lo quito
			this.empleadosSinUsar.quitarEmpleado(e);
			
			//segunda opcion es no agregarlo al G1 y agregarlo al G2
			solucionActual.addEmpleadoG2(e);
			if (!poda(solucionActual))
				back(indexActual,solucionActual);
			solucionActual.removeEmpleadoG2(e);	
			
		}
	}
	
	
	//evaluo si agregando TODOS los empleados que quedan al grupo mas debil llego a una diferencia 
	//entre grupos menor que la que actualmente es mi mejor solucion
	private boolean poda(Solucion posibleSolu) {
		
		//checkear solo si quedan empleados aun sin asignar
		if (this.empleadosSinUsar.getCantEmpleados() != 0) {
			//definicion de variables solo para mejor lectura del codigo
			int difereciaMejorSolucion = this.solucion.getDiferenciaGrupos();
			int fuerzaGrupo1 = posibleSolu.getGrupo1().getFuerzaGrupo();
			int fuerzaGrupo2 = posibleSolu.getGrupo2().getFuerzaGrupo();
			int fuerzaRestante = this.empleadosSinUsar.getFuerzaGrupo();

			//si mi grupo 1 es el grupo mas debil evaluo ese
			if(posibleSolu.esGrupo1Menor()) {
				int posibleFuerzaG1 = fuerzaGrupo1 + fuerzaRestante;
				
				if(getDiferencia(posibleFuerzaG1,fuerzaGrupo2) < difereciaMejorSolucion )
					return true;
				else 
					return false;
			}
			
			else {
				int posibleFuerzaG2 = fuerzaGrupo2 + fuerzaRestante;
				
				if(getDiferencia(fuerzaGrupo1,posibleFuerzaG2) < difereciaMejorSolucion )
					return true;
				else 
					return false;
			}
		}
		
		else 
			return false;
	}
	
	private int getDiferencia(int fuerzaG1, int fuerzaG2) {
		int dif = fuerzaG1 - fuerzaG2;
		return 	Math.abs(dif);
	}
	
}
