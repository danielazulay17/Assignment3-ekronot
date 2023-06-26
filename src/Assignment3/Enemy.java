package Assignment3;
import java.util.Random;

public abstract class Enemy extends Unit {

    private int experienceValue;

    public Enemy(char tile, Position position, String name, Health health, int attackPoints,
                 int defensePoints, int experienceValue) {
        super(tile, position, name, health, attackPoints, defensePoints);
        this.experienceValue = experienceValue;
    }

    public int getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(int experienceValue) {
        this.experienceValue = experienceValue;
    }
    public void move(Tile tile){}
    public void move(Unit unit){}
    public void move(Player player){
        player.accept(this);
    }
    public void move(Wall wall){}
    public void move(Empty empty){}

    @Override
    public void accept(Unit unit) {
    }
    public void accept(Player player,MessageCallback messageCallback) {
        Random rand = new Random();
        int attackRoll = rand.nextInt(player.getAttackPoints());
        int defenseRoll = rand.nextInt(this.getDefensePoints());
        if((attackRoll - defenseRoll) > 0){
            this.getHealth().setHealthAmount(getHealth().getHealthAmount()-attackRoll);
            if(getHealth().getHealthAmount() <= 0){ //The Enemy died
                player.setExperience(player.getExperience() + this.getExperienceValue());
                player.setPosition(this.getPosition());
                messageCallback.send("Enemy defeated");
                //add remove function from GameBoard class (callBack)

            }
        }else player.setTile('X');
        //end game

    }

    @Override
    public void processStep() {
    }

    @Override
    public void onDeath() {
        // remove from GameBoard
    }

    @Override
    public void visit(Player p) {

    }

    @Override
    public void visit(Enemy e) {
    }

    public void send(String s) {
        // Handle the message sent from the enemy
        if (s.equals("Enemy defeated")) {
            // Perform the desired action when an enemy is defeated
            // For example, you can remove the enemy from the game board
            controller c = new controller();
            //enemyDeath(enemy);
        }
    }

}
