package TDALista;

public class DNode<E> implements Position<E> {

	private DNode<E>previous, next;
	private E element;
	
	/**
	 * 
	 * @param e El elemento
	 * @param n El nodo siguiente
	 * @param p El nodo previo
	 */
	public DNode(E e, DNode<E> n,DNode<E> p) {
		setNext(n);
		setPrev(p);
		element = e;
	}
	public DNode(E e) {
		this(e,null,null);
	}
	
	public E element() {
		return element;
	}
	
	public void setElement(E e) {
		element = e;
	}
	public DNode<E> getPrev() {
		return previous;
	}
	public void setPrev(DNode<E> previous) {
		this.previous = previous;
	}
	public DNode<E> getNext() {
		return next;
	}
	public void setNext(DNode<E> next) {
		this.next = next;
	}
	
	
	
	
}
