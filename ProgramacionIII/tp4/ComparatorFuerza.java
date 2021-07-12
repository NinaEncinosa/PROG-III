package ProgramacionIII.tp4;

import java.util.Comparator;

public class ComparatorFuerza implements Comparator<Empleado> {

	@Override
	public int compare(Empleado o1, Empleado o2) {
		return o2.getFuerza_de_trabajo() - o1.getFuerza_de_trabajo();
	}

	
}
