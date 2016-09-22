package problem4;

import problem4.models.Smartphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Smartphone phone = new Smartphone();

            String[] numbers = reader.readLine().split(" ");
            for (String number : numbers) {
                if (validateNumber(number)) {
                    phone.callAnotherPhones(number);
                } else {
                    System.out.println("Invalid number!");
                }

            }

            String[] webs = reader.readLine().split(" ");
            for (String web : webs) {
                if (validateWeb(web)) {
                    phone.browseWWW(web);
                } else {
                    System.out.println("Invalid URL!");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean validateWeb(String web) {
        boolean isValidUrl = true;
        for (int i = 0; i < web.length(); i++) {
            if (Character.isDigit(web.charAt(i))) {
                isValidUrl = false;
                break;
            }
        }
        return isValidUrl;
    }

    private static boolean validateNumber(String number) {
        boolean isValidNumber = true;
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                isValidNumber = false;
                break;
            }
        }
        return isValidNumber;
    }
}
