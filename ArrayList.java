/**
 * Created custom ArrayList class which implements the List interface.
 * A private ArrayList iterator was created as a nested class which
 * implements the Iterator interface.
 * @author Alex Leon
 *
 * @param <T>
 */

public class ArrayList <T> implements List <T> {
	int size;
	T[] arr;
	
	private class AListIterator<T> implements Iterator<T> {

		private int nextIndex = 0;
		
		public boolean hasNext () {
			return nextIndex < size && nextIndex >= 0;
		}
		
		public T next() {
			return (T) arr[nextIndex++];
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new AListIterator<T>();
	}
	
	public ArrayList () {
		arr = (T[]) new Object[10]; // Will generate a warning
		size = 0;
	}
	@Override
	public T get(int pos) {
		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		return arr[pos];
	}

	@Override
	public boolean add(T item) {
		if (size == arr. length) {
			grow_array();
		}
		arr[size++] = item;
		return true;
	}

	@Override
	public void add(int pos, T item) {
		for (int i = size; i > pos; i--) {
			arr[i] = arr[i- 1];
			arr[pos] = item;
			++size;
		}
	}

	@Override
	public T remove(int pos) {
		if (pos < 0 || pos >= 0) {
			throw new IndexOutOfBoundsException();
		}
		T temp = arr[pos];
		if (pos == size -1) {
			arr[pos] = null;
			size--;
			return temp;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		size--;
		return temp;
	}

	@Override
	public int size() {
		return size();
	}
	
	private void grow_array() {
		T [] new_arr = (T[]) new Object[arr. length * 2];
		for (int i = 0; i < arr. length; i++)
		new_arr[i] = arr[i];
		arr = new_arr;
	}
}