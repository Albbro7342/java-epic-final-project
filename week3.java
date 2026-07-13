import java.util.ArrayList;
import java.util.Scanner;

class GameCharacter {
    private String name;
    private int health;

    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println(name + " takes " + damage + " damage! (Current Health: " + health + ")");
    }

    public void performAction() {
        System.out.println(name + " takes a standard action.");
    }
}

class Warrior extends GameCharacter {
    private int shieldStrength;

    public Warrior(String name, int health, int shieldStrength) {
        super(name, health);
        this.shieldStrength = shieldStrength;
    }

    @Override
    public void performAction() {
        System.out.println("[" + getName() + " - HP: " + getHealth() + "] swings a broadsword and raises a shield with " + shieldStrength + " durability!");
    }
}

class Hacker extends GameCharacter {
    private String signalType;

    public Hacker(String name, int health, String signalType) {
        super(name, health);
        this.signalType = signalType;
    }

    @Override
    public void performAction() {
        System.out.println("[" + getName() + " - HP: " + getHealth() + "] bypasses security grids using a " + signalType + " connection!");
    }
}

class Explorer extends GameCharacter {
    private boolean hasMap;

    public Explorer(String name, int health, boolean hasMap) {
        super(name, health);
        this.hasMap = hasMap;
    }

    @Override
    public void performAction() {
        if (hasMap) {
            System.out.println("[" + getName() + " - HP: " + getHealth() + "] charts a safe path through ancient ruins using a local map.");
        } else {
            System.out.println("[" + getName() + " - HP: " + getHealth() + "] searches blindly for hidden treasures.");
        }
    }
}

public class week3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        ArrayList<GameCharacter> party = new ArrayList<>(); 

        party.add(new Warrior("Thorin", 150, 50));
        party.add(new Hacker("Neo", 90, "Quantum encrypted"));
        party.add(new Explorer("Lara", 110, true));

        boolean running = true;

        while (running) {
            System.out.println("\n--- PARTY MANAGEMENT INTERFACE ---");
            System.out.println("1. Trigger Polymorphic Party Actions");
            System.out.println("2. Simulate Incoming Enemy Attack (Take Damage)");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Executing Party Actions (Polymorphism) ---");
                    for (GameCharacter member : party) {
                        member.performAction();
                    }
                    break;

                case 2:
                    System.out.println("\n--- Simulated Ambush! ---");
                    for (GameCharacter member : party) {
                        member.takeDamage(25); 
                    }
                    break;

                case 3:
                    System.out.println("Exiting application.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Select a number between 1 and 3.");
            }
        }
        scanner.close();
    }
}
