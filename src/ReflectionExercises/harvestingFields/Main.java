package ReflectionExercises.harvestingFields;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Scanner scanner = new Scanner(System.in);

		Class cl = RichSoilLand.class;
		Object richSoilLand = cl.newInstance();

		Field[] fields = richSoilLand.getClass().getDeclaredFields();

		String command = scanner.nextLine();
		while (!command.equals("HARVEST")) {
			if (command.equals("private")) {
				for (Field field : fields) {
					if (field.toString().startsWith("private")) {
						System.out.printf("%s %s %s\n", command, field.getType().getSimpleName(), field.getName());
					}
				}
			}
			else if (command.equals("protected")) {
				for (Field field : fields) {
					if (field.toString().startsWith("protected")) {
						System.out.printf("%s %s %s\n", command, field.getType().getSimpleName(), field.getName());
					}
				}
			}
			else if (command.equals("public")) {
				for (Field field : fields) {
					if (field.toString().startsWith("public")) {
						System.out.printf("%s %s %s\n", command, field.getType().getSimpleName(), field.getName());
					}
				}
			}
			else if (command.equals("all")) {
				for (Field field : fields) {
					System.out.printf("%s %s %s\n", field.toString().split("\\s+")[0], field.getType().getSimpleName(), field.getName());

				}
			}

			command = scanner.nextLine();
		}
	}
}
