package queue;

import static queue.Queue.FirstItemInQueue;

public class NotEmptyContainer extends Container {

        private Object cargo;
        public NotEmptyContainer(Object cargo) {
            this.cargo = cargo;
        }

        //public Object getObject(Queue queue){
          //  return this.object;
        //}

    @Override
    public Object getObject(Object cargo) {
        return this.cargo;
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
