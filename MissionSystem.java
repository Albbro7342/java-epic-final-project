import java.util.Random;

public class MissionSystem {
    private static final Random random = new Random();

    public static void runMission(Player targetPlayer, int choice) {
        if (targetPlayer.getHealth() <= 15) {
            System.out.println("\n❌ " + targetPlayer.getName() + " is too weak! Rest or heal before attempting a mission.");
            return;
        }

        String missionName = "";
        int difficulty = 0;
        int xpReward = 0;
        int goldReward = 0;
        int penalty = 0;

        switch (choice) {
            case 1 -> {
                missionName = "Clear the Crypts";
                difficulty = 30; 
                xpReward = 25;
                goldReward = 15;
                penalty = -15;
            }
            case 2 -> {
                missionName = "Slay the Shadow Dragon";
                difficulty = 65;
                xpReward = 75;
                goldReward = 80;
                penalty = -45;
            }
            default -> {
                System.out.println("Unknown mission profile.");
                return;
            }
        }

        if (targetPlayer instanceof Rogue) {
            Rogue roguePlayer = (Rogue) targetPlayer; 
            int stealthBonus = roguePlayer.getStealthLevel();

            difficulty -= stealthBonus;
            System.out.println("🎭 [Rogue Passive Activated] Stealth Level (" + stealthBonus + ") decreases mission difficulty!");
        }

        System.out.println("\n⚔️ " + targetPlayer.getName() + " sets out on the mission: [" + missionName + "]...");
        int roll = random.nextInt(100) + 1;

        if (roll > difficulty) {
            System.out.println("✅ MISSION SUCCESS! " + targetPlayer.getName() + " triumphed against all odds. (Rolled: " + roll + " / Needed over: " + difficulty + ")");
            targetPlayer.reward(xpReward, goldReward);
        } else {
            System.out.println("💥 MISSION FAILED! " + targetPlayer.getName() + " was ambushed and forced to retreat. (Rolled: " + roll + " / Needed over: " + difficulty + ")");
            targetPlayer.modifyHealth(penalty);
            System.out.println("💔 Health lost: " + penalty + ". Current Health: " + targetPlayer.getHealth() + "/100");
        }
    }
}

