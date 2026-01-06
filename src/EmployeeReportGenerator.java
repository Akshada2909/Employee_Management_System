import java.util.*;

public class EmployeeReportGenerator {

    public static void salaryReport(ArrayList<Employee> employees) {

        double total = 0, max = 0, min = Double.MAX_VALUE;
        Employee maxEmp = null, minEmp = null;

        Map<String, List<Employee>> deptMap = new HashMap<>();

        for (Employee e : employees) {
            total += e.getSalary();

            if (e.getSalary() > max) { max = e.getSalary(); maxEmp = e; }
            if (e.getSalary() < min) { min = e.getSalary(); minEmp = e; }

            deptMap.computeIfAbsent(e.getDepartment(), k -> new ArrayList<>()).add(e);
        }

        System.out.println("\n💰 SALARY STATISTICS:");
        System.out.printf("• Total Employees: %d%n", employees.size());
        System.out.printf("• Total Salary: ₹%,.2f%n", total);
        System.out.printf("• Average Salary: ₹%,.2f%n", total / employees.size());
        System.out.printf("• Highest Salary: ₹%,.2f (%s)%n", max, maxEmp.getName());
        System.out.printf("• Lowest Salary: ₹%,.2f (%s)%n", min, minEmp.getName());

        System.out.println("\n🏢 DEPARTMENT SUMMARY:");
        for (String dept : deptMap.keySet()) {
            double sum = 0;
            for (Employee e : deptMap.get(dept)) sum += e.getSalary();
            System.out.printf("• %s: %d employees, Average: ₹%,.2f%n",
                    dept, deptMap.get(dept).size(), sum / deptMap.get(dept).size());
        }
    }
}
