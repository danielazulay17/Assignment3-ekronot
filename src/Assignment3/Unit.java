package Assignment3;
public abstract class Unit extends Tile {

    private String name;
    private Health health;
    private int attackPoints;
    private int defensePoints;



    protected Unit(char tile, Position position, String name, Health health, int attackPoints, int defensePoints) {
        super(tile,position);
        this.name = name;
        this.health = health;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
    }
    protected String getName() {
        return name;
    }
    protected void setName(String name){
        this.name=name;
    }

    protected int getAttackPoints(){
		return attackPoints;
    }
    protected int getDefensePoints(){
        return defensePoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(int healthPool, int healthAmount) {
        health.setHealthPool(healthPool);
        health.setHealthAmount(healthAmount);
    }


    // Should be automatically called once the unit finishes its turn
    public abstract void processStep();

    // What happens when the unit dies
    public abstract void onDeath();

    // This unit attempts to interact with another tile.
    public void interact(Tile tile){
        //if wall - error
        //if empty - visit(empty)
        //...
    }

    public void visit(Empty e){
        this.setPosition(e.getPosition());
    }

    public abstract void visit(Player p);
    public abstract void visit(Enemy e);
    // Combat against another unit.
    protected void battle(Unit u){
        //from Enemy accept(player)
    }

    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth(), getAttackPoints(), getDefensePoints());
    }

}
