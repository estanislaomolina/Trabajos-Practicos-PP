package queue;
public class EmptyQueue extends QueueState {

    @Override
    public boolean isEmpty() {
        return true;
    }


    @Override
    public Object head(Queue queue) {
        throw new Error(Queue.QueIsEmpty);
    }

    @Override
    public Object take(Queue queue) {

        throw new Error(Queue.QueIsEmpty);
    }
}
