import java.util.Arrays;
import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введіть кількість рядків для масиву: ");
    int count = scanner.nextInt();
    scanner.nextLine();

    String[] inputArray = new String[count];

    System.out.println("Введіть рядки (кожен з нового рядка):");
    for (int i = 0; i < count; i++) {
        inputArray[i] = scanner.nextLine();
    }

    double average = calculateAverageLength(inputArray);
    System.out.println("\nСередня довжина рядка: " + average);

    String[] lessThanAverage = filterStrings(inputArray, true);
    System.out.println("\nРядки, довжина яких менша середньої:");
    for (String s : lessThanAverage) {
        System.out.println("- " + s + " (довжина: " + s.length() + ")");
    }

    String[] greaterThanAverage = filterStrings(inputArray, false);
    System.out.println("\nРядки, довжина яких більша середньої:");
    for (String s : greaterThanAverage) {
        System.out.println("- " + s + " (довжина: " + s.length() + ")");
    }

    scanner.close();
}

public static String[] filterStrings(String[] array, boolean getLessThanAverage) {
    if (array == null || array.length == 0) {
        return new String[0];
    }

    double average = calculateAverageLength(array);

    return Arrays.stream(array)
            .filter(s -> getLessThanAverage ? s.length() < average : s.length() > average)
            .toArray(String[]::new);
}

private static double calculateAverageLength(String[] array) {
    if (array == null || array.length == 0) {
        return 0;
    }

    return Arrays.stream(array)
            .mapToInt(String::length)
            .average()
            .orElse(0.0);
}