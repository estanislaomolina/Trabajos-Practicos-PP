package queue;

import java.util.ArrayList;

public class Queue {
	public static ArrayList<Object> lista = new ArrayList<Object>();
	public static String QueIsEmpty = "Queue is empty";
	//public static final int FirstItemInQueue = 0;

  	public boolean isEmpty() {
        return (lista.size() -1).isempty;
	}

	public Queue add( Object  cargo ) {
		lista.add( cargo );
		return this;
	}

	public Object take() {
		  if (lista.isEmpty()) {
			  throw new Error(QueIsEmpty);
		  }
		  else {return lista.remove( FirstItemInQueue );

		  }
	}

	public Object head() {
		  if (lista.isEmpty()) {
		    throw new Error(QueIsEmpty);
		  }
		return lista.get( FirstItemInQueue );
	}

	public int size() {
		  return lista.size();
	}

}
