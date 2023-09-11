package queue;
public class NotEmptyQueue extends QueueState {

    public Object object;

    public NotEmptyQueue(Object object) {
        this.object = object;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object head(Queue queue) {
        return queue.
    }

    @Override
    public Object take(Queue queue){
		  return Queue.queue.remove( FirstItemInQueue );
    }
}
