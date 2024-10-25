package InterfaceAndAbstractionLab.CarShop;

public class Seat implements Car {
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String getCountryProduces() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        return "This is "+getModel()+" produced in "+getCountryProduces()+" and have "+TIRES+" tires";
    }
}
