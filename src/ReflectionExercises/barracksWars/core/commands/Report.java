package ReflectionExercises.barracksWars.core.commands;

import ReflectionExercises.barracksWars.annotations.Inject;
import ReflectionExercises.barracksWars.interfaces.Executable;
import ReflectionExercises.barracksWars.interfaces.Repository;
import ReflectionExercises.barracksWars.interfaces.UnitFactory;

public class Report implements Executable {
    @Inject
    private Repository repository;

    public Report() {}
    public Report(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String execute() {
        String output = this.repository.getStatistics();
        return output;
    }
}
