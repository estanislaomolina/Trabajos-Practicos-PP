import java.util.ArrayList;

public class Queue {
	ArrayList<Object> lista = new ArrayList<Object>(); //creo una lista vacia de tipo object
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	public Queue add( Object  cargo ) {
		// TODO Auto-generated method stub
		lista.add(cargo);
		return this;
	}

	public Object take() {
    // TODO Auto-generated method stub
		return null;
	}

	public Object head() {
		// TODO Auto-generated method stub
    return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
