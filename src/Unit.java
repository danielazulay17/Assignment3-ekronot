public abstract class Unit extends Tile {

    private String name;
    private int health;
    private int attackPoints;
    private int defensePoints;
    private MessageCallback messageCallback;


    protected Unit(char tile, Position position, String name, int health, int attackPoints, int defensePoints,
                   MessageCallback message) {
        super(tile,position);
        this.name = name;
        this.health = health;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
    }


    protected void initialize(Position position, MessageCallback messageCallback){
        setPosition(position);  // Set the initial position of the unit
        this.messageCallback = messageCallback; //  Store the messageCallback for future use
    }

    protected int getAttackPoints(){
		return attackPoints;
    }
    protected int getDefensePoints(){
        return defensePoints;
    }
    // Should be automatically called once the unit finishes its turn
    public abstract void processStep();

    // What happens when the unit dies
    public abstract void onDeath();

    // This unit attempts to interact with another tile.
    public void interact(Tile tile){
		...
    }

    public void visit(Empty e){
		...
    }

    public abstract void visit(Player p);
    public abstract void visit(Enemy e);

    // Combat against another unit.
    protected void battle(Unit u){
        ...
    }


    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth(), getAttack(), getDefense());
    }
}
