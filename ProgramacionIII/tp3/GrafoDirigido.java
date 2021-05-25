package ProgramacionIII.tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	
	//HashMap <key,value> donde key = vertice y value = lista de arcos donde el vertice origen
	//sera = al valor del key en esa posicion y el vertice destino sera un nodo adyacente
	private HashMap <Integer, ArrayList<Arco<T>>> vertices; 

	//O(1)
	public GrafoDirigido() {
		vertices = new HashMap<Integer, ArrayList<Arco<T>>>();
	}
	


	//chequeo que no exista ya ese vertice
	//agrego el vertice (todabia sin adyacentes) al hashmap
	//O(1)
	@Override
	public void agregarVertice(int verticeId) {
		if (!contieneVertice(verticeId)) {  //O(1)
			vertices.put(verticeId, new  ArrayList<Arco<T>> ());  //O(1)
		}
	}

//?
	//checkeo que exista ese vertice
	//quito el nodo con kev = verticeId del hashmap "vertices" (este posee la lista de arcos salida de ese vertice, por lo tanto se borran tambien esos arcos del grafo
	//obtengo todos los arcos del grafo
	//los recorro 1x1
	//si algun arco tiene como verticeDestino el vertice recien borrado, elimino esa conexion (ese arco)
	//O(v * a^2) v = cantidad de vertices, a = promedio de los tamanios de las listas de adyacentes
	@Override
	public void borrarVertice(int verticeId) {
		if (contieneVertice(verticeId)) {	//O(1)
			vertices.remove(verticeId);		//O(1)
			Iterator<Arco<T>> arcos = obtenerArcos(); // //O(v*a), v = cantidad de vertices, a = promedio de los tamanios de las listas de adyacentes a cada vertice
			while (arcos.hasNext()) {	//O(a), a = cantidad de arcos
				Arco<T> current = arcos.next();
				if (current.getVerticeDestino() == verticeId) { //O(1)
					borrarArco(current.getVerticeOrigen(),verticeId);  //O(a), a = tamanio de la lista de adyacentes al vertice current
				}
			}
		}
	}
	
	
	//chequeo que existan los vertices a los que les voy a agregar una conexion
	//creo un nuevo objeto Arco<T> con los valores deseado
	//agrego el arco a la lista de arcos salientes del nodo con key = verticeOrigen del arco
	//O(1) 
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (contieneVertice(verticeId1) && (contieneVertice(verticeId2))) { //O(1)
			Arco<T> newArcoDeV1aV2 = new Arco<T>(verticeId1, verticeId2, etiqueta);
			vertices.get(verticeId1).add(newArcoDeV1aV2); //O(1)
		}
	}
	

	//chequeo que exista el arco
	//busco un vertice que sea igual al vertice origen del arco 
	//busco entre todos los adyacentes al vertice origen, un adyacente que sea = al vertice destino
	//borro la conexion entre ambos, el arco
	//O(a), a = tamanio de la lista de adyacentes al verticeOrigen 
	@Override
	public void borrarArco(int verticeOrigen, int verticeDestino) {
		if (existeArco(verticeOrigen,verticeDestino)) {  //O(a), a = tamanio de la lista de adyacentes al verticeOrigen 
			ArrayList<Arco<T>> arcos = vertices.get(verticeOrigen);	//O(1)
			for (int i=0; i < arcos.size(); i++) {	//O(a), a = cantidad de arcos
				if(arcos.get(i).getVerticeDestino() == verticeDestino) {	//O(1)
					arcos.remove(i);	//O(1)
				}
				
			}
		}
	}
	

	//utilizo metodo propio del hashmap
	//O(1)
	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	//chequeo que exista el vertice desde donde sale el arco
	//me fijo en la lista de adyacentes al vertice si alguno tiene como vertice destino al vertice 2
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
	
//? se podria sacar el if y mejorar la complejidad
	//creo un nuevo arco null
	//checkeo que exista un arco entre los vertices pasados por parametro
	//me posiciono en el vertice origen y guardo su lista de adyacentes
	//recorro la lista de adyacentes hasta encontrar uno = al vertice destino del arco
	//guardo la etiqueta que tiene el arco encontrado y retorno un arco auxiliar con el valor de la etiqueta obtenida 
//?	//O(a^2), a = tamanio de lista de adyacentes al verticeId1, debo recorrer esa lista 2 veces  
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Arco<T> salida = null;	
		if (existeArco(verticeId1,verticeId2)) { //O(a), a = tamanio de la lista de adyacentes al verticeId1 
			Iterator <Arco<T>> aux = obtenerArcos(verticeId1); //O(1)
			while (aux.hasNext()) { //O(a), a = cantidad de adyacentes al verticeId1 
				Arco<T> current = aux.next();
				if ((current.getVerticeOrigen() == verticeId1) && (current.getVerticeDestino() == verticeId2)) { //O(1)
					T etiqueta = current.getEtiqueta();
					salida = new Arco<T> (verticeId1,verticeId2,etiqueta);			
				}
			}
			
		}
		return salida;
	}


	//metodo interno del hashmap, cuenta la cantidad de nodos que tiene
	//O(1)
	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	//obtengo todos los arcos del hashmap y cuento usando un iterador, cuantos son
	//O(v*a), v = cantidad de vertices, a = promedio de los tamanios de las listas de adyacentes a cada vertice
	@Override
	public int cantidadArcos() {
		Iterator<Arco<T>> itArcos = obtenerArcos(); //O(v*a), v = cantidad de vertices, a = promedio de los tamanios de las listas de adyacentes a cada vertice
		int count = 0;
		
		while(itArcos.hasNext()) { //O(a), a = cantidad de arcos  
			count++;
			itArcos.next();
		}
		
		return count;
	}

	//metodo interno del hashmap 
	//O(1) devolver el keyset de un hashmap es una compejidad constante, pasar esa lista resultado a iterador tambien es constante
	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}
	
	
	//checkeo que exista el vertice
	//guardo todos los arcos que tengan como origen el vertice pasado por parametro
	//todos los vertices destinos de esos arcos seran los vertices adyacentes que tenemos que agregar a la lista salida
	//paso el arraylist a iterator y retorno
	
	//O(a) siendo "a" el tamanio de la lista de adyacentes a un verticeId
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Integer> adyacentesList = new ArrayList<Integer>();
		
		if(contieneVertice(verticeId)) { 	//O(1)
			Iterator<Arco<T>> itArcos = obtenerArcos(verticeId); //O(1)
			
			while (itArcos.hasNext()) {	//O(a) siendo "a" el tamanio de la lista de adyacentes a un verticeId
				Arco<T> current = itArcos.next();
				adyacentesList.add(current.getVerticeDestino());  //O(1)
			}
			
		}
		return adyacentesList.iterator();
	}
	
	//con ayuda de google para el forEachRemaining..
	//obtengo la lista de todos los vertices
	//creo lista salida de arcos vacia
	//me paro en cada vertice del grafo y agrego su lista de adyacentes a la lista salida
	
	//O(v*a), v = cantidad de vertices, a = promedio de los tamanios de las listas de adyacentes a cada vertice
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		Iterator<Integer> verticesIt = obtenerVertices(); 	//O(v) siendo v el tamanio del hashmap vertices
		ArrayList<Arco<T>> arcosList = new ArrayList<Arco<T>>();
				
		while (verticesIt.hasNext()) {		//O(v) siendo v el tamanio del hashmap vertices
			int current = verticesIt.next();
			Iterator<Arco<T>> adyacentes = obtenerArcos(current); //O(1)
			adyacentes.forEachRemaining(arcosList::add);	//O(a) siendo "a" el tamanio de la lista de adyacentes al vertice
		}
		
		return arcosList.iterator(); //O(1)
	}


	//busco en el hashmap el vertice y devuelvo el atributo correspondiente al value de ese nodo
	
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