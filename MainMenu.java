import java.util.Scanner;

enum GameMode {
    NOT_SELECTED("None"),
    FANTASY_DUNGEON("Fantasy Dungeon"),
    CYBER_HACKER("Cyber Hacker"),
    SPACE_EXPLORER("Space Explorer");

    private final String displayName;

    GameMode(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

class Player {
    private String name;
    private int level;
    private GameMode selectedTheme;

    public Player(String name) {
        this.name = name;
        this.level = 1; 
        this.selectedTheme = GameMode.NOT_SELECTED;
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public GameMode getSelectedTheme() { return selectedTheme; }
    public void setSelectedTheme(GameMode selectedTheme) { this.selectedTheme = selectedTheme; }
}

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Player player = null;
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
                scanner.nextLine(); // Clear newline buffer
                System.out.println(); 

                switch (choice) {
                    case 1:
                        System.out.print("Enter player name: ");
                        String name = scanner.nextLine();
                        player = new Player(name);
                        System.out.println("Player '" + name + "' created successfully!\n");
                        break;

                    case 2:
                        if (player == null) {
                            System.out.println("Error: Please create a player first (Option 1).\n");
                            break;
                        }
                        System.out.println("--- Choose Game Theme ---");
                        System.out.println("1 Fantasy Dungeon");
                        System.out.println("2 Cyber Hacker");
                        System.out.println("3 Space Explorer");
                        System.out.print("Select theme choice: ");
                        
                        if (scanner.hasNextInt()) {
                            int themeChoice = scanner.nextInt();
                            scanner.nextLine(); 
                            
                            switch (themeChoice) {
                                case 1 -> player.setSelectedTheme(GameMode.FANTASY_DUNGEON);
                                case 2 -> player.setSelectedTheme(GameMode.CYBER_HACKER);
                                case 3 -> player.setSelectedTheme(GameMode.SPACE_EXPLORER);
                                default -> System.out.println("Invalid theme choice.");
                            }
                            System.out.println("Theme updated to: " + player.getSelectedTheme() + "\n");
                        } else {
                            System.out.println("Invalid input.\n");
                            scanner.nextLine();
                        }
                        break;

                    case 3:
                        if (player == null) {
                            System.out.println("No player profile found. Create one using option 1.\n");
                        } else {
                            System.out.println("--- Player Info ---");
                            System.out.println("Player Name:    " + player.getName());
                            System.out.println("Player Level:   " + player.getLevel());
                            System.out.println("Selected Theme: " + player.getSelectedTheme() + "\n");
                        }
                        break;

                    case 4:
                        if (player == null || player.getSelectedTheme() == GameMode.NOT_SELECTED) {
                            System.out.println("Cannot start action. Ensure player is created AND a theme is selected.\n");
                        } else {
                            System.out.println("Starting action in theme: " + player.getSelectedTheme() + "!\n");
                        }
                        break;

                    case 5:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please pick between 1 and 5.\n");
                }
            } else {
                System.out.println("\nInvalid input. Please enter a number.\n");
                scanner.nextLine(); 
            }
        } while (choice != 5);

        scanner.close();
    }
}
