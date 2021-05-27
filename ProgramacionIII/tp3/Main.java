package ProgramacionIII.tp3;

public class Main {

	public static <T> void main(String[] args) {
		
		Mapa mapa = new Mapa();
		
		Ciudad pehuajo = new Ciudad(1,"Pehuajo",3,true,true,5);
		Ciudad ayacucho = new Ciudad(2,"Ayacucho",1,false,false,2);
		Ciudad olavarria = new Ciudad(3,"Olavarria",9,true,false,17);
		Ciudad rauch = new Ciudad(4,"Rauch",1,false,true,0);
		Ciudad bolivar = new Ciudad(5,"Bolivar",7,false,false,4);
		Ciudad tandil = new Ciudad(6,"Tandil",6,true,true,5);
		Ciudad azul = new Ciudad(7,"Azul",4,false,true,4);
		Ciudad marDelPlata = new Ciudad(8,"MarDelPlata",15,true,false,12);
		
		mapa.agregarCiudad(pehuajo);
		mapa.agregarCiudad(ayacucho);
		mapa.agregarCiudad(olavarria);
		mapa.agregarCiudad(rauch);
		mapa.agregarCiudad(bolivar);
		mapa.agregarCiudad(tandil);
		mapa.agregarCiudad(azul);
		mapa.agregarCiudad(marDelPlata);
		
		mapa.agregarCamino(pehuajo, bolivar, 70);
		mapa.agregarCamino(pehuajo, ayacucho, 540);
		mapa.agregarCamino(ayacucho, rauch, 50);
		mapa.agregarCamino(ayacucho, tandil, 70);
		mapa.agregarCamino(tandil, rauch, 60);
		mapa.agregarCamino(tandil, olavarria, 130);
		mapa.agregarCamino(tandil, marDelPlata, 200);
		mapa.agregarCamino(olavarria, rauch, 210);
		mapa.agregarCamino(olavarria, bolivar, 140);
		mapa.agregarCamino(bolivar, azul, 100);
		
		imprimirEncontrarCamino(mapa,azul,ayacucho);
		
		imprimirEncontrarCamino(mapa,rauch,marDelPlata);
		
		imprimirEncontrarCamino(mapa,marDelPlata,pehuajo);
		
		mapa.eliminarCiudad(ayacucho);
		
		mapa.eliminarCamino(tandil,rauch);
		
		imprimirEncontrarCamino(mapa,marDelPlata,pehuajo);
		
	}
	
	//O(c) donde c es la cantidad de ciudades del mapa, en el peor de los casos tengo un mapa "tipo lista" en el que quiero ir desde la 1er ciudad a la ultima y atravieso todas 
	public static void imprimirEncontrarCamino(Mapa mapa, Ciudad origen, Ciudad destino) {
		System.out.println("Mejor Camino desde "+ origen.getNombre() + " a " + destino.getNombre() );
		Camino mejorCamino = mapa.encontrarCamino_dfs(origen, destino);
		for (Integer idCiudad : mejorCamino.getListCiudades()) {
			System.out.println("  - " + mapa.getNombreCiudad(idCiudad));
		}
		System.out.println("Km del recorrido: " + mejorCamino.getTotalDeKm());
		System.out.println("--------------------");
	}
	
}