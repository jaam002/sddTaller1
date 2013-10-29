package source;

import java.util.Comparator;

public interface Orden<T> {
	
	public void quicksort(T[] e, int start, int end);
	public void quicksort(T[] e, int start, int end, Comparator<T> c);
	public void sort(int start, int end);
	public void sort(int start, int end, Comparator<T> c); 
	
}
