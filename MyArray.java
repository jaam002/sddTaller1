package source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class MyArray<T> extends ArrayLinearList<T> implements Accumulable<T>{

	/**
	 * @param args
	 */
	
	  protected T[] element;  // array of elements
	   protected int size;   // number of elements in array

	   // constructors
	   /** create a list with initial capacity initialCapacity
	    * @throws IllegalArgumentException when
	    * initialCapacity < 1 */
	   @SuppressWarnings( "unchecked" )
	   public MyArray(int initialCapacity)
	   {
	      if( initialCapacity < 1 )
	         throw new IllegalArgumentException
	            ( "initialCapacity must be >= 1" );
	      element = ( T[] ) new Object[ initialCapacity ];
	      size = 0;
	   }

	   /** create a list with initial capacity 10 */
	   public MyArray( )
	   {
	      this( 10 );
	   }

	   
	   public void sort( )
	   {
	      Arrays.sort( element, 0, size );
	      int j,i = 0;
	      j = (int) Math.floor(Math.random() * (i + 1));
	   }
	   
	   public void sort( Comparator<T> c )
	   {
	      Arrays.sort( element, 0, size, c );
	   }

	  public void randomize(int start, int end){
		   double j;
		   T temp;
		   for(int i = end; i >= start; i--){
		     j = Math.floor(Math.random() * (i + 1));
		     temp = this.get(i);
		     this.add(i,this.get((int)j));
		     this.remove(i+1);
		     this.remove((int)j);
		     this.add((int) j, temp);
		   }
		   
		 }
	  
	  public T fold()
		{
			T nuevo = null;

			for( int i = 0; i < this.size(); ++ i )
				nuevo = (T) accumulate(nuevo, this.get(i));

			return nuevo;
		}

	@Override
	public T accumulate(T i, T j) {
		// TODO Auto-generated method stub
		return (T) i.toString().concat((String) j);
	}

	   
	   /*public void sort(int start, int end){
		   
		   this.quicksort(element, start, end);
	   }
	   
	   public void sort(int start, int end, Comparator<T> c){
		   
		   this.quicksort(element, start, end, c);
	   }*/
	   


}
