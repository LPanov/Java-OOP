package InterfaceAndAbstractionLab.CarShopExtended;

class CarImpl implements Car{
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

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

    public CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }
}
