package InterfaceAndAbstractionExercises.CollectionHierarchy;

public class MyListImpl extends Collection implements MyList{
    @Override
    public String remove() {
        return getItems().removeFirst();
    }

    @Override
    public int add(String str) {
        getItems().addFirst(str);
        return getItems().indexOf(str);
    }

    @Override
    public int getUsed() {
        return getItems().size();
    }
}
