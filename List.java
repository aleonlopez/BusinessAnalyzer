/**
 * List interface
 * @author Alex Leon
 *
 * @param <T>
 */

public interface List <T> {
	public T get (int pos);
	public boolean add (T item);
	public void add (int pos, T item);
	public T remove (int pos);
	int size();
	public Iterator<T> iterator();
}