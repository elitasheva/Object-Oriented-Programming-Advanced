package problem8.models;

import problem8.interaces.ICommando;
import problem8.utils.Mission;
import problem8.utils.Repair;

import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {

    private List<Mission> missions;

    public Commando(String id,
                    String firstName,
                    String lastName,
                    double salary,
                    String corps,
                    List<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions = missions;
    }

    @Override
    public List<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Missions:");
        if (missions.size() > 0) {
            sb.append(System.lineSeparator());
            for (Mission mission : missions) {
                sb.append("  " + mission.toString()).append(System.lineSeparator());
            }
        }

        return super.toString() + System.lineSeparator() + sb.toString().trim();
    }
}
