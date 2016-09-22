package problem4;

import problem4.datastucture.CustomList;
import problem4.interfaces.Employee;
import problem4.models.Job;
import problem4.models.PartTimeEmployee;
import problem4.models.StandartEmployee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class Main {

    public static void main(String[] args) {

        CustomList<Job> customList = new CustomList<Job>();
        HashMap<String, Employee> employees = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                String input = reader.readLine();
                if ("End".equals(input)) {
                    break;
                }

                String[] params = input.split(" ");
                String command = params[0];
                String name = null;
                Employee newEmployee = null;
                switch (command) {
                    case "Job":
                        String nameOfTheJob = params[1];
                        int hoursRequired = Integer.parseInt(params[2]);
                        Employee currentEmployee = employees.get(params[3]);
                        Job currentJob = new Job(nameOfTheJob, hoursRequired, currentEmployee);
                        customList.add(currentJob);
                        currentJob.addJobCompletedListener(customList);
                        break;
                    case "StandartEmployee":
                        name = params[1];
                        newEmployee = new StandartEmployee(name);
                        employees.put(name, newEmployee);
                        break;
                    case "PartTimeEmployee":
                        name = params[1];
                        newEmployee = new PartTimeEmployee(name);
                        employees.put(name, newEmployee);
                        break;
                    case "Pass":
                        ArrayList<Job> jobs = new ArrayList<>(customList);
                        for (Job job : jobs) {
                            job.update();
                        }
                        break;
                    case "Status":
                        for (Job job : customList) {
                            System.out.println(job.toString());
                        }
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
