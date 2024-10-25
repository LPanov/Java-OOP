package InterfaceAndAbstractionExercises.MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer{
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return repairs;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Name: ").append(getFirstName()).append(" ").append(getLastName()).append(" Id: ").append(getId()).append(" Salary: ").append(String.format("%.2f", getSalary())).append("\n");
        str.append("Corps: ").append(getCorps()).append("\n");
        str.append("Repairs:");
        if (!repairs.isEmpty()) repairs
                .forEach(repair -> str.append("\n").append(repair.toString()));

        return str.toString();
    }
}
