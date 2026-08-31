import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();

        do {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String productName = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String description = SafeInput.getNonZeroLenString(in, "Enter Description");
            double cost = SafeInput.getRangedDouble(in, "Enter Cost", 1, 1000000);

            products.add(id + ", " + productName + ", " + description + ", " + cost);

        } while (SafeInput.getYNConfirm(in, "Do you have more records to enter?"));

        String fileName = SafeInput.getNonZeroLenString(in, "Enter output filename: ");
        Files.write(Paths.get(fileName), products);


        System.out.println("File has been saved.");
    }
}
