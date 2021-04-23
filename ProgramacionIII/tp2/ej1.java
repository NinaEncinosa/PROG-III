package ProgramacionIII.tp2;

public class ej1 {

	public static void main(String[] args) {
		
		int N = 5;
		int[] arr = new int[N];
		
		//ARREGLO ORDENADO
		arr[0] = 55;
		arr[1] = 65;
		arr[2] = 100;
		arr[3] = 555;
		arr[4] = 679;
		
		imprimir(arr);
		
		System.out.println("el arreglo esta ordenado?");
		
		System.out.println(isSorted(arr,0));
		
		//ARREGLO PASA A ESTAR DESORDENADO
		arr[4] = -5;
		
		System.out.println("=========================");
		imprimir(arr);
		System.out.println("Ahora, el arreglo esta ordenado?");
		
		System.out.println(isSorted(arr,0));
		
		
	}
	
	public static void imprimir (int[] arreglo) {
		for (int i=0; i < arreglo.length; i++) {
			System.out.print(arreglo[i] + " ");
		}
		System.out.println("");
	}
	
	//Ejercicio 1.
	//Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
	//O(n) en el peor de los casos voy hasta el final, caso del arreglo ordenado
	public static Boolean isSorted (int[] arr, int index) {
		boolean aux = false;
		
		if (index+1 < arr.length ) {
			if (arr[index] <= arr[index+1])
				return isSorted(arr, index+1);
		}
		
		else 
			aux = true;
		
		return aux;
	}

}
