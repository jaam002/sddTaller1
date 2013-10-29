package source;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.Random;




class Student extends MyArray implements  Comparable<Student>, 
Orden<Student>
{
   private int code;
   private String name;

   public static final Comparator<Student> BY_NAME = new ByName( );
   public static final Comparator<Student> BY_NAME_REV = new ByNameRev( );
   public static final Comparator<Student> BY_CODE = new Bycode( );
   public static final Comparator<Student> BY_CODE_REV = new BycodeRev( );

   public Student( )
   {
      this( 0, "unknown" );
   }

   public Student( int c )
   {
      this( c, "unknown" );
   }

   public Student( int c, String n )
   {
      code = c; name = n;
   }

   public int getCode( )
   {
      return code;
   }

   public String getName( )
   {
      return name;
   }

   @Override
   public String toString( )
   {
      return "[" + code + ", " + name + "]";
   }

   @Override
   public boolean equals( Object o )
   {
      if( o == null ) return false;
      if( o == this ) return true;
      if( ! ( o instanceof Student ) ) return false;
      return this.code == ( ( Student ) o ).code;
   }

   @Override
   public int hashCode( )
   {
      return Objects.hash( code );
   }
   

   @Override
   public int compareTo( Student o )
   {
      return this.code - o.code;
   }
   
   
   private static class ByName implements Comparator<Student>{
      public int compare( Student a, Student b ) {
         return a.getName( ).compareTo( b.getName( ) );
      }
   }

   private static class ByNameRev implements Comparator<Student>{
      public int compare( Student a, Student b ) {
         return -1 * a.getName( ).compareTo( b.getName( ) );
      }
   }

   private static class Bycode implements Comparator<Student>{
      public int compare( Student a, Student b ) {
         return a.code - b.code;
      }
   }

   private static class BycodeRev implements Comparator<Student>{
      public int compare( Student a, Student b ) {
         return -1 * ( a.code - b.code );
      }
   }
   

   
   public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Random r = new Random( new Date( ).getTime( ) );
		MyArray<Student> x = new MyArray<Student>( );
		MyArray<Student> y = new MyArray<Student>( );
		
		 x.add( 0, new Student( r.nextInt( 999 ), "Ingrid" ) );
	     x.add( 1, new Student( 333, "Zenon" ) );
	     x.add( 2, new Student( r.nextInt( 999 ), "Mary" ) );
	     x.add( 3, new Student( r.nextInt( 999 ), "Aiden" ) );
		
	     System.out.println( "list is " + x );
	     x.sort( );
	     System.out.println( "by default " + x );
	     x.randomize(1,3);
	     System.out.println( "random " + x );
	     Student t= x.accumulate(x.get(0), x.get(1));
	     System.out.println( "acumular " + x );
	      //x.sort( Student.BY_NAME_REV );
	      //System.out.println( "by name rev " + x );
	      //x.sort( Student.BY_CODE );
	      //System.out.println( "by code " + x );
	      //x.sort( Student.BY_CODE_REV );
	      //System.out.println( "by code rev " + x );
	     //for( Student s : y ) System.out.println( s );
	     //System.out.println( y.indexOf( new Student( 333 ) ) );

	}

@Override
public void quicksort(Student[] items, int inicio, int fin) {
	// TODO Auto-generated method stub
	int i = inicio;
	int f = fin;
	Student pivote = items[inicio];
	do{
		while(items[i].compareTo(pivote) > 0){
			i++;
			}
		while(items[f].compareTo(pivote) < 0){
			f--;
			}
		if( i <= f){
			Student temp = items[i];
			items[i] = items[f];
			items[f] = temp;
			i++;
			f--;
		}
	}
	while( i <= f);
	if( inicio < f)
		quicksort(items, inicio, f);
	if( i < fin)
		quicksort(items, i, fin);
	
	
}

@Override
public void quicksort(Student[] items, int inicio, int fin, Comparator<Student> c) {
	// TODO Auto-generated method stub
	int i = inicio;
	int f = fin;
	Student pivote = items[inicio];
	do{
		while(items[i].compareTo(pivote) > 0){
			i++;
			}
		while(items[f].compareTo(pivote) < 0){
			f--;
			}
		if( i <= f){
			Student temp = items[i];
			items[i] = items[f];
			items[f] = temp;
			i++;
			f--;
		}
	}
	while( i <= f);
	if( inicio < f)
		quicksort(items, inicio, f,c);
	if( i < fin)
		quicksort(items, i, fin,c);
	
}

@Override
public void sort(int start, int end, Comparator<Student> c) {
	// TODO Auto-generated method stub
	//this.quicksort(this, start, end);
	
}

@Override
public void sort(int start, int end) {
	// TODO Auto-generated method stub
	
}
}


