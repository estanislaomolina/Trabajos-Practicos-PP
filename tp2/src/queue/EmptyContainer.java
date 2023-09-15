package queue;

public class EmptyContainer extends Container {

    @Override
    public Object getObject(Object cargo) {
        throw new Error(Queue.EmptyQueueError);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean isEmpty() {
        return true;
    }

}



