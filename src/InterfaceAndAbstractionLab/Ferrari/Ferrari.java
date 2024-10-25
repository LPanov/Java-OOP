package InterfaceAndAbstractionLab.Ferrari;

public class Ferrari implements Car{
    private String driverName;
    private static final String MODEL = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return Car.super.brakes();
    }

    @Override
    public String gas() {
        return Car.super.gas();
    }

    @Override
    public String toString() {
        return MODEL+"/"+brakes()+"/"+gas()+"/"+ this.driverName;
    }
}
