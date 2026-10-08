import java.util.Scanner;

/*
Problem 1: Students Hash Table using Closed Hashing

1. User enters the size of the hash table.
2. User enters the number of students.
3. User enters each student's ID and name.
4. Hash function: ID % tableSize
5. Collision handling: linear probing.
6. User can insert, search and display student information.
*/

public class HashTable {

    static class Student {
        int id;
        String name;

        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private final Student[] table;
    private final int size;

    public HashTable(int size) {
        this.size = size;
        table = new Student[size];
    }

    private int hash(int id) {
        return id % size;
    }

    public boolean insert(int id, String name) {
        int index = hash(id);
        int attempts = 0;

        while (table[index] != null) {
            if (table[index].id == id) {
                System.out.println("Error: Student ID " + id + " already exists.");
                return false;
            }
            index = (index + 1) % size;
            attempts++;
            if (attempts == size) {
                System.out.println("Error: Hash table is full. Cannot insert student ID " + id + ".");
                return false;
            }
        }

        table[index] = new Student(id, name);
        System.out.println("Student ID " + id + " (" + name + ") inserted at index " + index + ".");
        return true;
    }

    public void search(int id) {
        int index = hash(id);
        int attempts = 0;

        while (attempts < size) {
            if (table[index] == null) {
                System.out.println("Student ID " + id + " not found.");
                return;
            }
            if (table[index].id == id) {
                System.out.println("Found: ID = " + table[index].id
                        + ", Name = " + table[index].name
                        + ", Index = " + index);
                return;
            }
            index = (index + 1) % size;
            attempts++;
        }

        System.out.println("Student ID " + id + " not found.");
    }

    public void display() {
        System.out.println("\n--- Hash Table Contents ---");
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.println("Index " + i + ": ID = " + table[i].id + ", Name = " + table[i].name);
            } else {
                System.out.println("Index " + i + ": [empty]");
            }
        }
        System.out.println("---------------------------\n");
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine(); 
                return value;
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                sc.nextLine(); 
            }
        }
    }

    private static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            int value = readInt(sc, prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Please enter a number greater than 0.");
        }
    }

    private static int readNonNegativeInt(Scanner sc, String prompt) {
        while (true) {
            int value = readInt(sc, prompt);
            if (value >= 0) {
                return value;
            }
            System.out.println("Please enter a number that is not negative.");
        }
    }

    private static String readNonBlankLine(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Name cannot be blank. Please try again.");
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int size = readPositiveInt(sc, "Enter the size of the hash table: ");
            HashTable hashTable = new HashTable(size);

            int numStudents = readNonNegativeInt(sc, "Enter the number of students: ");

            for (int i = 0; i < numStudents; i++) {
                System.out.println("\nStudent " + (i + 1) + ":");
                int id = readNonNegativeInt(sc, "Enter Student ID: ");
                String name = readNonBlankLine(sc, "Enter Student Name: ");
                hashTable.insert(id, name);
            }

            int choice;
            do {
                System.out.println("\n==== MENU ====");
                System.out.println("1. Insert Student");
                System.out.println("2. Search Student");
                System.out.println("3. Display Hash Table");
                System.out.println("4. Exit");
                choice = readInt(sc, "Enter choice: ");

                switch (choice) {
                    case 1 -> {
                        int newId = readNonNegativeInt(sc, "Enter Student ID: ");
                        String newName = readNonBlankLine(sc, "Enter Student Name: ");
                        hashTable.insert(newId, newName);
                    }
                    case 2 -> {
                        int searchId = readNonNegativeInt(sc, "Enter Student ID to search: ");
                        hashTable.search(searchId);
                    }
                    case 3 -> hashTable.display();
                    case 4 -> System.out.println("Exiting program.");
                    default -> System.out.println("Invalid choice. Please enter 1-4.");
                }
            } while (choice != 4);
        }
    }
}