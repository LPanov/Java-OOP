package PolymorphismExercises.Calculator;

public class Extensions {
    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        InputInterpreter interpreter = new InputInterpreter(engine);
        return interpreter;
    }
}
