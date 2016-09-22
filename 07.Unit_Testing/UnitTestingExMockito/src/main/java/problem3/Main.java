package problem3;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException, OperationNotSupportedException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            ListIterator customList = null;
            try {
                while (true){

                    String[] input = reader.readLine().split("[\\s]+");
                    String command = input[0];
                    if (command.equals("END")){
                        break;
                    }

                    switch (command){
                        case "Create":
                            List<String> list = new ArrayList<String>();
                            for (int i = 1; i < input.length; i++) {
                                list.add(input[i]);
                            }
                            customList = new ListIterator(list);
                            break;

                        case "Move":
                            System.out.println(customList.move());
                            break;

                        case "HasNext":
                            System.out.println(customList.hasNext());
                            break;

                        case "Print":
                            System.out.println(customList.print());
                            break;
                    }
                }

            }catch (OperationNotSupportedException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

