package queue;

public class EmptyContainer extends Container {

    //public Object getObject(Queue queue){
      //throw new Error (Queue.EmptyQueueError);
    ///}

    @Override
    public Object getObject(Object cargo) {
        throw new Error (Queue.EmptyQueueError);
    }

    public boolean isEmpty() {
        return true;
    }

    public Object take(Queue queue) {
        throw new Error (Queue.EmptyQueueError);
    }

    public Object head(Queue queue) {
        throw new Error (Queue.EmptyQueueError);
    }
}
