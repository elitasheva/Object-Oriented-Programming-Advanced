package problem8;

import problem8.models.Clinic;
import problem8.models.Pet;
import problem8.models.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    private static HashMap<String, Pet> petsByName = new LinkedHashMap<>();
    private static HashMap<String, Clinic> clinicsByName = new LinkedHashMap<>();

    public static void main(String[] args) {

        //TODO check the last test it is not correct????
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int countOfCommands = Integer.parseInt(reader.readLine());
            for (int i = 0; i < countOfCommands; i++) {

                String[] params = reader.readLine().split(" ");
                String command = params[0];

                try {
                    switch (command) {
                        case "Create":
                            executeCreateCommand(params);
                            break;
                        case "Add":
                            System.out.println(executeAddCommand(params));
                            break;
                        case "Release":
                            System.out.println(executeReleaseCommand(params));
                            break;
                        case "HasEmptyRooms":
                            System.out.println(executeHasEmptyRooms(params));
                            break;
                        case "Print":
                            executePrintCommand(params);
                            break;
                        default:
                            System.out.println("Invalid Operation!");
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println("Invalid Operation!");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean executeHasEmptyRooms(String[] params) {
        if (params.length != 2) {
            throw new IllegalArgumentException();
        }

        String clinicName = params[1];
        if (!clinicsByName.containsKey(clinicName)) {
            throw new IllegalArgumentException();
        }

        Clinic currentClinic = clinicsByName.get(clinicName);

        return currentClinic.hasEmptyRoomsInClinic();
    }

    private static void executePrintCommand(String[] params) {

        String clinicName = params[1];
        Clinic currentClinic = clinicsByName.get(clinicName);

        if (params.length == 2) {
            for (Room room : currentClinic.getRooms()) {
                System.out.println(room.toString());
            }
        }
        if (params.length == 3) {
            int index = Integer.parseInt(params[2]) - 1;
            Room currentRoom = currentClinic.getRooms().get(index);
            System.out.println(currentRoom.toString());
        }
    }

    private static boolean executeReleaseCommand(String[] params) {

        if (params.length != 2) {
            throw new IllegalArgumentException();
        }

        String clinicName = params[1];
        if (!clinicsByName.containsKey(clinicName)) {
            return false;
        }

        Clinic currentClinic = clinicsByName.get(clinicName);

        return currentClinic.releasePetFromClinic();
    }

    private static boolean executeAddCommand(String[] params) {
        if (params.length != 3) {
            throw new IllegalArgumentException();
        }

        String petName = params[1];
        String clinicName = params[2];

        if (!petsByName.containsKey(petName)) {
            return false;
        }
        if (!clinicsByName.containsKey(clinicName)) {
            return false;
        }

        Clinic currentClinic = clinicsByName.get(clinicName);
        Pet currentPet = petsByName.get(petName);

        return currentClinic.addPetToClinic(currentPet);
    }

    private static void executeCreateCommand(String[] params) {
        String type = params[1];

        if (!"Pet".equals(type) && !"Clinic".equals(type)) {
            throw new IllegalArgumentException();
        }

        if ("Pet".equals(type)) {

            if (params.length != 5) {
                throw new IllegalArgumentException();
            }
            if (petsByName.containsKey(params[2])) {
                throw new IllegalArgumentException();
            }
            Pet pet = new Pet(params[2], Integer.parseInt(params[3]), params[4]);
            petsByName.put(params[2], pet);

        }

        if ("Clinic".equals(type)) {
            if (params.length != 4) {
                throw new IllegalArgumentException();
            }

            if (clinicsByName.containsKey(params[2])) {
                throw new IllegalArgumentException();
            }

            Clinic clinic = new Clinic(params[2], Integer.parseInt(params[3]));
            clinicsByName.put(params[2], clinic);

        }
    }
}
