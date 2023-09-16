package queue;

import java.util.ArrayList;

public class Queue {
	private final ArrayList<Container> lista = new ArrayList<>();
	public static String EmptyQueueError = "Queue is empty";

	public Queue () {
		lista.add(new EmptyContainer());
	}

	public boolean isEmpty(){
		return lista.get(lista.size()-1).isEmpty();
		}

	public Queue add (Object cargo) {
		lista.add(1, new NotEmptyContainer(cargo));
		return this;
	}

	public int size() {
		return lista.size()-1;
	}
	public Object take() {
		return lista.remove(lista.size()-1).getObject(this);
	}

	public Object head() {
		return lista.get(lista.size()-1).getObject(this);

	}

}