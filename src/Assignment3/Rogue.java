package Assignment3;
import java.util.function.Supplier;

public class Rogue extends Player{

    private int cost;
    private int currentEnergy;

    public Rogue(char tile, Position position, String name, Health health, int attackPoints,
                 int defensePoints, int experience, int playerLevel,int cost, int currentEnergy){
        super(tile, position, name, health, attackPoints, defensePoints, experience, playerLevel);
        this.cost = cost ;
        this.currentEnergy = 100;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        setCurrentEnergy(100);
        setAttackPoints(getAttackPoints() + (3*getPlayerLevel()));
    }
    @Override
    public void gameTick() {
        setCurrentEnergy(Math.min(getCurrentEnergy() + 10, 100));
    }
    @Override
    public void abilityCast() {
        setCurrentEnergy(getCurrentEnergy() - getCost());
        for (Supplier<Enemy> enemySupplier : enemiesMap.values()) {
            Enemy enemy = enemySupplier.get();
            int distance = range(this.getPosition(), enemy);
            if (distance < 2) {
                int damage = getAttackPoints();
                enemy.setDefensePoints(damage);
                // Assuming there is a defend method in the Enemy class to handle defense logic
            }
            }
        }

    }

    @Override
    public void accept(Unit unit) {

    }

    @Override
    public void processStep() {

    }

    @Override
    public void onDeath() {
    super.onDeath();
    }

    @Override
    public void visit(Player p) {

    }

    @Override
    public void visit(Enemy e) {

    }
}
