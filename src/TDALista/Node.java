package TDALista;

public class Node<E> implements Position<E>{
	private E element;
	private Node<E> next;

	//Constructores
	public Node(E e, Node<E> n){
		element = e;
		next = n;
	}
	public Node(E e) {
		this(e, null);
	}

	//Metodos
	public Node<E> getNext(){
		return next;
	}
	public void setNext(Node<E> n){
		next = n;
	}
	public E element() {
		return element;
	}
	public void setElement(E e) {
		element = e;
	}
}
