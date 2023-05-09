package TDALista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ElementIterator<E> implements Iterator<E>{
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	public ElementIterator(PositionList<E> l) {
		list = l;
		try {
			if(list.isEmpty()) cursor=null;
			else cursor = list.first();
		}catch(EmptyListException e) {
			e.printStackTrace();
		}
	}
	
	public E next() throws NoSuchElementException {
		if(cursor == null) throw new NoSuchElementException("No hay siguiente");
		
		E toReturn = cursor.element();
		try {
			cursor = (cursor == list.last())?null:list.next(cursor);
		}catch(EmptyListException |BoundaryViolationException| InvalidPositionException  e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	public boolean hasNext() {
		return cursor != null;
	}
}
