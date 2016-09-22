package problem7.models;

import problem7.interfaces.CommandInterpreter;
import problem7.interfaces.Sorter;


public class CommandInterpeterImpl implements CommandInterpreter{

    private CustomListImpl list;
    private Sorter sorter;

    public CommandInterpeterImpl(CustomListImpl list, Sorter sorter) {
        this.sorter = sorter;
        this.list = list;
    }

    @Override
    public void interpreteCommand(String commandStr) {

        String[] params = commandStr.split(" ");
        String command = params[0];
        String element = null;
        switch (command){

            case "Add":
                element = params[1];
                this.list.add(element);
                break;

            case "Remove":
                int index = Integer.parseInt(params[1]);
                this.list.remove(index);
                break;

            case "Contains":
                element = params[1];
                System.out.println(this.list.contains(element));
                break;

            case "Swap":
                int index1 = Integer.parseInt(params[1]);
                int index2 = Integer.parseInt(params[2]);
                this.list.swap(index1,index2);
                break;

            case "Greater":
                element = params[1];
                System.out.println(this.list.countGreaterThat(element));
                break;

            case "Max":
                System.out.println(this.list.getMax());
                break;

            case "Min":
                System.out.println(this.list.getMin());
                break;

            case "Print":
                for (Object obj : list) {
                    System.out.println(obj);
                }
                break;

            case "Sort":
                sorter.sort(this.list);
                break;

            default:
                System.out.println("Invalid command.");
                break;
        }

    }
}
