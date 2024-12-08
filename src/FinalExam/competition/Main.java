package FinalExam.competition;

import FinalExam.competition.core.Controller;
import FinalExam.competition.core.ControllerImpl;
import FinalExam.competition.core.Engine;
import FinalExam.competition.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}