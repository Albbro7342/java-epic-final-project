import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("Welcome to the Java EPIC Final Project\n");
        
        do {
            System.out.println("=========== MAIN MENU ===========");
            System.out.println("1 Create Player");
            System.out.println("2 Choose Game Theme");
            System.out.println("3 View Player");
            System.out.println("4 Start Action");
            System.out.println("5 Exit");
            System.out.print("Enter your choice: ");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                System.out.println();
                
                switch (choice) {
                case 1:
                    System.out.println("Creating player...");
                    break;
                
                case 2:
                    System.out.println("Choosing game theme...");
                    break;
                    
                case 3:
                    System.out.println("Viewing player info...");
                    break;
               
                case 4:
                    System.out.println("Starting action!");
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please pick an option between 1 and 5.\n");
            }
        } else {
            System.out.println("\nInvalid input. Please enter a valid number.\n");
            scanner.next(); 
}
            
            System.out.println();
        } while (choice != 5);

        scanner.close();
	}

}

