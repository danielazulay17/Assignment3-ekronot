package Assignment3;
public class Warrior extends Player{

    private int abilityCooldown;
    private int remainingCooldown;

    public Warrior(char tile, Position position, String name, Health health,
                  int attackPoints, int defensePoints, int experience, int playerLevel,
                  int abilityCooldown, int remainingCooldown){
        super(tile, position, name, health, attackPoints, defensePoints, experience, playerLevel);
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = 0;
    }

    public int getAbilityCooldown(){
        return abilityCooldown;
    }

    public int getRemainingCooldown() {
        return remainingCooldown;
    }

    public void setRemainingCooldown(int remainingCooldown) {
        this.remainingCooldown = remainingCooldown;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        setRemainingCooldown(0);
        getHealth().setHealthPool(getHealth().getHealthPool() + 5 * getPlayerLevel());
        setAttackPoints(getAttackPoints() + 2 * getPlayerLevel());
        setDefensePoints(getAttackPoints() + 1 * getPlayerLevel());
    }

    @Override
    public void gameTick() {
        setRemainingCooldown(getRemainingCooldown()-1);
    }

    @Override
    public void abilityCast() {
        if(getRemainingCooldown() <= 0){
        setRemainingCooldown(getAbilityCooldown());
        getHealth(Math.min(getHealth().getHealthAmount() + (10 * getDefensePoints()), getHealth().getHealthPool());
        // Randomly hits one enemy within range < 3 for an amount equals to 10% of the warrior’s health pool
        }
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

    @Override
    public void accept(Unit unit) {

    }
}
