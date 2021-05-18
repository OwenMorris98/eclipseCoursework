/*
 * @author Owen Morris
 * 
 * Class that creates a list array to store and point at objects
 * 
 * 
 */
public class ListArray<E> {
	private E[] list;
	private int size;

	public ListArray() {
		super();
		list = (E[]) new Part[14];
		size = 0;
	}

	public ListArray(int capacity) {
		super();
		list = (E[]) new Part[capacity];
		size = 0;
	}

	public int size() {
		return size;
	}

	/*
	 * Add an item to the end of the list.
	 * 
	 * @param item element to be added
	 */
	public void add(E item) {
		if (size > list.length) // array is full
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		list[size] = item;
		size++;
	}

	public int indexOf(E target) {
		int found = 0;
		return found;
	}

	/*
	 * Returns element at specified position
	 * 
	 * @param index position of element to return
	 * 
	 * @return element at position index
	 */
	public E get(int index) {
		return list[index];
	}

	/*
	 * Remove an item at the specified index in the list.
	 * 
	 * @param index position in list at which to remove item
	 * 
	 */
	public void remove(int index) {

		for (int i = index + 1; i <= size; i++) {

			list[i] = list[i - 1];
		}

		size--;
	}
}
