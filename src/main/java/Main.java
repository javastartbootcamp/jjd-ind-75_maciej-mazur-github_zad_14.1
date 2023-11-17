import io.file.FileManager;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        try {
            Map<Integer, Integer> numbers = fileManager.importNumbers();
            printNumbersStatistics(numbers);
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printNumbersStatistics(Map<Integer, Integer>  numbers) {
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            System.out.printf("%d - liczba wystąpień %d%n", entry.getKey(), entry.getValue());
        }
    }
}
