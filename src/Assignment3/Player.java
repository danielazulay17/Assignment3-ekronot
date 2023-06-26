package Assignment3;
public abstract class Player extends Unit {
    private int experience;
    private int playerLevel;

    public Player(char tile, Position position, String name, Health health, int attackPoints,
                  int defensePoints, int experience, int playerLevel) {
        super(tile, position, name, health, attackPoints, defensePoints);
        this.experience = 0;
        this.playerLevel = 1;
    }

    public int getExperience() {
        return experience;
    }
    public int getPlayerLevel() {
        return playerLevel;
    } 

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }


    public void levelUp()
    {
        if(this.experience == 50 * playerLevel){
            setPlayerLevel(this.playerLevel + 1);
            setExperience(this.experience - 50 * playerLevel);
            getHealth().setHealthPool(getHealth().getHealthPool() + 10 * playerLevel);
            setAttackPoints(getAttackPoints() + 4 * playerLevel);
            setDefensePoints(getDefensePoints() + 1 * playerLevel);
        }
    }
    public abstract void gameTick();
    public abstract void abilityCast();

    public void move(Tile tile){
    }
    public void move(Wall wall){ //can't move
        wall.accept(this);
    }
    public void move(Empty empty){//can move freely
        empty.accept(this);
    }
    public void move(Unit unit){
    }
    public void move(Enemy enemy, MessageCallback messageCallback ){
        enemy.accept(this, messageCallback);
    }
    public void move(Monster monster){
        monster.accept(this);
    }
    public void move(Trap trap){
        trap.accept(this);
    }
    public void accept(Unit unit){}
    public void accept(Enemy enemy){}

    @Override
    public void onDeath() {
        // remove from GameBoard
    }
}
