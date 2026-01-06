import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        employees = EmployeeFileHandler.load();

        while (true) {
            System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add New Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Generate Reports");
            System.out.println("7. Save to File");
            System.out.println("8. Load from File");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> addEmployee();

                case 2 -> {
                    if (employees.isEmpty()) {
                        System.out.println("No employee records found.");
                    } else {
                        printAllEmployees(employees);
                    }
                }

                case 3 -> searchEmployee();

                case 4 -> updateEmployee();

                case 5 -> deleteEmployee();

                case 6 -> EmployeeReportGenerator.salaryReport(employees);

                case 7 -> {
                    EmployeeFileHandler.save(employees);
                }


                case 8 -> {
                    employees = EmployeeFileHandler.load();
                    if (employees.isEmpty()) {
                        System.out.println("No previous data found.");
                    } else {
                        System.out.println("\n=== LOADED EMPLOYEE DATA ===");
                        printAllEmployees(employees);
                    }
                }

                case 9 -> {
                    System.out.println("Thank you! Program terminated.");
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ================= ADD EMPLOYEE =================
    static void addEmployee() {
        System.out.println("\n=== ADD NEW EMPLOYEE ===");

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Position: ");
        String pos = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        employees.add(new Employee(id, name, dept, pos, salary, LocalDate.now()));
        System.out.println("✅ Employee added successfully!");
        EmployeeFileHandler.save(employees);
    }

    // ================= VIEW EMPLOYEES =================
    static void printAllEmployees(ArrayList<Employee> list) {
        System.out.printf("%-10s %-20s %-15s %-15s %-12s %-12s%n",
                "ID", "Name", "Department", "Position", "Salary", "Join Date");
        System.out.println("------------------------------------------------------------------------------------------");

        for (Employee e : list) {
            System.out.printf("%-10s %-20s %-15s %-15s ₹%-11.2f %-12s%n",
                    e.getId(), e.getName(), e.getDepartment(),
                    e.getPosition(), e.getSalary(), e.getJoinDate());
        }
    }

    // ================= SEARCH EMPLOYEE =================
    static void searchEmployee() {
        System.out.println("\n=== SEARCH EMPLOYEE ===");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Department");
        System.out.print("Enter choice: ");

        int ch = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter search value: ");
        String value = sc.nextLine();

        boolean found = false;

        for (Employee e : employees) {
            if ((ch == 1 && e.getId().equalsIgnoreCase(value)) ||
                (ch == 2 && e.getName().toLowerCase().contains(value.toLowerCase())) ||
                (ch == 3 && e.getDepartment().equalsIgnoreCase(value))) {

                System.out.println(e.getId() + " | " + e.getName() + " | " +
                        e.getDepartment() + " | " + e.getPosition() +
                        " | ₹" + e.getSalary());
                found = true;
            }
        }

        if (!found)
            System.out.println("No matching employee found.");
    }

    // ================= UPDATE EMPLOYEE =================
    static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        String id = sc.nextLine();

        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id)) {

                System.out.print("New Department: ");
                e.setDepartment(sc.nextLine());

                System.out.print("New Position: ");
                e.setPosition(sc.nextLine());

                System.out.print("New Salary: ");
                e.setSalary(sc.nextDouble());
                sc.nextLine();

                System.out.println("✅ Employee updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // ================= DELETE EMPLOYEE =================
    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        String id = sc.nextLine();

        boolean removed = employees.removeIf(e -> e.getId().equalsIgnoreCase(id));

        if (removed)
            System.out.println("✅ Employee deleted.");
        else
            System.out.println("Employee not found.");
    }
}
