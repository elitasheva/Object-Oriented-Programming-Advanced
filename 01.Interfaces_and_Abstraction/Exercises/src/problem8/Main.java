package problem8;

import problem8.models.*;
import problem8.utils.Mission;
import problem8.utils.Repair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            HashMap<String, Soldier> soldiers = new LinkedHashMap<>();

            while (true) {
                String input = reader.readLine();
                if ("End".equals(input)) {
                    break;
                }

                String[] params = input.split(" ");
                String type = params[0];
                String id = params[1];
                String firstName = params[2];
                String lastName = params[3];
                double salary = 0;
                String corps = null;
                Soldier soldier = null;

                switch (type) {
                    case "Private":
                        salary = Double.parseDouble(params[4]);
                        soldier = new Private(id, firstName, lastName, salary);
                        break;

                    case "LeutenantGeneral":
                        salary = Double.parseDouble(params[4]);
                        List<Soldier> privates = new ArrayList<>();
                        for (int i = 5; i < params.length; i++) {
                            privates.add(soldiers.get(params[i]));
                        }
                        soldier = new LeutenantGeneral(id, firstName, lastName, salary, privates);
                        break;

                    case "Engineer":
                        salary = Double.parseDouble(params[4]);
                        corps = params[5];

                        if (!corps.equals("Airforces") && !corps.equals("Marines")){
                            continue;
                        }

                        List<Repair> repairs = new ArrayList<>();
                        for (int i = 6; i < params.length - 1; i+=2) {
                            String partName = params[i];
                            int hours = Integer.parseInt(params[i+1]);
                            Repair repair = new Repair(partName,hours);
                            repairs.add(repair);
                        }
                        soldier = new Engineer(id, firstName, lastName, salary, corps, repairs);
                        break;

                    case "Commando":
                        salary = Double.parseDouble(params[4]);
                        corps = params[5];

                        if (!corps.equals("Airforces") && !corps.equals("Marines")){
                            continue;
                        }

                        List<Mission> missions = new ArrayList<>();
                        for (int i = 6; i < params.length - 1; i+=2) {
                            String codeName = params[i];
                            String state = params[i+1];

                            if (!state.equals("Finished") && !state.equals("inProgress")){
                                continue;
                            }

                            Mission mission = new Mission(codeName,state);
                            missions.add(mission);
                        }
                        soldier = new Commando(id, firstName, lastName, salary, corps, missions);
                        break;

                    case "Spy":
                        int codeNumber = Integer.parseInt(params[4]);
                        soldier = new Spy(id, firstName, lastName, codeNumber);
                        break;

                }
                soldiers.put(id, soldier);
            }

            for (Soldier soldier : soldiers.values()) {
                System.out.println(soldier.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
