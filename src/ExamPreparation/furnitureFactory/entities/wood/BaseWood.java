package ExamPreparation.furnitureFactory.entities.wood;

public abstract class BaseWood implements Wood{
    private final int woodQuantity;

    public BaseWood(int woodQuantity) {
        this.woodQuantity = woodQuantity;
    }

    @Override
    public int getWoodQuantity() {
        return this.woodQuantity;
    }
}
