import model.Course;
import model.Person;

import java.io.*;
import java.util.*;

public class ReportGeneratorMain {
    public static void main(String[] args) {
        Person person = new Person("John Doe", "Student");
        Course course = Course.JAVA_BEGINNER;
        // Define the input CSV file path
        String inputCsvFilePath = "src/repository/ListOfSandwiches.csv";

        // Read the CSV file and extract unique topping types for each language
        Map<String, Set<String>> languageToToppingTypes = new HashMap<>();
        Map<String, Set<String>> toppingToSandwiches = new HashMap<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(inputCsvFilePath))) {
            String line;
            while ((line = csvReader.readLine()) != null) {
                String[] columns = line.split(";");
                if (columns.length >= 2) {
                    String language = columns[0].trim().toUpperCase(); // Get the language from the first column
                    String toppingType = columns[1];
                    String sandwichesType = columns[2];

                    // Ensure the language is uppercase for consistency
                    languageToToppingTypes
                            .computeIfAbsent(language, key -> new HashSet<>())
                            .add(toppingType);

                    toppingToSandwiches
                            .computeIfAbsent(toppingType, key -> new HashSet<>())
                            .add(sandwichesType);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Define the output file path
        String outputPath = "sandwich_report.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            // Sample languages
            String[] languages = {"EN", "FR", "NL"}; // You can add more languages here

            // Generate the report for each language
            for (String language : languages) {
                writer.write("——————————————————————————————————————————————————————————————————————————————————————");
                writer.newLine();
                writer.write("Sandwiches (Pinky’s)");
                writer.newLine();
                writer.write("——————————————————————————————————————————————————————————————————————————————————————");
                writer.newLine();
                writer.write("Name: " + person.getName());
                writer.newLine();
                writer.write("Course: " + course.getName());
                writer.newLine();
                writer.write("——————————————————————————————————————————————————————————————————————————————————————");
                writer.newLine();
                writer.newLine();

                // Write the unique topping types for the current language
                Set<String> toppingTypes = languageToToppingTypes.get(language);
                if (toppingTypes != null) {
                    for (String toppingType : toppingTypes) {
                        writer.write(toppingType);
                        writer.newLine();
                        Set<String> sandwichesTypes = toppingToSandwiches.get(toppingType);
                        if (sandwichesTypes != null) {
                            for (String sandwichesType : sandwichesTypes) {
                                writer.write(sandwichesType);
                                writer.newLine();
                            }
                        }
                        writer.newLine();
                        writer.newLine();
                    }
                }

                writer.newLine();
            }

            System.out.println("Report generated and saved to " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
