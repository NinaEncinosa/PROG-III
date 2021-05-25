package ProgramacionIII.tp3;

public class Ciudad{
	
	private int id;
	private String nombre;
	private int cantEstacionesServicio;
	private boolean poseeBalanza;
	private boolean poseeRadares;
	private int cantTalleresMecanicos;

	public Ciudad(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Ciudad(int id, String nombre, boolean balanza) {
		this.id = id;
		this.nombre = nombre;
		this.poseeBalanza = balanza;
	}

	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getCantEstacionesServicio() {
		return cantEstacionesServicio;
	}

	public void setCantEstacionesServicio(int cantEstacionesServicio) {
		this.cantEstacionesServicio = cantEstacionesServicio;
	}

	public boolean poseeBalanza() {
		return poseeBalanza;
	}

	public void setPoseeBalanza(boolean poseeBalanza) {
		this.poseeBalanza = poseeBalanza;
	}

	public boolean poseeRadares() {
		return poseeRadares;
	}

	public void setPoseeRadares(boolean poseeRadares) {
		this.poseeRadares = poseeRadares;
	}

	public int getCantTalleresMecanicos() {
		return cantTalleresMecanicos;
	}

	public void setCantTalleresMecanicos(int cantTalleresMecanicos) {
		this.cantTalleresMecanicos = cantTalleresMecanicos;
	}
	
}
