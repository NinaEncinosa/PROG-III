package ProgramacionIII.tp3;

import java.util.HashMap;
import java.util.Iterator;

public class Mapa {

	private Grafo<Integer> grafo;
	private HashMap<Integer,Ciudad> ciudades;
	private HashMap<Integer,String> colores;
	
	public Mapa() {
		this.grafo = new GrafoNoDirigido<Integer>();
		this.ciudades = new HashMap<Integer,Ciudad>();
		this.colores = new HashMap<Integer,String>();
	}
	
	public void agregarCiudad(Ciudad ciudad) {
		this.ciudades.put(ciudad.getId(), ciudad);
		this.grafo.agregarVertice(ciudad.getId());
	}
	
	public void eliminarCiudad(Ciudad ciudad) {
		this.ciudades.remove(ciudad.getId());
		this.grafo.borrarVertice(ciudad.getId());
		this.colores.remove(ciudad.getId());
	}
	
	public void agregarCamino(Ciudad ciudadOrigen, Ciudad ciudadDestino, int kilometros) {
		this.grafo.agregarArco(ciudadOrigen.getId(), ciudadDestino.getId(), kilometros);
	}
	
	public void eliminarCamino(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
		this.grafo.borrarArco(ciudadOrigen.getId(), ciudadDestino.getId());
	}
	
	public String getNombreCiudad (int id) {
		if(this.ciudades.containsKey(id)) {
			return this.ciudades.get(id).getNombre();
		}
		else 
			return null;
		
	}

	//Encontrar el camino mas corto en distancia (km) entre 2 ciudades, ATRAVESANDO como maximo una unica balanza (no tengo en cuenta las balanzas de ciudad origen y ciudad destino)
	public Camino encontrarCamino_dfs (Ciudad origen, Ciudad destino) {
		
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}
		
		int kmDelMejorCamino = Integer.MAX_VALUE; //valor discernible
		
		Camino encontrarCamino = encontrarCamino_dfs_visit(origen.getId(),destino.getId(),0,0,kmDelMejorCamino);
		
		//cuando no encuentro un camino viable setteo los km en 0
		if (encontrarCamino.getListCiudades().size() == 0) {
			encontrarCamino.setTotalDeKm(0);
		}

		return encontrarCamino;
		
	}
	
	//Encontrar el camino mas corto en distancia (km) entre 2 ciudades, ATRAVESANDO como maximo una unica balanza (no tengo en cuenta las balanzas de ciudad origen y ciudad destino)
	private Camino encontrarCamino_dfs_visit(int vertice, int verticeObjetivo , int cantBalanzas, int kmRecorridos, int kmDelMejorCamino) {
		
		Camino solucion = new Camino();
		
		//Aca no tengo en cuenta la balanza de la ciudad origen
		//(en caso de querer tener en cuenta esa balanza deberia quitar la primer condicion del if: )
		//if (this.ciudades.get(vertice).poseeBalanza()) {
		if ((kmRecorridos != 0) && (this.ciudades.get(vertice).poseeBalanza())){
			cantBalanzas++;
		}
		
		//Condicion de corte, no entra al else y retorna el camino con los km pasados por parametro
		//Aca no tengo en cuenta la balanza de la ciudad destino
		//(en caso de querer tener en cuenta esa balanza deberia agregar esta condicion al if: )
		//if((cantBalanzas < 2) && (vertice == verticeObjetivo)) {
		if(vertice == verticeObjetivo) {
			solucion.getListCiudades().add(vertice);
			solucion.setTotalDeKm(kmRecorridos);
		}
		
		else{
			colores.put(vertice, "amarillo");
			
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
			
			//recorro todos mis adyacentes y checkeo que no supere el maximo de balanzas 
			while(it.hasNext() && (cantBalanzas < 2)) {
				
				int adyacente = it.next();
				
				if (colores.get(adyacente).equals("blanco")) {

					//sumo km desde donde estoy hasta adyacente
					kmRecorridos += grafo.obtenerArco(vertice, adyacente).getEtiqueta(); 
					
					//PODA, si esta rama va recorriendo mas km de lo que es actualmente mi mejorCamino, no sigue hasta destino, corta ahi
					if(kmRecorridos < kmDelMejorCamino) {
						//busco camino hasta destino
						Camino subCaminosDesdeAdy = encontrarCamino_dfs_visit(adyacente,verticeObjetivo,cantBalanzas,kmRecorridos,kmDelMejorCamino);
						
						//me agrego al inicio del posible camino
						subCaminosDesdeAdy.getListCiudades().add(0,vertice);
	
						//me quedo con el camino mas corto hasta destino de mis adyacentes  
						if((subCaminosDesdeAdy.getListCiudades().contains(verticeObjetivo)) && (subCaminosDesdeAdy.getTotalDeKm() < solucion.getTotalDeKm())) {
							solucion = subCaminosDesdeAdy;
							kmDelMejorCamino = solucion.getTotalDeKm();
						}		
					}
					
					//resto mis km para que el proximo adyacente del while no los tenga
					kmRecorridos -= grafo.obtenerArco(vertice, adyacente).getEtiqueta(); 
				}
			}
			colores.put(vertice, "blanco");
		}
		//devuelvo desde una posicion x el camino mas optimo hasta destino
		return solucion;
	}
		
}
