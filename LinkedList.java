/**
 * Created custom LinkedList class which implements the List interface.
 * A private LinkedList iterator was created as a nested class which
 * implements the Iterator interface.
 * @author alexleon
 *
 * @param <T>
 */

public class LinkedList <T> implements List <T> {
	
	private class Node<T> {
		// Attributes could be public or private since it's in the LL
		T data;
		Node<T> next;
		
		public Node(T value) {
			data = value;
			next = null;
		}
	}
	
	Node<T> head;
	int size;
	
	LinkedList() {
		head = null;
		size = 0;
	}

	private class LListIterator<T> implements Iterator<T> {

		private Node<T> node = (Node<T>) head;
		
		public boolean hasNext () {
			return node.next != null;
		}
		
		public T next () { // Return data and advance
			Node<T> prev = node;
			node = node.next;
			return prev.data;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new LListIterator<T>();
	}	
	@Override
	public T get(int pos) {
		if (head == null || pos <= 0 || pos >= size ) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> curr = head;
		for (int i = 0; i < pos; i++) {
			curr = curr.next;
		}
		return curr.data;
	}

	@Override
	public boolean add(T item) {
		if (head == null) {
			head = new Node<T>(item);
			++size;
			return true;
		}
		Node<T> node = new Node<T>(item);
		node.next = head;
		head = node;
		++size;
		return true;
	}

	@Override
	public void add(int pos, T item) {
		if (pos < 0|| pos > size) {
			throw new IndexOutOfBoundsException();
		}
		if (pos == 0) {
			Node<T> node = new Node<T>(item);
			node.next = head;
			head = node;
			++size;
		} else {
			Node<T> curr = head;
			for (int i = 0; i < pos - 1; i++) {
				curr = curr.next;
			}
			Node<T> node = new Node<T>(item);
			node.next = curr.next;
			curr.next = node;
			++size;
		}
	}

	@Override
	public T remove(int pos) {
		if (pos < 0|| pos >= size) {
			throw new IndexOutOfBoundsException();
		} 
		if (pos == 0) {
			Node<T> node = head;
			head = head.next;
			--size;
			return node.data;
		} else {
			Node<T> curr = head;
			for (int i = 0; i < pos - 1; i++) {
				curr = curr.next;
			}
			Node<T> node = curr.next;
			curr.next = node.next;
			--size;
			return node.data;
		} 
	}

	@Override
	public int size() {
		return size;
	}
}