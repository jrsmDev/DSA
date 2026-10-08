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

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the hash table: ");
            int size = sc.nextInt();
            HashTable hashTable = new HashTable(size);

            System.out.print("Enter the number of students: ");
            int numStudents = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            for (int i = 0; i < numStudents; i++) {
                System.out.println("\nStudent " + (i + 1) + ":");
                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();
                hashTable.insert(id, name);
            }

            int choice;
            do {
                System.out.println("\n==== MENU ====");
                System.out.println("1. Insert Student");
                System.out.println("2. Search Student");
                System.out.println("3. Display Hash Table");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Student ID: ");
                        int newId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Student Name: ");
                        String newName = sc.nextLine();
                        hashTable.insert(newId, newName);
                    }
                    case 2 -> {
                        System.out.print("Enter Student ID to search: ");
                        int searchId = sc.nextInt();
                        sc.nextLine();
                        hashTable.search(searchId);
                    }
                    case 3 -> hashTable.display();
                    case 4 -> System.out.println("Exiting program.");
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 4);
        }
    }
}

