package InterfaceAndAbstractionLab.SayHelloExtended;

abstract class BasePerson implements Person{
    private String name;

    protected BasePerson(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return Person.super.sayHello();
    }

    private void setName(String name) {
        if (name.isEmpty() || !name.matches("\\S+")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }
}
