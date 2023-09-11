package queue;

import java.util.ArrayList;

public class Queue {
	public ArrayList<Object> queue = new ArrayList<Object>();
	public static String QueIsEmpty = "Queue is empty";
	private static final int FirstItemInQueue = 0;

  	public boolean isEmpty() {
        return queue.isEmpty();
	}

	public Queue add( Object  cargo ) {
		queue.add( cargo );
		return this;
	}

	public Object take() {
		  if (queue.isEmpty()) {
			  throw new Error(QueIsEmpty);
		  }
		  else {return queue.remove( FirstItemInQueue );

		  }
	}

	public Object head() {
		  if (queue.isEmpty()) {
		    throw new Error(QueIsEmpty);
		  }
		return queue.get( FirstItemInQueue );
	}

	public int size() {
		  return queue.size();
	}

}
