package Logic;

public class Par {
	//instance variables
	private int lu;
	private int nota;
	
	//Constructor
	public Par(int lu, int nota) {
		this.lu=lu;
		this.nota=nota;
	}
	
	//Setters
	/**
	 * Establece el numero de lu del alumno
	 */
	public void setLu(int lu) {
		this.lu=lu;
	}
	
	/**
	 * Establece la nota del alumno
	 * @param materia 
	 * @param nota de la materia
	 */
	public void setNota(int nota) {
		if(nota>=0 && nota<=10)this.nota=nota;
	}
		
	//Getters
	/**
	 * @return Retorna el lu del alumno
	 */
	public int getLu() {
		return lu;
	}
	
	/**
	 * @return Retorna la nota del alumno
	 */
	public int getNota() {
		return nota;
	}
}
