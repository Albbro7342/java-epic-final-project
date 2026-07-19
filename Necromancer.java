public class Necromancer extends Player { 

    public Necromancer(String name, int level, int health) {
        super(name, level, health);
    }

    @Override
    public void attack() {
        System.out.println(name + " channels dark magic and fires a necrotic shadow bolt!");
    }
    public void raiseDead() {
        System.out.println(name + " raises a skeleton minion!");
    }
}