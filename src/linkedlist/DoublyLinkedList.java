package linkedlist;

/**
 * Implementation of doubly list using generic types.
 *
 * @param <E>
 */
public class DoublyLinkedList<E> {
	//---NESTED NODE CLASS START---//
	private static class Node<E> {
		private E element; // reference to this node's element
		private Node<E> next; // reference to the next element
		private Node<E> prev; // reference to the previous element
		public Node(E elem, Node<E> prev, Node<E> next) {
			element = elem;
			this.prev = prev;
			this.next = next;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNextNode() {
			return next;
		}

		public Node<E> getPrevNode() {
			return prev;
		}

		public void setNextNode(Node<E> node) {
			next = node;
		}

		public void setPreviousNode(Node<E> node) {
			prev = node;
		}
	}
	//---NESTED NODE CLASS FINISH---//

	// Instance variables of SinglyLinkedList class
	private Node<E> header = null; 			// sentinel in the head of the list
	private Node<E> trailer = null; 		// sentinel in the start of the list
	private int size = 0; 					// amount of nodes in the list

	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNextNode(trailer);
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0; // if size is 0 return true
	}

	public E getFirst() {
		if (isEmpty())
			return null;
		return header.getNextNode().getElement();
	}

	public E getLast() {
		if (isEmpty())
			return null;
		return trailer.getPrevNode().getElement();
	}

	//Mutators
	
	public void insertFirst(E elem) {
		addBetween(elem, header, header.getNextNode());
	}

	public void insertLast(E elem) {
		addBetween(elem, trailer.getPrevNode(), trailer);
	}
	
	public E removeFirst() {
		if (isEmpty()) return null;
		return remove(header.getNextNode());
	}

	public E removeLast() {
		if (isEmpty()) return null;
		return remove(trailer.getPrevNode());
	}
	
	//Private methods
	
	private void addBetween(E elem, Node<E> predecessor, Node<E> successor){
		Node<E> newest = new Node<>(elem, predecessor, successor);
		predecessor.setNextNode(newest);
		successor.setPreviousNode(newest);
		size++;
	}
	
	private E remove(Node<E> node){
		Node<E> predecessor = node.getPrevNode();
		Node<E> successor = node.getNextNode();
		predecessor.setNextNode(successor);
		successor.setPreviousNode(predecessor);
		size--;
		return node.getElement();
	}
}
