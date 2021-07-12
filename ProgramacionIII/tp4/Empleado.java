package ProgramacionIII.tp4;

public class Empleado {
	
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private int fuerza_de_trabajo;
	
	public Empleado(int id, String nombre, String apellido, int edad, int fuerza_de_trabajo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fuerza_de_trabajo = fuerza_de_trabajo;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public int getFuerza_de_trabajo() {
		return fuerza_de_trabajo;
	}

}
