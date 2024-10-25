package InterfaceAndAbstractionLab.SayHelloExtended;

public interface Person {
    public String getName();
    public default String sayHello() {
        return "Hello";
    };
}
