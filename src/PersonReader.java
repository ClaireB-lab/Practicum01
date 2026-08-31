import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.in;

public class PersonReader {
    public static void main(String[] args) throws FileNotFoundException {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            Scanner in = new Scanner(selectedFile);

            System.out.printf("%-8s%-15s%-15s%-8s%4s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
            System.out.println("===================================================");

            while (in.hasNextLine()){
                String line = in.nextLine();
                String[] fields = line.split(",");

                if (fields.length == 5){
                    String id = fields[0].trim();
                    String firstName = fields[1].trim();
                    String lastName = fields[2].trim();
                    String title = fields[3].trim();
                    int yob = Integer.parseInt(fields[4].trim());

                    System.out.printf("%-8s%-15s%-15s%-8s%4d%n", id, firstName, lastName, title, yob);

                }
            }
            in.close();

        }else {
            System.out.println("No file was selected.");
        }






    }
}
