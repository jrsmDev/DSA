import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest3 {
    public static void main(String[] args) {

        // 1. Traverse and display all employees.
        ArrayList<String> employees = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve"));
        System.out.println("Original Array List: " + employees);

        // 2. Insert "Mark" at index 2.
        employees.add(2, "Mark");

        // 3. Remove "Bob".
        employees.remove("Bob");

        // 4. Search if "Charlie" exists.
        System.out.println("Charlie Found: " + employees.contains("Charlie"));

        // 5. Update "David" to "Daniel".
        employees.set(employees.indexOf("David"), "Daniel");

        // 6. Display the current list.
        System.out.println("Updated Array List: " + employees);

        // 7. Print the total number of employees.
        System.out.println("Total Numbers fo Employees: " + employees.size());

        // 8. Print the employees in reverse order.
        for (int i = employees.size() - 1; i >= 0; i--){
            System.out.println(employees.get(i));
        }
        
        // 9. Print the index of "Mark".
        System.out.println("Mark is at index: " + employees.indexOf("Mark"));

        // 10. Print only the employees whose names contain the letter 'a' or 'A'.
        for (String employee : employees) {
            if (employee.toLowerCase().contains("a")) {
                System.out.println(employee);
            }
        }
    
    }
}


/*

Problem: 
  ArrayList<String> employees = new ArrayList<>(
    Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve")
);

  1. Traverse and display all employees.
  2. Insert "Mark" at index 2.
  3. Remove "Bob".
  4. Search if "Charlie" exists.
  5. Update "David" to "Daniel".
  6. Display the current list.
  7. Print the total number of employees.
  8. Print the employees in reverse order.
  9. Print the index of "Mark".
  10. Print only the employees whose names contain the letter 'a' or 'A'.

*/