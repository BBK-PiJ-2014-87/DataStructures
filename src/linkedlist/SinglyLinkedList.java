package linkedlist;
/**
 * Implementation of linked list using generics.
 *
 * @param <E>
 */
public class SinglyLinkedList<E> {
	/**
	 * Nested Node class. Having a Node as a nested class
	 * provides strong encapsulaton and hides information from users
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
		//FINISH of methods of nestes class Node
	}
	
	//Instance variables of SinglyLinkedList class
	private Node<E> head = null;	//head node of the list
	private Node<E> tail = null;	//tail node of the list (helper)
	private int size = 0;			//amount of nodes in the list
	public SinglyLinkedList(){
	}
	
	//Access methods
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;				//if size is 0 return true
	}
	
	public E getFirst(){
		if(isEmpty()) return null;
		return head.getElement();
	}
	
	public E getLast(){
		if(isEmpty()) return null;
		return tail.getElement();
	}
	
	//Mutators
	
	public void insertFirst(E elem){
		head = new Node<>(elem, head);	//add node to the front of the list
		if (size == 0){					
			tail = head;				
		}								
		size++;
	}
	
	public void insertLast(E elem){
		Node<E> newNode = new Node<>(elem, null);
		if (isEmpty()){
			head = newNode;
		}else{
			tail.setNextNode(newNode);
		}
		tail = newNode;
		size++;
	}
	/**
	 * Removes and returns the first element of the list
	 * @return
	 */
	public E removeFirst(){
		if(isEmpty()) return null;
		E answer = head.getElement();
		head = head.getNextNode();
		size--;
		if(size ==0){
			tail = null;
		}
		return answer;
	}

}
