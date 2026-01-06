import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeFileHandler {

    private static final String FILE = "data/employees.txt";

    public static void save(ArrayList<Employee> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (Employee e : list) {
                bw.write(e.toString());
                bw.newLine();
            }
            System.out.println("Employee data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public static ArrayList<Employee> load() {
        ArrayList<Employee> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                list.add(new Employee(
                        d[0], d[1], d[2], d[3],
                        Double.parseDouble(d[4]),
                        LocalDate.parse(d[5])
                ));
            }
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
        return list;
    }
}
