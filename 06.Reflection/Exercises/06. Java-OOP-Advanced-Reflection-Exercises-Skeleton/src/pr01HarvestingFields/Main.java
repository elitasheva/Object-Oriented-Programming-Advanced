package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {

	public static void main(String[] args) {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

			while (true){

				String input = reader.readLine();
				if ("HARVEST".equals(input)){
					break;
				}

				Class currentClass = RichSoilLand.class;
				Field[] fields = currentClass.getDeclaredFields();
				for (Field field : fields) {
					int mod = field.getModifiers();
					String modifier = Modifier.toString(mod);
					if (modifier.equals(input) || input.equals("all")){
						String fieldName = field.getName();
						String fieldType = field.getType().getSimpleName();
						System.out.println(String.format("%s %s %s", modifier, fieldType, fieldName));
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
