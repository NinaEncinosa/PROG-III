package ProgramacionIII.tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	
	//HashMap <key,value> donde key = vertice y value = lista de arcos donde el vertice origen
	//sera = al valor del key en esa posicion y el vertice destino sera un nodo adyacente
	private HashMap <Integer, ArrayList<Arco<T>>> vertices; 

	//CHECK
	public GrafoDirigido() {
		vertices = new HashMap<Integer, ArrayList<Arco<T>>>();
	}
	
	//CHECK
	@Override
	//chequeo que no exista ya ese vertice
	//agrego el vertice (todabia sin adyacentes) al hashmap
	public void agregarVertice(int verticeId) {
		if (!contieneVertice(verticeId)) { //Checkeo que no haya repetidos
			vertices.put(verticeId, new  ArrayList<Arco<T>> ()); //agrego un vertice y aun no tiene adyacentes adjuntos
		}
	}

	//CHECK
	@Override
	//checkeo que exista ese vertice
	//quito el nodo con kev = verticeId del hashmap "vertices" (este posee la lista de arcos salida de ese vertice, por lo tanto se borran tambien esos arcos del grafo
	//obtengo todos los arcos del grafo
	//los recorro 1x1
	//si algun arco tiene como verticeDestino el vertice recien borrado, elimino esa conexion (ese arco)
	public void borrarVertice(int verticeId) {
		if (contieneVertice(verticeId)) {
			vertices.remove(verticeId);
			Iterator<Arco<T>> arcos = obtenerArcos();
			while (arcos.hasNext()) {
				Arco<T> current = arcos.next();
				if (current.getVerticeDestino() == verticeId) {
					borrarArco(current.getVerticeOrigen(),verticeId);
				}
			}
			
		}
	}
	
	//CHECK
	//chequeo que existan los vertices a los que les voy a agregar una conexion
	//creo un nuevo objeto Arco<T> con los valores deseado
	//agrego el arco a la lista de arcos salientes del nodo con key = verticeOrigen del arco
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (contieneVertice(verticeId1) && (contieneVertice(verticeId2))) {
			Arco<T> newArcoDeV1aV2 = new Arco<T>(verticeId1, verticeId2, etiqueta);
			vertices.get(verticeId1).add(newArcoDeV1aV2);
		}
	}
	
	//CHECK
	//chequeo que exista el arco
	//busco un vertice que sea igual al vertice origen del arco 
	//busco entre todos los adyacentes al vertice origen, un adyacente que sea = al vertice destino
	//borro la conexion entre ambos, el arco
	@Override
	public void borrarArco(int verticeOrigen, int verticeDestino) {
		if (existeArco(verticeOrigen,verticeDestino)) { 
			ArrayList<Arco<T>> arcos = vertices.get(verticeOrigen);
			for (int i=0; i < arcos.size(); i++) {
				if(arcos.get(i).getVerticeDestino() == verticeDestino) {
					arcos.remove(i);
				}
				
			}
		}
	}
	
	//CHECK
	//utilizo metodo propio del hashmap
	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	//CHECK
	//chequeo que exista el vertice desde donde sale el arco
	//me fijo en la lista de adyacentes al vertice si alguno tiene como vertice destino al vertice 2
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if(contieneVertice(verticeId1)) {
			Iterator<Arco<T>> arcos = obtenerArcos(verticeId1);
			while(arcos.hasNext()) {
				if(arcos.next().getVerticeDestino() == verticeId2) {
					return true;
				}
			}
		}	
		return false;
	}

	//CHECK
/////////////
/////////////
//como devuelvo el arco si no lo encontre? 
// para que sirve el obtener arco si uso una estructura hashmap?
/////////////
/////////////
	//creo un nuevo arco "vacio" (con valores discernibles) 
	//checkeo que exista un arco entre los vertices pasados por parametro
	//me posiciono en el vertice origen y guardo su lista de adyacentes
	//recorro la lista de adyacentes hasta encontrar uno = al vertice destino del arco
	//guardo la etiqueta que tiene el arco encontrado y retorno un arco auxiliar con el valor de la etiqueta obtenida 
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Arco<T> salida = new Arco<T>(-1000,-1000,(T)"null");	
		if (existeArco(verticeId1,verticeId2)) {
			Iterator <Arco<T>> aux = obtenerArcos(verticeId1);
			while (aux.hasNext()) {
				Arco<T> current = aux.next();
				if ((current.getVerticeOrigen() == verticeId1) && (current.getVerticeDestino() == verticeId2)) {
					T etiqueta = current.getEtiqueta();
					salida = new Arco<T> (verticeId1,verticeId2,etiqueta);			
				}
			}
			
		}
		return salida;
	}

	//CHECK
	//metodo interno del hashmap, cuenta la cantidad de nodos que tiene
	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	//CHECK
	//obtengo todos los arcos del hashmap y cuento usando un iterador, cuantos son
	@Override
	public int cantidadArcos() {
		Iterator<Arco<T>> itArcos = obtenerArcos();
		int count = 0;
		
		while(itArcos.hasNext()) {
			count++;
			itArcos.next();
		}
		
		return count;
	}

	//CHECK
	//metodo interno del hashmap 
	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}
	
	//CHECK
	//checkeo que exista el vertice
	//guardo todos los arcos que tengan como origen el vertice pasado por parametro
	//todos los vertices destinos de esos arcos seran los vertices adyacentes que tenemos que agregar a la lista salida
	//paso el arraylist a iterator y retorno
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Integer> adyacentesList = new ArrayList<Integer>();
		
		if(contieneVertice(verticeId)) {
			Iterator<Arco<T>> itArcos = obtenerArcos(verticeId);
			
			while (itArcos.hasNext()) {
				Arco<T> current = itArcos.next();
				adyacentesList.add(current.getVerticeDestino());
			}
			
		}
		return adyacentesList.iterator();
	}
	
	//CHECK
	//con ayuda de google para el forEachRemaining..
	//obtengo la lista de todos los vertices
	//creo lista salida de arcos vacia
	//me paro en cada vertice del grafo y agrego su lista de adyacentes a la lista salida
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		Iterator<Integer> verticesIt = obtenerVertices();
		ArrayList<Arco<T>> arcosList = new ArrayList<Arco<T>>();
				
		while (verticesIt.hasNext()) {
			int current = verticesIt.next();
			Iterator<Arco<T>> adyacentes = obtenerArcos(current);
			adyacentes.forEachRemaining(arcosList::add);	
		}
		return arcosList.iterator();
	}

	//CHECK
	//busco en el hashmap el vertice y devuelvo el atributo correspondiente al value de ese nodo
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco<T>> arcosList = new ArrayList<Arco<T>>();
		if (contieneVertice(verticeId)) {
			arcosList = vertices.get(verticeId);
			return arcosList.iterator();
		}
		return arcosList.iterator();
	}

}