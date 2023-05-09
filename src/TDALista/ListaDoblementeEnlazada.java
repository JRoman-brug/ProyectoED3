package TDALista;

import java.util.Iterator;

import TDALista.*;

public class ListaDoblementeEnlazada<E> implements PositionList<E>{
	private DNode<E> header;
	private DNode<E> trailer;
	private int size;
	
	public ListaDoblementeEnlazada(){
		header = new DNode<E>(null);
		trailer= new DNode<E>(null);
		
		header.setPrev(null);
		header.setNext(trailer);
		
		trailer.setPrev(header);
		trailer.setNext(null);
		
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Position<E> first() throws EmptyListException {
		if(isEmpty()) throw new EmptyListException("Lista vacia");
		return header.getNext();
	}

	public Position<E> last() throws EmptyListException {
		if(isEmpty()) throw new EmptyListException("Lista vacia");
		return trailer.getPrev();
	}

	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		if(p == trailer.getPrev()) throw new BoundaryViolationException("---");
		DNode<E> n = CheckPosition(p);
		return n.getNext();
	}

	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<E> n = CheckPosition(p);
		if(n == header.getNext()) throw new BoundaryViolationException("---");
		return n.getPrev();
	}

	public void addFirst(E element) {
		DNode<E> aux = new DNode<E>(element,header.getNext(),header);
		header.getNext().setPrev(aux);
		header.setNext(aux);
		size++;
	}

	public void addLast(E element) {
		DNode<E> aux = new DNode<E>(element,trailer,trailer.getPrev());
		trailer.getPrev().setNext(aux);;
		trailer.setPrev(aux);
		size++;
	}

	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
		DNode<E> aux = CheckPosition(p);
		DNode<E> nuevo = new DNode<E>(element);
		
		nuevo.setPrev(aux);
		nuevo.setNext(aux.getNext());
		
		aux.getNext().setPrev(nuevo);
		aux.setNext(nuevo);
		
		size++;
	}

	
	public void addBefore(Position<E> p, E element) throws InvalidPositionException {
		DNode<E> aux = CheckPosition(p);
		DNode<E> nuevo = new DNode<E>(element);
		
		nuevo.setPrev(aux.getPrev());
		nuevo.setNext(aux);
		
		aux.getPrev().setNext(nuevo);
		aux.setPrev(nuevo);
		
		size++;
	}

	public E remove(Position<E> p) throws InvalidPositionException {
		DNode<E> aux = CheckPosition(p);
		E toReturn = p.element();
		
		aux.getNext().setPrev(aux.getPrev());
		aux.getPrev().setNext(aux.getNext());
		
		aux.setElement(null);
		aux.setNext(null);
		aux.setPrev(null);
		size--;
		return toReturn;
	}

	public E set(Position<E> p, E element) throws InvalidPositionException {
		DNode<E> aux = CheckPosition(p);
		E toReturn = p.element();
		
		aux.setElement(element);
		
		return toReturn;
	}

	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}

	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> p = new ListaDoblementeEnlazada<Position<E>>();
		try {
			if(!isEmpty()) {
				
				Position<E> pos= first();
				while(pos != last()) {
					p.addLast(pos);
					pos = next(pos);
				}
				p.addLast(pos);
			}
		}catch(EmptyListException |InvalidPositionException |BoundaryViolationException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	private DNode<E> CheckPosition(Position<E> p)throws InvalidPositionException{
		try{
			//Si es nulo lanza que p es una posicion invalida
			if(p==null) throw new InvalidPositionException("Posicion nula");
			//Asumimos que si el elemento de la posicion es null, decimos que fue eliminado
			if(p.element() == null) throw new InvalidPositionException("La posicion fue eliminada previamente");
			
			return (DNode<E>) p;
		}catch(ClassCastException e) {
			throw new InvalidPositionException("p no es un nodo de lista doblemente enlazada");
		}
	}
	
	
}
