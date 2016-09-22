package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

			Class<BlackBoxInt> blackBoxClass = BlackBoxInt.class;
			Constructor<BlackBoxInt> blackBoxConstructor = blackBoxClass.getDeclaredConstructor();
			blackBoxConstructor.setAccessible(true);
			BlackBoxInt instance = blackBoxConstructor.newInstance();

			while (true){
				String input = reader.readLine();
				if ("END".equals(input)){
					break;
				}

				String[] params = input.split("_");
				String command = params[0];
				int number = Integer.parseInt(params[1]);

				Method currentMethod = blackBoxClass.getDeclaredMethod(command, int.class);
				currentMethod.setAccessible(true);
				currentMethod.invoke(instance, number);

				Field innerField = blackBoxClass.getDeclaredField("innerValue");
				innerField.setAccessible(true);

				System.out.println(innerField.getInt(instance));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
