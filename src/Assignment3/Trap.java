package Assignment3;
import java.util.Random;
public class Trap extends Enemy{

    private int visibilityTime;
    private int invisibilityTime;
    private int ticksCount;
    private boolean visible;

    public Trap(char tile, Position position, String name, Health health, int attackPoints,
                   int defensePoints, int experienceValue, int visibilityTime, int invisibilityTime,
                int ticksCount, boolean visible) {
        super(tile, position, name, health, attackPoints, defensePoints, experienceValue);
        this.visibilityTime = invisibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.ticksCount = 0;
        this.visible = true;
    }

    public int getInvisibilityTime() {
        return invisibilityTime;
    }

    public int getTicksCount() {
        return ticksCount;
    }

    public void setTicksCount(int ticksCount) {
        this.ticksCount = ticksCount;
    }

    public int getVisibilityTime() {
        return visibilityTime;
    }

    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible){
        this.visible = visible;
    }

    public void onEnemyTurn(Player player) {
        visible = ticksCount < visibilityTime;

        if (ticksCount == (visibilityTime + invisibilityTime)) {
            ticksCount = 0;
        } else {
            ticksCount++;
        }
        // Attack the player if within range
        if (getPosition().range(player.getPosition()) < 2) {
            attack(player);
        }
    }
    public void accept(Player player){
        Random rand = new Random();
        int attackRoll = rand.nextInt(player.getAttackPoints());
        int defenseRoll = rand.nextInt(this.getDefensePoints());
        if((attackRoll - defenseRoll) > 0){
            this.getHealth().setHealthAmount(getHealth().getHealthAmount()-attackRoll);
            if(getHealth().getHealthAmount() <= 0){ //The Enemy died
                player.setExperience(player.getExperience() + this.getExperienceValue());
                player.setPosition(this.getPosition());
                //add remove function from GameBoard class (callBack)
            }
        }else player.setTile('X'); //game ends


    }

    @Override
    public void onDeath() {
        super.onDeath();
    }
}
