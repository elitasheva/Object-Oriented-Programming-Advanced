package problem8.models;

import problem8.interaces.ILeutenantGeneral;

import java.util.List;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {

    private List<Soldier> soldiers;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary, List<Soldier> soldiers) {
        super(id, firstName, lastName, salary);
        this.soldiers = soldiers;
    }

    @Override
    public List<Soldier> getSoldiers() {
        return this.soldiers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Privates:");
        if (soldiers.size() > 0) {
            sb.append(System.lineSeparator());
            for (Soldier soldier : soldiers) {
                sb.append("  " + soldier.toString()).append(System.lineSeparator());
            }
        }

        return super.toString() + System.lineSeparator() + sb.toString().trim();
    }
}
