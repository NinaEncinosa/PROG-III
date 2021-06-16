package ProgramacionIII.tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class GrafoDirigido<T> implements Grafo<T> {
	
	//HashMap <key,value> donde key = vertice y value = lista de arcos donde el vertice origen
	//sera = al valor del key en esa posicion y el vertice destino sera un nodo adyacente
	private HashMap <Integer, ArrayList<Arco<T>>> vertices; 
	private int cantArcos;

	
	//O(1)
	public GrafoDirigido() {
		vertices = new HashMap<Integer, ArrayList<Arco<T>>>();
		cantArcos = 0;
	}
	
	
	//O(1)
	@Override
	public void agregarVertice(int verticeId) {
		if (!contieneVertice(verticeId)) {  //O(1)
			vertices.put(verticeId, new  ArrayList<Arco<T>> ());  //O(1)
		}
	}

	//O(v*a) v = cantidad de vertices y a = cantidad de arcos promedio de cada vertice
	@Override
	public void borrarVertice(int verticeId) {
		if (contieneVertice(verticeId)) {	//O(1)
			int cantAdy = vertices.get(verticeId).size();
			vertices.remove(verticeId);		//O(1)
			cantArcos -= cantAdy;

			borrarArcosConDestinoIgualAVertice(verticeId); //O(v*a)
			
		}
	}
	
	//O(v*a) v = cantidad de vertices y a = cantidad de arcos promedio de cada vertice
	public void borrarArcosConDestinoIgualAVertice(int verticeId) {		

		Iterator <ArrayList<Arco<T>>> itTodosLosArcos = vertices.values().iterator(); 

		//O(v*a) v = cantidad de vertices y a = cantidad de arcos promedio de cada vertice
		while (itTodosLosArcos.hasNext()) {
			ArrayList<Arco<T>> current = itTodosLosArcos.next();
			Iterator <Arco<T>> it = current.iterator();
			
			while(it.hasNext()) {
				Arco<T> arco = it.next();
				if (arco.getVerticeDestino() == verticeId) { 
					it.remove(); //borro el arco en el que estoy parada
					cantArcos--;
					//o.. opcion2: podria crear una lista con elementos a borrar y despues de iterar los borro
				}
			}
			//opcion2: aca le diria al current que haga el remove de la lista a remover creada
			
		}

	}
	

	//O(a), a = tamanio de la lista de adyacentes al verticeId1 
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		//checkeo que existan los vertices a conectar
		if (contieneVertice(verticeId1) && (contieneVertice(verticeId2))) { //O(1)
			//verifico que el arco a agregar no exista
			if(!existeArco(verticeId1,verticeId2)) { //O(a), a = tamanio de la lista de adyacentes al verticeId1 
				Arco<T> newArcoDeV1aV2 = new Arco<T>(verticeId1, verticeId2, etiqueta);
				vertices.get(verticeId1).add(newArcoDeV1aV2); //O(1)
				cantArcos++;
			}
		}
	}
	

	//O(a), a = tamanio de la lista de adyacentes al verticeOrigen 
	@Override
	public void borrarArco(int verticeOrigen, int verticeDestino) {
		ArrayList<Arco<T>> arcos = vertices.get(verticeOrigen);	//O(1)
			
		if(arcos!= null) {
			for (int i=0; i < arcos.size(); i++) {	//O(a), a = cantidad de arcos
				if(arcos.get(i).getVerticeDestino() == verticeDestino) {	//O(1)
					arcos.remove(i);	//O(1)
					cantArcos--;
				}
					
			}
		}
	}
	

	//O(1)
	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	
	//O(a), a = tamanio de la lista de adyacentes al verticeId1 
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if(contieneVertice(verticeId1)) { //O(1)
			Iterator<Arco<T>> arcos = obtenerArcos(verticeId1); 	//O(1)
			while(arcos.hasNext()) {	//O(a), a = tamanio de la lista de adyacentes al verticeId1 
				if(arcos.next().getVerticeDestino() == verticeId2) { 	//O(1)
					return true;
				}
			}
		}	
		return false;
	}
	
	//O(a), a = tamanio de lista de adyacentes al verticeId1
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Arco<T> salida = null;	
		Iterator <Arco<T>> aux = obtenerArcos(verticeId1); //O(1)
		
		while (aux.hasNext()) { //O(a), a = cantidad de adyacentes al verticeId1 
			Arco<T> current = aux.next();
			if ((current.getVerticeOrigen() == verticeId1) && (current.getVerticeDestino() == verticeId2)) { //O(1)
				T etiqueta = current.getEtiqueta();
				salida = new Arco<T> (verticeId1,verticeId2,etiqueta);			
			}
		}	
		
		return salida;
	}


	//O(1)
	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	//O(1)
	@Override
	public int cantidadArcos() {
		return this.cantArcos;	
	}


	//O(1) devolver el keyset de un hashmap es una compejidad constante, pasar esa lista resultado a iterador tambien es constante
	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}
	
	
	//O(1) mediante encapsular mi iterador dentro de una clase que exclusivamente recorre a travez de it.next().getVerticeDestino() reduzco la complejidad
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		Iterator<Arco<T>> itInterno = vertices.get(verticeId).iterator();
		return new IteradorAdyacentes<T>(itInterno);
	}
	
	
	//O(v*a), v = cantidad de vertices, a = promedio de los tamanios de las listas de adyacentes a cada vertice
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		Iterator<Integer> verticesIt = obtenerVertices(); 	//O(v), v = tamanio del hashmap vertices 
		ArrayList<Arco<T>> arcosList = new ArrayList<Arco<T>>();
				
		while (verticesIt.hasNext()) {		//O(v*a), v = tamanio del hashmap vertices y a = promedio de los tamanios de las listas de adyacentes a cada vertice
			int current = verticesIt.next();
			Iterator<Arco<T>> adyacentes = obtenerArcos(current); //O(1)
			
			//forEachRemaining hecho con ayuda de google :)
			adyacentes.forEachRemaining(arcosList::add);	
		}
		
		return arcosList.iterator(); //O(1)
	}

	
	//O(1) 
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco<T>> arcosList = new ArrayList<Arco<T>>();
		
		if (contieneVertice(verticeId)) { //O(1)
			arcosList = vertices.get(verticeId);	//O(1)
			return arcosList.iterator();	//O(1) 
		}
		
		return arcosList.iterator();
	}

}