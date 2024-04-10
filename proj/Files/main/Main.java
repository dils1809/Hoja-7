package Files.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<>();
    }

    public void loadDictionary(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    String key = parts[0].trim().substring(1);
                    String value = parts[1].trim().substring(0, parts[1].length() - 1);
                    dictionary.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printSorted() {
        System.out.println("Ordered relationships by the English word:");
        dictionary.entrySet().stream()
            .sorted(Map.Entry.<String, String>comparingByKey())
            .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
    }

    public String translate(String word) {
        String translation = dictionary.get(word.toLowerCase());
        if (translation == null) {
            translation = "*" + word + "*";
        }
        return translation;
    }
}



public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.loadDictionary("diccionario.txt");
        dictionary.printSorted();

        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    // Separa las palabras y traduce cada una
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        String translation = dictionary.translate(word);
                        System.out.print(translation + " ");
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}