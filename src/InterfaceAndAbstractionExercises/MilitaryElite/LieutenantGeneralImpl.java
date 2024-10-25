package InterfaceAndAbstractionExercises.MilitaryElite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral{
    private List<PrivateImpl> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(PrivateImpl priv) {
        privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Name: ").append(getFirstName()).append(" ").append(getLastName()).append(" Id: ").append(getId()).append(" Salary: ").append(String.format("%.2f", getSalary())).append("\n");
        str.append("Privates:");
        if (!privates.isEmpty()) privates.stream()
                .sorted((a, b) ->  b.getId() - a.getId())
                .forEach(priv -> str.append("\n").append(priv.toString()));

        return str.toString();
    }
}
