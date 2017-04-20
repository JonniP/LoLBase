package lolbase;
import java.lang.reflect.Array;

/***
 * 
 * @author Valtteri Koskivuori 29.3.2017
 * A homebrew Generics "ArrayList" implementation
 *
 * @param <E> Any object
 */

public class GenericArray<E> {
	private E[] a;
	private int objCount;
	
	@SuppressWarnings("unchecked")
	public GenericArray(Class<E> c) {
		this.objCount = 0;
		final E[] arr = (E[]) Array.newInstance(c, 20);
		this.a = arr;
	}
	
	/***
	 * Removes element <index> from list
	 * @param index Index of element to remove
	 */
	public void delete(int index) {
		System.arraycopy(a, index + 1 , a, index, a.length - 1 - index);
	}
	
	/**
	 * adds element to list
	 * @param c list
	 * @param item element
	 */
	public void add(Class<E> c, E item) {
		if (this.objCount + 1 < a.length) {
			//Add it, will fit
			a[this.objCount] = item;
		} else {
			//Increase array size, then add
			increaseSizeOfArray(c);
			a[this.objCount] = item;
		}
		this.objCount++;
	}
	/**
	 * clears the list
	 */
	public void clear() {
		@SuppressWarnings("unchecked")
		E[] emptyArr = (E[]) Array.newInstance(a.getClass(), 0);
		this.a = emptyArr;
	}
	
	//This will double the size of the array, consider just adding X new elements
	/**
	 * increases the size of array when it fills
	 * @param c array
	 */
	private void increaseSizeOfArray(Class<E> c) {
		@SuppressWarnings("unchecked")
		E[] newArr = (E[]) Array.newInstance(c, this.objCount * 2);
		//Now copy old objects and set
		for (int i = 0; i < this.a.length; i++) {
			newArr[i] = this.a[i];
		}
		this.a = newArr;
	}

	/**
	 * gives the size of aarray
	 * @return size
	 */
	public int size() {
		return this.objCount;
	}

	/**
	 * returns an element from array
	 * @param i index of element
	 * @return element
	 */
	public E get(int i) {
		return this.a[i];
	}

	/**
	 * converts list to array
	 * @param c list
	 * @return array
	 */
	public E[] toArray(Class<E> c) {
		@SuppressWarnings("unchecked")
		E[] newArr = (E[]) Array.newInstance(c, this.objCount);
		for (int i = 0; i < this.objCount; i++) {
			newArr[i] = a[i];
		}
		return newArr;
	}
	
		
}
