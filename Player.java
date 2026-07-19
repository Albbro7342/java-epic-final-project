public class Player {
    protected String name;
    protected int level;
    protected int health;
    protected int xp;   
    protected int gold;    

    public Player(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.xp = 0;
        this.gold = 50; 
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    
    public void modifyHealth(int amount) {
        this.health += amount;
        if (this.health < 0) this.health = 0;
        if (this.health > 100) this.health = 100; 
    }

    public void reward(int xpGained, int goldGained) {
        this.xp += xpGained;
        this.gold += goldGained;
        System.out.println("✨ Rewards Earned: +" + xpGained + " XP, +" + goldGained + " Gold!");
        
        if (this.xp >= 100) {
            this.level++;
            this.xp -= 100;
            this.health = 100;
            System.out.println("🎉 LEVEL UP! " + name + " reached Level " + level + "!");
        }
    }

    public void displayStats() {
        System.out.println("\n=== " + name.toUpperCase() + " STATS ===");
        System.out.println("Level: " + level);
        System.out.println("Health: " + health + "/100");
        System.out.println("XP Progress: " + xp + "/100");
        System.out.println("Gold: " + gold);
        System.out.println("====================\n");
    }

    public void attack() {
        System.out.println(name + " strikes with a basic attack!");
    }
}
