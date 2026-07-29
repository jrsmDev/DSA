import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
    public static void main(String[] args) {

        // 1. Traverse and display all fruits 
        ArrayList<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Mango"));
        System.out.println("Original Fruits: " + fruits);

        // 2. Insert Grapes at index 2
        fruits.add(2, "Grapes");
        
        // 3. Delete Banana 
        fruits.remove("Banana");

        // 4. Search for Mango
        System.out.println("Mango found: " +fruits.contains("Mango"));

        // 5. Update Orange to Pineapple
        fruits.set(fruits.indexOf("Orange"), "Pineapple");

        // 6. Display the final array
        System.out.println("Updated Fruits: " + fruits);
    }
}

/* 

Problem:
 String[] fruits[] = {"Apple", "Banana", "Orange", "Mango"};
 
 1. Traverse and display all fruits.
 2. Insert Grapes at index 2.
 3. Delete banana.
 4. Search for Mango.
 5. Update Orange to Pineapple.
 6. Display the final array.

*/