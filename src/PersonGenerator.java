import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        ArrayList<String> persons = new ArrayList<>();

        do {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title");
            int yob = SafeInput.getRangedInt(in, "Enter Year of Birth", 1000, 2026);

            persons.add(id + ", " + firstName + ", " + lastName + ", " + title + ", " + yob);

        } while (SafeInput.getYNConfirm(in, "Do you have more records to enter?"));

        String fileName = SafeInput.getNonZeroLenString(in, "Enter output filename: ");
        Files.write(Paths.get(fileName), persons);

        System.out.println("File has been saved.");
    }
}
