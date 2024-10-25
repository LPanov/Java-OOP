package InterfaceAndAbstractionExercises.MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando{
    List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return missions;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Name: ").append(getFirstName()).append(" ").append(getLastName()).append(" Id: ").append(getId()).append(" Salary: ").append(String.format("%.2f", getSalary())).append("\n");
        str.append("Corps: ").append(getCorps()).append("\n");
        str.append("Missions:");
        if (!missions.isEmpty()) missions
                .forEach(mission -> str.append("\n").append(mission.toString()));

        return str.toString();
    }
}
