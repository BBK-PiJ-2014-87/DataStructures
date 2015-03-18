package linkedlist;

/**
 * Implementation of circularly linked list.
 *
 * @param <E>
 */
public class CircularlyLinkedList<E> {
	/**
	 * Nested Node class. Having a Node as a nested class
	 * provides strong encapsulation and hides information from users
	 * about nodes and links implementation.
	 */
	private static class Node<E>{
		private E element;			//reference to this node's element
		private Node<E> next; 		//reference to the next element
		
		//START of methods of nested class Node
		public Node(E elem, Node<E> node){
			element = elem;
			next = node;
		}
		
		public E getElement(){
			return element;
		}
		
		public Node<E> getNextNode(){
			return next;
		}
		
		public void setNextNode(Node<E> node){
			next = node;
		}
		//FINISH of methods of nested class Node
	}
	
	//Instance variables of CircularlyLinkedList class
	private Node<E> tail = null;	//tail node of the list (helper)
	private int size = 0;			//amount of nodes in the list
	public CircularlyLinkedList(){
	}
	
	//Access methods
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;				//if size is 0 return true
	}
	
	public E getLast(){
		if(isEmpty()) return null;
		return tail.getElement();
	}
	
	//Mutators
	
	/**
	 * Rotates the list on 1 element by just changing tail pointer
	 * to the next element.
	 */
	public void rotate(){
		if(size != 0)
			tail = tail.getNextNode();
	}
	
	/**
	 * Inserts element in the start of the list.
	 * @param elem
	 */
	public void insertFirst(E elem){
		if(size == 0){
			tail = new Node<>(elem, null);
			tail.setNextNode(tail);				//point to itself
		}else{
			Node<E> newest = new Node<>(elem, tail.getNextNode());
			tail.setNextNode(newest);
		}
		size++;
	}
	
	/**
	 * Inserts element in the end of the list.
	 * @param elem
	 */
	public void insertLast(E elem){
		insertFirst(elem);
		tail = tail.getNextNode();					//rotates list
		size++;
	}
	
	/**
	 * Removes and returns the first element of the list
	 * @return
	 */
	public E removeFirst(){
		if(isEmpty()) return null;
		Node<E> head = tail.getNextNode();			//creates a local helper "head"
		if (head == tail){
			tail = null;							//removes the only element
		}else{
			tail.setNextNode(head.getNextNode());	//removes first element
		}
		size--;
		return head.getElement();
	}
}
