package Logic;

import java.util.Iterator;
import TDALista.*;

public class Main {
	private String nomMateria;
	private PositionList<Par> listaAlumnos;
	
	/**
	 * 
	 * @param Nombre de la materia 
	 */
	public Main(String materia) {
		nomMateria = materia;
		listaAlumnos = new ListaDoblementeEnlazada<Par>();
	}
	
	/**
	 * Si la nota esta en entre 0 y 10 verifica que no halla otro alumno con el mismo lu,
	 * de lo contrario crea un Par y lo agrega a la lista alumnos
	 * de lo contrario no agrega nada
	 * @param lu
	 * @param nota
	 */
	public void agregarAlumno(int lu,int nota){
		if(nota>=0 && nota<=10) {
			Iterator<Par> it = listaAlumnos.iterator();
			Par alumno = null;
			boolean flag = false;
			while(it.hasNext() && !flag) {
				alumno = it.next();
				if(alumno.getLu()==lu) {
					flag = true;
				}
			}
			if(!flag) {
				Par alumnoNuevo = new Par(lu,nota);
				listaAlumnos.addFirst(alumnoNuevo);
			}
		}
	}

	/**
	 * Retorna el nombre de la materia
	 * @return nombre de la materia
	 */
	public String getMateria() {
		return nomMateria;
	}
	
	/**
	 * Retorna un alumno mediante su lu
	 * @param lu del alumno
	 */
	public Par obtenerAlumno(int lu) {
		Par toReturn = null;
		Iterator<Par> it = listaAlumnos.iterator();
		Par aux;
		//Recorro la lista 
		
		while(it.hasNext() && toReturn == null) {
			aux = it.next();
			if(aux.getLu() == lu) toReturn = aux;
		}
		
		return toReturn;
	}
	
	/**
	 * Si existe alumno retorna la nota del mismo sino retorna -1
	 * @param lu
	 * @return nota del alumno
	 */
	public int verNota(int lu) {
		int toRet=-1;
		Iterator<Par> it = listaAlumnos.iterator();
		Par alumno = null;
		boolean flag = false;
		while(it.hasNext() && !flag) {
			alumno = it.next();
			if(alumno.getLu()==lu) {
				flag = true;
				toRet = alumno.getNota();
			}
		}
		return toRet;
	}
	
	/**
	 * Calcula el promedio de la materia
	 * @return promedio de la materia
	 */
	public double calcularPromedio() {
		double prom=0;
		for(Par alumno : listaAlumnos) {
			prom = prom + alumno.getNota();
		}
		return prom/listaAlumnos.size();
	}
	
	/**
	 * Recorre la lista de alumnos si coincide materia con lu lo elimina y tira true
	 * sino tira false
	 * @param lu
	 * @param materia
	 */
	public boolean eliminarRegistro(int lu) {
		Iterable<Position<Par>> lpos = listaAlumnos.positions();
		boolean flag = false;
		Iterator<Position<Par>> it = lpos.iterator();
		while( it.hasNext() && !flag ) {
			Position<Par> p = it.next();
			if (p.element().getLu() == lu) {
				flag = true;
				try {
					listaAlumnos.remove(p);
				} catch (InvalidPositionException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return flag;
	}
	
	/**
	 * Retorna la lista de alumnos
	 * @return PositionList<Par>
	 */
	public PositionList<Par> getRegistro() {
        return listaAlumnos;
    }
	
	/**
	 * Si existe alumno retorna true sino false (si es falso la gui lo crea) 
	 * @param lu
	 */
	public boolean verificarAlumno(int lu) {
		boolean flag = false;
		Iterator<Par> it = listaAlumnos.iterator();
		while ( it.hasNext() && !flag) { 
			Par alumno = it.next();
			flag = alumno.getLu() == lu;
		}
		return flag;
	}
	
	/**
	 * Si existe alumno con mas de una nota retorna true sino false
	 * @param lu
	 */
	public boolean masDeUnaNota(int lu) {
		boolean flag = false;
		Iterator<Par> it = listaAlumnos.iterator();
		while ( it.hasNext() && !flag) { 
			Par alumno = it.next();
			flag = alumno.getLu() == lu;
		}
		return flag;
	}
	
	/**
	 * Busca y agrega a una lista a todos alumnos con notas mayores o igual a 6
	 * @return PositionList<Integer> de Lu's
	 */
	public PositionList<Par> alumnosAprobados(){
		PositionList<Par> alumnosAprobados = new ListaDoblementeEnlazada<Par>();
		for(Par alumno : listaAlumnos) {
			if(alumno.getNota()>=6) alumnosAprobados.addFirst(alumno);
		}
		return alumnosAprobados;
	}
	
	/**
	 * Busca y agrega a una lista a todos los alumnos con notas menores a 6
	 * @return PositionList<Integer> de Lu's
	 */
	public PositionList<Par> alumnosDesaprobados(){
		PositionList<Par> alumnosDesprobados = new ListaDoblementeEnlazada<Par>();
		for(Par alumno : listaAlumnos) {
			if(alumno.getNota()<6) alumnosDesprobados.addFirst(alumno);
		}
		return alumnosDesprobados;
	}
	
	/**
	 * Utiliza una cola con prioridad para ordenar los datos y buscar la minima nota
	 * @return nota mina 
	 */
	public int notaMinima() {
		//usa una CCP
		return 0;
	}
	
	/**
	 * Ordena a todos los alumnos en una lista ordenada de mayor a menor
	 * @return PositionList<Integer>
	 */
	public PositionList<Par> ordenarMayorMenor(){
		//usa una CCP
		return null;
	}
	
	/**
	 * Busca y agrega a una lista a todos los alumnos con nota 'n'
	 * @param nota
	 * @return PositionList<Integer>
	 */
	public PositionList<Par> buscarPorNota(int n){
		//usa un diccionario
		return null;
	}
	
}
