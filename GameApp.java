import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player user = null;
        boolean active = true;

        System.out.println("🏰 Welcome to the Kingdom Hub 🏰");
 
        while (user == null) {
            System.out.println("\nSelect your Class:");
            System.out.println("1. Necromancer (Dark Magic)");
            System.out.println("2. Rogue (Shadow Dagger)");
            System.out.print("Enter choice (1-2): ");

            if (!scanner.hasNextInt()) {
                System.out.println("⚠️ Invalid entry. Please enter a valid number configuration.");
                scanner.next(); 
                continue;
            }

            int classChoice = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter your character's name: ");
            String name = scanner.nextLine();

            if (classChoice == 1) {
                user = new Necromancer(name, 1, 100);
                System.out.println("\n🔮 A dark presence awakens... Welcome, Necromancer " + name + "!");
            } else if (classChoice == 2) {
                user = new Rogue(name, 1, 100);
                System.out.println("\n🎭 Shadows embrace you... Welcome, Rogue " + name + "!");
            } else {
                System.out.println("❌ Choice out of bounds. Pick 1 or 2.");
            }
        }

        while (active) {
            System.out.println("\n--- ACTIONS MENU ---");
            System.out.println("1. Send on an Easy Mission (Clear the Crypts)");
            System.out.println("2. Send on a Hard Mission (Slay the Dragon)");
            System.out.println("3. Execute Class Attack");
            System.out.println("4. Train Specialized Class Behavior");
            System.out.println("5. Rest at Tavern (+30 Health / Costs 10 Gold)");
            System.out.println("6. Check Player Roster & Stats");
            System.out.println("7. Quit Game");
            System.out.print("Enter selection number: ");

            if (!scanner.hasNextInt()) {
                System.out.println("⚠️ Invalid entry. Please enter a valid number configuration.");
                scanner.next(); 
                continue;
            }

            int selection = scanner.nextInt();

            switch (selection) {
                case 1 -> MissionSystem.runMission(user, 1);
                case 2 -> MissionSystem.runMission(user, 2);
                case 3 -> user.attack(); 
                case 4 -> {
                    if (user instanceof Necromancer) {
                        ((Necromancer) user).raiseDead(); 
                    } else if (user instanceof Rogue) {
                        ((Rogue) user).upgradeStealth();  
                    }
                }
                case 5 -> {
                    if (user.gold >= 10) {
                        user.gold -= 10;
                        user.modifyHealth(30);
                        System.out.println("🍺 " + user.getName() + " rests up. Health restored! Total Health: " + user.getHealth());
                    } else {
                        System.out.println("❌ Not enough gold to pay the barkeep!");
                    }
                }
                case 6 -> user.displayStats();
                case 7 -> {
                    System.out.println("Saving game state variables... Goodbye!");
                    active = false;
                }
                default -> System.out.println("❌ Menu choice out of bounds. Try an option from 1-7.");
            }
        }
        scanner.close();
    }
}
