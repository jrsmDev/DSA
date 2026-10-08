import java.util.Scanner;

/**
 * Queue Management System
 * A single menu-driven Java application that lets the user choose between:
 *   Problem #1 - Hospital Patient Queue (Circular Queue using an array)
 *   Problem #4 - Coffee Shop Customer Queue (Simple Queue using an array)
 *
 * The program keeps running until the user selects Exit on the main menu.
 * Each sub-system also has its own menu loop; choosing "Exit" inside a
 * sub-system returns control to the main menu instead of closing the program.
 */
public class QueueManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mainChoice;

        do {
            System.out.println("\n========== QUEUE MANAGEMENT SYSTEM ==========");
            System.out.println("1. Hospital Patient Queue (Problem #1 - Circular Queue)");
            System.out.println("2. Coffee Shop Customer Queue (Problem #4 - Simple Queue)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            mainChoice = readInt(sc);

            switch (mainChoice) {
                case 1:
                    runHospitalQueueSystem(sc);
                    break;
                case 2:
                    runCoffeeShopQueueSystem(sc);
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (mainChoice != 3);

        sc.close();
    }

    // =====================================================================
    // Problem #1: Hospital Patient Queue Management System (Circular Queue)
    // =====================================================================
    private static void runHospitalQueueSystem(Scanner sc) {
        System.out.print("\nEnter maximum queue capacity: ");
        int capacity = readInt(sc);
        while (capacity <= 0) {
            System.out.print("Capacity must be greater than 0. Enter maximum queue capacity: ");
            capacity = readInt(sc);
        }

        HospitalPatientQueue hospitalQueue = new HospitalPatientQueue(capacity);
        int choice;

        do {
            System.out.println("\n----- HOSPITAL PATIENT QUEUE MENU -----");
            System.out.println("1. Enqueue Patient");
            System.out.println("2. Dequeue Patient");
            System.out.println("3. Peek (Next Patient)");
            System.out.println("4. Display Queue");
            System.out.println("5. Check if Empty");
            System.out.println("6. Check if Full");
            System.out.println("7. Size");
            System.out.println("8. Exit (Return to Main Menu)");
            System.out.print("Enter your choice: ");

            choice = readInt(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine().trim();
                    hospitalQueue.enqueue(name);
                    break;
                case 2:
                    hospitalQueue.dequeue();
                    break;
                case 3:
                    hospitalQueue.peek();
                    break;
                case 4:
                    hospitalQueue.display();
                    break;
                case 5:
                    System.out.println(hospitalQueue.isEmpty() ? "Queue is EMPTY." : "Queue is NOT empty.");
                    break;
                case 6:
                    System.out.println(hospitalQueue.isFull() ? "Queue is FULL." : "Queue is NOT full.");
                    break;
                case 7:
                    System.out.println("Number of patients waiting: " + hospitalQueue.getSize());
                    break;
                case 8:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }

    // Circular Queue implementation backing the Hospital Patient Queue system
    private static class HospitalPatientQueue {
        private String[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public HospitalPatientQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new String[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public int getSize() {
            return size;
        }

        // Add a new patient to the rear of the circular queue
        public void enqueue(String patientName) {
            if (isFull()) {
                System.out.println("Queue is FULL! Cannot add patient: " + patientName);
                return;
            }
            rear = (rear + 1) % capacity; // wrap around when reaching the end
            queue[rear] = patientName;
            size++;
            System.out.println("Patient \"" + patientName + "\" added to the queue.");
        }

        // Remove and serve the patient at the front of the queue
        public void dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is EMPTY! No patient to serve.");
                return;
            }
            String servedPatient = queue[front];
            queue[front] = null;
            front = (front + 1) % capacity; // wrap around when reaching the end
            size--;
            System.out.println("Serving patient: " + servedPatient);
        }

        // Show the next patient to be served without removing them
        public void peek() {
            if (isEmpty()) {
                System.out.println("Queue is EMPTY! No patient waiting.");
                return;
            }
            System.out.println("Next patient to be served: " + queue[front]);
        }

        // Display all patients currently waiting, in FIFO order
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is EMPTY! No patients waiting.");
                return;
            }
            System.out.println("Patients currently waiting:");
            int index = front;
            for (int i = 0; i < size; i++) {
                System.out.println((i + 1) + ". " + queue[index]);
                index = (index + 1) % capacity;
            }
        }
    }

    // =====================================================================
    // Problem #4: Coffee Shop Customer Queue System (Simple Queue, cap = 5)
    // =====================================================================
    private static void runCoffeeShopQueueSystem(Scanner sc) {
        CoffeeShopQueueSystem coffeeQueue = new CoffeeShopQueueSystem();
        int choice;

        do {
            System.out.println("\n----- COFFEE SHOP CUSTOMER QUEUE MENU -----");
            System.out.println("1. Add Customer (Enqueue)");
            System.out.println("2. Serve Customer (Dequeue)");
            System.out.println("3. Next Customer (Peek)");
            System.out.println("4. Display Queue");
            System.out.println("5. Check Empty");
            System.out.println("6. Check Full");
            System.out.println("7. Queue Size");
            System.out.println("8. Exit (Return to Main Menu)");
            System.out.print("Enter your choice: ");

            choice = readInt(sc);

            switch (choice) {
                case 1:
                    if (coffeeQueue.isFull()) {
                        System.out.println("Queue is FULL! Cannot add more customers.");
                    } else {
                        System.out.print("Enter customer name: ");
                        String name = sc.nextLine().trim();
                        coffeeQueue.enqueue(name);
                    }
                    break;
                case 2:
                    coffeeQueue.dequeue();
                    break;
                case 3:
                    coffeeQueue.peek();
                    break;
                case 4:
                    coffeeQueue.display();
                    break;
                case 5:
                    System.out.println(coffeeQueue.isEmpty() ? "Queue is EMPTY." : "Queue is NOT empty.");
                    break;
                case 6:
                    System.out.println(coffeeQueue.isFull() ? "Queue is FULL." : "Queue is NOT full.");
                    break;
                case 7:
                    System.out.println("Number of customers waiting: " + coffeeQueue.getSize());
                    break;
                case 8:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }

    // Simple (linear) array Queue implementation backing the Coffee Shop system
    private static class CoffeeShopQueueSystem {
        private static final int CAPACITY = 5;
        private String[] queue;
        private int front;
        private int rear;
        private int size;

        public CoffeeShopQueueSystem() {
            queue = new String[CAPACITY];
            front = 0;
            rear = -1;
            size = 0; 
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == CAPACITY;
        }

        public int getSize() {
            return size;
        }

        // Add a customer to the rear of the queue
        public void enqueue(String customerName) {
            if (isFull()) {
                System.out.println("Queue is FULL! Cannot add customer: " + customerName);
                return;
            }
            rear++;
            queue[rear] = customerName;
            size++;
            System.out.println("Customer \"" + customerName + "\" added to the queue.");
        }

        // Serve and remove the customer at the front of the queue
        public void dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is EMPTY! No customer to serve.");
                return;
            }
            String servedCustomer = queue[front];
            queue[front] = null;
            front++;
            size--;
            System.out.println("Serving customer: " + servedCustomer);

            // Reset pointers once the queue drains, since this is a simple
            // (non-circular) queue and slots before "front" are unusable otherwise
            if (isEmpty()) {
                front = 0;
                rear = -1;
            }
        }

        // Display the customer who will be served next
        public void peek() {
            if (isEmpty()) {
                System.out.println("Queue is EMPTY! No customer waiting.");
                return;
            }
            System.out.println("Next customer to be served: " + queue[front]);
        }

        // Display all customers currently waiting, in FIFO order
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is EMPTY! No customers waiting.");
                return;
            }
            System.out.println("Customers currently waiting:");
            for (int i = front; i <= rear; i++) {
                System.out.println((i - front + 1) + ". " + queue[i]);
            }
        }
    }

    // Safely reads an integer choice, re-prompting on invalid (non-numeric) input
    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine(); // consume leftover newline
        return value;
    }
}