package util;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class SandwichCSVReader {
    public static void main(String[] args) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader("src/repository/ListOfSandwiches.csv"), ';')) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                String language = line[0];
                String toppingType = line[1];
                String sandwich = line[2];
                String description = line[3];
                String price = line[4];

                // Process the data as needed
                System.out.println("Language: " + language);
                System.out.println("ToppingType: " + toppingType);
                System.out.println("Sandwich: " + sandwich);
                System.out.println("Description: " + description);
                System.out.println("Price: " + price);
            }
        }
    }
}
