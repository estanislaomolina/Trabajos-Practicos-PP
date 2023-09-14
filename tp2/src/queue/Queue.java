package queue;

import java.util.ArrayList;

public class Queue {
	private static final ArrayList<Container> lista = new ArrayList<>();
	public static String EmptyQueueError = "Queue is empty";
	static final int FirstItemInQueue = 0;

	public Queue() {
		lista.add(new EmptyContainer());
	}

	public static Container removeElement() {
		return lista.remove(FirstItemInQueue);
	}

	public boolean isEmpty(){
		return getElement(lista.size()-1).isEmpty();
		}

	public Queue add (Object cargo) {
		//lista.add(size(), new NotEmptyContainer(cargo));
		lista.add(new NotEmptyContainer(cargo));
		return this;
	}

	public Object take() {
		//return lista.getObject(this)
		return (lista.remove(lista.size()-1).getObject(this));
		//return (lista.remove(getElement(lista.size()-1)).getObject(this);
		//return getElement(lista.size()-1).getObject(this);
		//TODO creo que el take no anda bien
		//return removeElement().getObject(this);

	}

	public Object head() {
		//return lista.get(getElement.size()-1).getObject(this);
		//return getElement(lista.size()-1).getObject(this);
		//return lista.get(FirstItemInQueue).getObject(this);
		//return lista.peek();
	}

	public int size() {
		  return lista.size() -1;
	}
	static Container getElement(int QueuePosition) {
		return lista.get(QueuePosition);
	}
}