package DebuggingTechniques.aquarium;

import DebuggingTechniques.aquarium.core.Engine;
import DebuggingTechniques.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
