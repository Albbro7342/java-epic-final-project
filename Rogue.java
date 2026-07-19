public class Rogue extends Player {

    private int stealthLevel;

    public Rogue(String name, int level, int health) {
        super(name, level, health); 
        this.stealthLevel = 5;      
    }

    @Override
    public void attack() {
        System.out.println(name + " slips into the shadows and executes a critical backstab from behind!");
    }

    public void upgradeStealth() {
        this.stealthLevel += 2;
        System.out.println("🎭 " + name + "'s stealth training pays off! Stealth Level is now: " + stealthLevel);
    }

    public int getStealthLevel() {
        return stealthLevel;
    }
}
