package InterfaceAndAbstractionExercises.CollectionHierarchy;

public class AddCollection extends Collection implements Addable{

    @Override
    public int add(String str) {
        getItems().addLast(str);
        return getItems().indexOf(str);
    }
}
