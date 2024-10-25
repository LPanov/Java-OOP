package InterfaceAndAbstractionExercises.CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable{

    @Override
    public String remove() {
        return getItems().removeLast();
    }

    @Override
    public int add(String str) {
        getItems().addFirst(str);
        return getItems().indexOf(str);
    }
}
