package queue;

public class NotEmptyContainer extends Container {
    private final Object cargo;
    public NotEmptyContainer(Object cargo) {
            this.cargo = cargo;
        }

    @Override
    public Object getObject(Object cargo) {
        return this.cargo;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
