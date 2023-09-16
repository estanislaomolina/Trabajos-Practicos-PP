package queue;

import java.util.ArrayList;

public class Queue {
    private final ArrayList<Container> lista = new ArrayList<>();

    public Queue() {
        lista.add(new EmptyContainer());
    }

    public boolean isEmpty() {
        return lista.get(0).isEmpty();
    }

    public Queue add(Object cargo) {
        lista.add(lista.size() - 1, new NotEmptyContainer(cargo));
        return this;
    }

    public int size() {
        return lista.size() - 1;
    }

    public Object take() {
        return lista.remove(0).getObject(this);
    }

    public Object head() {
        return lista.get(0).getObject(this);

    }

}