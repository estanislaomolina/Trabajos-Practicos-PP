package queue;
public abstract class QueueState {
    public abstract boolean isEmpty();
    public abstract Object head(Queue queue);
    public abstract Object take(Queue queue);
}
