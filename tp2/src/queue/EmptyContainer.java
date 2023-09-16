package queue;

public class EmptyContainer extends Container {

    private static String emptyQueueError = "Queue is empty";

    @Override
    public Object getObject(Object cargo) {
        throw new Error(emptyQueueError);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean isEmpty() {
        return true;
    }

}