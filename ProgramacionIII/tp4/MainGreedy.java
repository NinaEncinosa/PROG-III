package ProgramacionIII.tp4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainGreedy {

	public static void main(String[] args) {
		
		Empleado e1 = new Empleado(1,"Juan","Pérez",32,48);
		Empleado e2 = new Empleado(2,"Roberto","Hernández",45,57);
		Empleado e3 = new Empleado(3,"Camila","Gutiérrez",33,51);
		Empleado e4 = new Empleado(4,"Francisco","Martínez",22,73);
		Empleado e5 = new Empleado(5,"Benjamín","Núñez",55,15);
		Empleado e6 = new Empleado(6,"Mateo","Morales",24,33);
		Empleado e7 = new Empleado(7,"Delfina","López",36,92);
		Empleado e8 = new Empleado(8,"Catalina","Cruz",51,71);
		Empleado e9 = new Empleado(9,"Benicio","Montero",48,19);
		Empleado e10 = new Empleado(10,"Valentino","González",58,22);
		Empleado e11 = new Empleado(11,"Olivia","Gómez",33,41);
		Empleado e12 = new Empleado(12,"Martina","Díaz",21,49);
		Empleado e13 = new Empleado(13,"Joaquín","Cabrera",22,14);
		Empleado e14 = new Empleado(14,"Bautista","Domínguez",36,33);
		Empleado e15 = new Empleado(15,"Emilia","Paz",40,16);
		Empleado e16 = new Empleado(16,"Francesca","Figueroa",43,21);
		Empleado e17 = new Empleado(17,"Santino","Blanco",25,79);
		Empleado e18 = new Empleado(18,"Ignacio","Ibarra",61,32);
		Empleado e19 = new Empleado(19,"Andrea","Chávez",27,78);
		Empleado e20 = new Empleado(20,"Elena","Mengochea",52,67);
		
		
		Empleado[] arrEntrada1 = {e1,e2,e3,e4,e5,e6};
		Empleado[] arrEntrada2 = {e7, e4, e8, e15};
		Empleado[] arrEntrada3 = {e19, e12, e11, e13};
		Empleado[] arrEntrada4 = {e19, e18, e14, e16};
		Empleado[] arrEntrada5 = {e7, e8, e20, e3, e16};
		Empleado[] arrEntrada6 = {e6, e15, e17, e13, e16, e10};
		Empleado[] arrEntrada7 = {e17, e2, e19, e20, e4, e12, e15};
		Empleado[] arrEntrada8 = {e12, e14, e18, e6, e2, e9, e10, e16};
		Empleado[] arrEntrada9 = {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20};
		
		
		List<Empleado> entrada1 = Arrays.asList(arrEntrada1);
		List<Empleado> entrada2 = Arrays.asList(arrEntrada2);
		List<Empleado> entrada3 = Arrays.asList(arrEntrada3);
		List<Empleado> entrada4 = Arrays.asList(arrEntrada4);
		List<Empleado> entrada5 = Arrays.asList(arrEntrada5);
		List<Empleado> entrada6 = Arrays.asList(arrEntrada6);
		List<Empleado> entrada7 = Arrays.asList(arrEntrada7);
		List<Empleado> entrada8 = Arrays.asList(arrEntrada8);
		List<Empleado> entrada9 = Arrays.asList(arrEntrada9);

		System.out.println("=== MAIN GREEDY: ===");
		
		imprimirEntrada(entrada1,1);
		Empresa empresa1 = new Empresa(entrada1);
		empresa1.greedy();
		Solucion s1 = empresa1.getSolucion();
		imprimirSolucion(s1);
		
		imprimirEntrada(entrada2,2);
		Empresa empresa2 = new Empresa(entrada2);
		empresa2.greedy();
		Solucion s2 = empresa2.getSolucion();
		imprimirSolucion(s2);
		
		imprimirEntrada(entrada3,3);
		Empresa empresa3 = new Empresa(entrada3);
		empresa3.greedy();
		Solucion s3 = empresa3.getSolucion();
		imprimirSolucion(s3);
		
		imprimirEntrada(entrada4,4);
		Empresa empresa4 = new Empresa(entrada4);
		empresa4.greedy();
		Solucion s4 = empresa4.getSolucion();
		imprimirSolucion(s4);
		
		imprimirEntrada(entrada5,5);
		Empresa empresa5 = new Empresa(entrada5);
		empresa5.greedy();
		Solucion s5 = empresa5.getSolucion();
		imprimirSolucion(s5);
		
		imprimirEntrada(entrada6,6);
		Empresa empresa6 = new Empresa(entrada6);
		empresa6.greedy();
		Solucion s6 = empresa6.getSolucion();
		imprimirSolucion(s6);
		
		imprimirEntrada(entrada7,7);
		Empresa empresa7 = new Empresa(entrada7);
		empresa7.greedy();
		Solucion s7 = empresa7.getSolucion();
		imprimirSolucion(s7);
		
		imprimirEntrada(entrada8,8);
		Empresa empresa8 = new Empresa(entrada8);
		empresa8.greedy();
		Solucion s8 = empresa8.getSolucion();
		imprimirSolucion(s8);
		
		imprimirEntrada(entrada9,9);
		Empresa empresa9 = new Empresa(entrada9);
		empresa9.greedy();
		Solucion s9 = empresa9.getSolucion();
		imprimirSolucion(s9);

	}
	
	public static void imprimirEntrada(List<Empleado> entrada, int idEntrada) {
		System.out.print("Entrada " + idEntrada + " -> ");
		for (int i = 0; i < entrada.size(); i++) {
			System.out.print(" e"+ entrada.get(i).getId() + ":" + entrada.get(i).getFuerza_de_trabajo() + " |");
		}
		System.out.println();
		System.out.println();
	}
	
	public static void imprimirSolucion(Solucion solucion) {
		System.out.print("Empleados del G1: ");
		Iterator<Empleado> itG1 = solucion.getGrupo1().getEmpleados();
		while(itG1.hasNext()) {
			System.out.print("e" + itG1.next().getId() + " ");
		}
		System.out.println(" --> Fuerza total del G1: " + solucion.getGrupo1().getFuerzaGrupo());
		
		System.out.print("Empleados del G2: ");
		Iterator<Empleado> itG2 = solucion.getGrupo2().getEmpleados();
		while(itG2.hasNext()) {
			System.out.print("e" + itG2.next().getId() + " ");
		}
		System.out.println(" --> Fuerza total del G2: " + solucion.getGrupo2().getFuerzaGrupo());
		System.out.println("Diferencia entre grupos: " + solucion.getDiferenciaGrupos());
		
		
		System.out.println("---------------------------------------------");
	}

}
