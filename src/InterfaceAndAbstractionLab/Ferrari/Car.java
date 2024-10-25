package InterfaceAndAbstractionLab.Ferrari;

public interface Car {
    public default String brakes(){
     return "Brakes!";
    }

    public default String gas() {
        return "brum-brum-brum-brrrrr";
    }
}
