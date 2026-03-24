import java.util.Scanner;
public class EvenOdd_Checker {
    public static void checkAndPrint(int number) {
        String result = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println(number + " is " + result);
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);import java.util.*;
import java.util.stream.Collectors;

// Employee class for collection demonstrations
class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return String.format("%d: %s (%s)", id, name, department);
    }

    // For Set uniqueness
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// Generic utility class
class DataSorter<T extends Comparable<? super T>> {
    // Generic method to sort any Comparable list
    public List<T> sortList(List<T> list) {
        Collections.sort(list);
        return list;
    }

    // Advanced: Generic method with custom comparator
    public List<T> sortList(List<T> list, Comparator<? super T> comparator) {
        list.sort(comparator);
        return list;
    }

    // Bonus: Generic filter method
    public static <T> List<T> filter(List<T> list, java.util.function.Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}

public class CollectionsDemo {
    public static void main(String[] args) {
        // 1. List Demonstration
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Alice", "Engineering"));
        employeeList.add(new Employee(103, "Bob", "Marketing"));
        employeeList.add(new Employee(102, "Charlie", "HR"));

        System.out.println("=== Original List ===");
        employeeList.forEach(System.out::println);

        // 2. Set Demonstration (Unique Employees)
        Set<Employee> employeeSet = new HashSet<>(employeeList);
        employeeSet.add(new Employee(101, "Alice", "Engineering")); // Duplicate ID

        System.out.println("\n=== Unique Employees (Set) ===");
        System.out.println("Set size: " + employeeSet.size()); // 3, not 4

        // 3. Map Demonstration (ID → Employee)
        Map<Integer, Employee> employeeMap = new HashMap<>();
        employeeList.forEach(emp -> employeeMap.put(emp.getId(), emp));

        System.out.println("\n=== Employee Map ===");
        System.out.println("Employee 102: " + employeeMap.get(102));

        // 4. Generics Utility Usage
        DataSorter<Employee> sorter = new DataSorter<>();

        // Natural ordering (by ID)
        List<Employee> sortedById = sorter.sortList(new ArrayList<>(employeeList));
        System.out.println("\n=== Sorted by ID ===");
        sortedById.forEach(System.out::println);

        // Custom ordering (by name)
        List<Employee> sortedByName = sorter.sortList(
            new ArrayList<>(employeeList),
            Comparator.comparing(Employee::getName)
        );
        System.out.println("\n=== Sorted by Name ===");
        sortedByName.forEach(System.out::println);

        // 5. Bonus: Stream API with Collections
        Map<String, List<Employee>> byDepartment = employeeList.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\n=== Employees by Department ===");
        byDepartment.forEach((dept, emps) ->
            System.out.println(dept + ": " + emps.size() + " employees")
        );

        // 6. Bonus: Generic Filter Utility
        List<Employee> engineers = DataSorter.filter(employeeList,
            e -> "Engineering".equals(e.getDepartment()));
        System.out.println("\n=== Filtered Engineers ===");
        engineers.forEach(System.out::println);
    }
}

        // Static input
        int no = 27;
        System.out.println("Static Check:");
        checkAndPrint(no);
        // Dynamic input
        System.out.print("\nEnter an integer: ");
        if (sc.hasNextInt()) {
            int inputNo = sc.nextInt();
            checkAndPrint(inputNo);
        } else {
            System.out.println("Invalid input! Please enter an integer.");
        }
    }
}
