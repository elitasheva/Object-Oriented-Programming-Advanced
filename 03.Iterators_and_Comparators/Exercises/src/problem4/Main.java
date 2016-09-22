package problem4;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.Iterator;
        import java.util.List;
        import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String[] collectionStr = reader.readLine().split("[,\\s]+");
            List<Integer> collectionInt = Arrays.asList(collectionStr).stream()
                    .map(Integer::parseInt).collect(Collectors.toList());
            Lake<Integer> lake = new Lake<>(collectionInt);

            String endCommand = reader.readLine();

            Iterator iter = lake.iterator();
            while (true){
                if (!iter.hasNext()){
                    System.out.print(iter.next());
                    break;
                }
                System.out.print(iter.next() + ", ");
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
