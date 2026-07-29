import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest2 {
    public static void main(String[] args) {

        // 1. Traverse and display all animals.
        ArrayList<String> animals = new ArrayList<>(Arrays.asList("Dog", "Cat", "Rabbit", "Horse", "Tiger"));
        System.out.println("Original Animals: " + animals );

        // 2. Insert "Lion" at index 3.
        animals.add(3, "Lion");

        // 3. Delete "Cat".
        animals.remove("Cat");

        // 4. Search for "Tiger".
        System.out.println("Tiger Found: " + animals.contains("Tiger") );

        // 5. Update "Rabbit" to "Elephant".
        animals.set(animals.indexOf("Rabbit"), "Elephant");

        // 6. Display the final Array.
        System.out.println("Updated Animals: " + animals);

        // 7. Count how many animals are in the final array.
        System.out.println("Total Animal List: " + animals.size());

        // 8. Display the animals in reverse order.
        for (int i = animals.size() -1; i >= 0; i--) {
            System.out.println(animals.get(i));
        }

    }
}

/*

Problem: 
  String[] animals = {"Dog", "Cat", "Rabbit", "Horse", "Tiger"};

  1. Traverse and display all animals.
  2. Insert "Lion" at index 3.
  3. Delete "Cat".
  4. Search for "Tiger".
  5. Update "Rabbit" to "Elephant".
  6. Display the final array.

  extra challenge:

  7. Count how many animals are in the final array.
  8. Display the animals in reverse order.

*/
