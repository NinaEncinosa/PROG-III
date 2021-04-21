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
		
		System.out.println(isSorted(arr,0,0));
		
		//ARREGLO PASA A ESTAR DESORDENADO
		arr[2] = -5;
		
		System.out.println("=========================");
		imprimir(arr);
		System.out.println("Ahora, el arreglo esta ordenado?");
		
		System.out.println(isSorted(arr,0,0));
		
		
	}
	
	public static void imprimir (int[] arreglo) {
		for (int i=0; i < arreglo.length; i++) {
			System.out.print(arreglo[i] + " ");
		}
		System.out.println("");
	}
	
	//Ejercicio 1.
	//Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
	//?? COMPLEJIDAD?? O(log n)?
	public static int isSorted (int[] arr, int izq, int der) {
		int aux = -1;
		
		if (der < arr.length ) {
			if (arr[izq] <= arr[der])
				return isSorted(arr, der, (der+1));
		}
		
		else 
			aux = 1;
		
		return aux;
	}

}
