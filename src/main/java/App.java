import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main application class to manage client data.
 * This class serves as the entry point for the client management system.
 */
import java.util.Scanner;

public class App {

    private static final ClientService clientService = new ClientService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    // Display all clients
                    break;
                case 2:
                    // Add a new client
                    break;
                case 3:
                    // Find a client by ID
                    break;
                case 4:
                    // Update a client
                    break;
                case 5:
                    // Delete a client
                    break;
                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- Client Management System ---");
        System.out.println("1. Display all clients");
        System.out.println("2. Add a new client");
        System.out.println("3. Find a client by ID");
        System.out.println("4. Update a client");
        System.out.println("5. Delete a client");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice(Scanner scanner) {
        // TODO: Implement user input validation
        return scanner.nextInt();
    }
}