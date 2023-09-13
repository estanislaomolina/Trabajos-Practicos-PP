package queue;

public abstract class Container {
    public Object object;

    public abstract Object getObject(Object object);

    public abstract boolean isEmpty();
}
