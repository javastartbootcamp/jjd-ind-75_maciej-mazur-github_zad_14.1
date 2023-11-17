package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileManager {
    private static final String FILE_NAME = "liczby.txt";
    private final Map<Integer, Integer> numbers = new TreeMap<>();

    public Map<Integer, Integer> importNumbers() throws IOException {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))
        ) {
            while (scanner.hasNextLine()) {
                addNumber(Integer.parseInt(scanner.nextLine()));
            }

            return numbers;
        } catch (IOException e) {
            throw new IOException("Nie znaleziono pliku " + FILE_NAME);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Co najmniej jedna liczba w pliku podana jest w nieprawidłowym formacie.");
        }
    }

    private void addNumber(int number) {
        if (numbers.containsKey(number)) {
            int currentValue = numbers.get(number);
            numbers.put(number, ++currentValue);
        } else {
            numbers.put(number, 1);
        }
    }
}
