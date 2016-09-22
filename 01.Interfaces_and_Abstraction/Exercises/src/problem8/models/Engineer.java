package problem8.models;

import problem8.interaces.IEngineer;
import problem8.utils.Repair;

import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {

    private List<Repair> repairs;

    public Engineer(String id,
                    String firstName,
                    String lastName,
                    double salary,
                    String corps,
                    List<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = repairs;
    }

    @Override
    public List<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Repairs:");
        if (repairs.size() > 0) {
            sb.append(System.lineSeparator());
            for (Repair repair : repairs) {
                sb.append("  " + repair.toString()).append(System.lineSeparator());
            }
        }

        return super.toString() + System.lineSeparator() + sb.toString().trim();
    }
}
