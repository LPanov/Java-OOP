package ExamPreparation.furnitureFactory;

import ExamPreparation.furnitureFactory.core.Engine;
import ExamPreparation.furnitureFactory.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}