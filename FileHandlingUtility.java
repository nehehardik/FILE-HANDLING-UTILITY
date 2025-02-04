import java.io.*;

public class FileHandlingUtility {
    private static final String FILE_PATH = "sample.txt";

    public static void main(String[] args) {
        // Writing to a file
        writeFile("Welcome to the File Handling Utility!\nThis is a sample text file.");

        // Reading from a file
        System.out.println("File Content After Writing:");
        readFile();

        // Modifying the file (Appending text)
        modifyFile("\nAdditional content appended to the file.");

        // Reading again to verify modification
        System.out.println("\nFile Content After Modification:");
        readFile();
    }

    // Method to write to a file
    public static void writeFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    // Method to read from a file
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify a file (Append content)
    public static void modifyFile(String newContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(newContent);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }
}
