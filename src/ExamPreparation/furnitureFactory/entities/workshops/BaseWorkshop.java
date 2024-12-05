package ExamPreparation.furnitureFactory.entities.workshops;

import ExamPreparation.furnitureFactory.entities.wood.Wood;

public abstract class BaseWorkshop implements Workshop{
    private int woodQuantity;
    private int producedFurnitureCount;
    private int woodQuantityReduceFactor;

    public BaseWorkshop(int woodQuantity, int woodQuantityReduceFactor) {
        this.woodQuantity = woodQuantity;
        this.producedFurnitureCount = 0;
        this.woodQuantityReduceFactor = woodQuantityReduceFactor;
    }

    @Override
    public int getWoodQuantity() {
        return woodQuantity;
    }

    @Override
    public int getProducedFurnitureCount() {
        return producedFurnitureCount;
    }

    @Override
    public int getWoodQuantityReduceFactor() {
        return woodQuantityReduceFactor;
    }

    @Override
    public void addWood(Wood wood) {
        this.woodQuantity += wood.getWoodQuantity();
    }

    @Override
    public void produce() {
        if (this.woodQuantity < 0) {
            this.woodQuantity = 0;
        }
        if (woodQuantity > 0) {
            this.woodQuantity -= this.woodQuantityReduceFactor;
            this.producedFurnitureCount++;
        }
    }
}
