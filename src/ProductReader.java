import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.in;

public class ProductReader {
    public static void main(String[] args) throws FileNotFoundException {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            Scanner in = new Scanner(selectedFile);

            System.out.printf("%-8s%-15s%-25s%8s%n", "ID#", "Product Name", "Description", "Cost");
            System.out.println("===================================================");

            while (in.hasNextLine()){
                String line = in.nextLine();
                String[] fields = line.split(",");

                if (fields.length == 4){
                    String id = fields[0].trim();
                    String productName = fields[1].trim();
                    String description = fields[2].trim();
                    double cost = Double.parseDouble(fields[3].trim());

                    System.out.printf("%-8s%-15s%-25s%8s%n", id, productName, description, cost);

                }
            }
            in.close();

        }else {
            System.out.println("No file was selected.");
        }






    }
}
