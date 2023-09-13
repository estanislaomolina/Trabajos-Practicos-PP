package queue;

import static queue.Queue.FirstItemInQueue;

public class NotEmptyContainer extends Container {

        private Object object;
        public NotEmptyContainer(Object object) {
            this.object = object;
        }

        //public Object getObject(Queue queue){
          //  return this.object;
        //}

    @Override
    public Object getObject(Object object) {
        return this.object;
    }

    //@Override
    public boolean isEmpty() {
        return false;
    }

    //@Override
    //public Object take(Queue queue) {
      //  return Queue.removeElement();
    //}

    //@Override
    //public Object head(Queue queue) {
      //  return Queue.getElement(FirstItemInQueue);
    //}
}
