package readDictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryReader {
    public static boolean doesFileExist(String path) {
        try {
            FileReader fileReader = new FileReader(path);
            fileReader.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
  public static void readDictionary(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                String word = parts[0].trim();
                String[] meanings = parts[1].split(",");
                System.out.println(word);
                for (String meaning : meanings) {
                    System.out.println(meaning.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "dictionary.txt";
        if (doesFileExist(filePath)) {
            System.out.println("File exists.");
            System.out.println("Words and their meanings:");
            readDictionary(filePath);
        } else {
            System.out.println("File does not exist.");
        }
    }
}