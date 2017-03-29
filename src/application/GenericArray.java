package application;
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
	
	public void add(E item) {
		if (this.objCount < a.length) {
			//Add it, will fit
			a[this.objCount] = item;
		} else {
			//Increase array size, then add
			increaseSizeOfArray(a);
			a[this.objCount] = item;
		}
		this.objCount++;
	}
	
	public void clear() {
		@SuppressWarnings("unchecked")
		E[] emptyArr = (E[]) Array.newInstance(a.getClass(), 0);
		this.a = emptyArr;
	}
	
	//This will double the size of the array, consider just adding X new elements
	private void increaseSizeOfArray(E[] array) {
		@SuppressWarnings("unchecked")
		E[] newArr = (E[]) Array.newInstance(a.getClass(), objCount * 2);
		//Now copy old objects and set
		for (int i = 0; i < a.length; i++) {
			newArr[i] = a[i];
		}
		this.a = newArr;
	}

	public int size() {
		return this.objCount;
	}

	public E get(int i) {
		return this.a[i];
	}

	public E[] toArray() {
		@SuppressWarnings("unchecked")
		E[] newArr = (E[]) Array.newInstance(a.getClass(), objCount);
		for (int i = 0; i < a.length; i++) {
			newArr[i] = a[i];
		}
		return newArr;
	}
}
