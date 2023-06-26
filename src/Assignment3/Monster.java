package Assignment3;
import java.util.Random;

public class Monster extends Enemy implements MessageCallback{
    private int visionRange;
    public Monster(char tile, Position position, String name, Health health, int attackPoints,
                   int defensePoints, int experienceValue, int visionRange) {
        super(tile, position, name, health, attackPoints, defensePoints, experienceValue);
        this.visionRange = visionRange;
    }

    public int getVisionRange() {
        return visionRange;
    }


    public void movement(Player player, GameBoard board) {
        int playerX = player.getPosition().getX();
        int playerY = player.getPosition().getY();
        int monsterX = getPosition().getX();
        int monsterY = getPosition().getY();

        //if the monster can chase the player
        if (range(monsterX, monsterY, playerX, playerY) < visionRange) {
            int dx = monsterX - playerX;
            int dy = monsterY - playerY;

            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0) {
                    // Move left
                    if (isValidTile(board, monsterX - 1, monsterY)) {
                        setPosition(new Position(monsterX - 1, monsterY);
                    }
                } else {
                    // Movr right
                    if (isValidTile(board, monsterX + 1, monsterY)) {
                        setPosition(new Position(monsterX + 1, monsterY));
                    }
                }
            } else {
                if (dy > 0) {
                    // Move up
                    if (isValidTile(board, monsterX, monsterY - 1)) {
                        setPosition(new Position(monsterX, monsterY - 1));
                    }
                } else {
                    // Move down
                    if (isValidTile(board, monsterX, monsterY + 1)) {
                        setPosition(new Position(monsterX, monsterY + 1));
                    }
                }
            }
        } else {
            // if the monster can't chase the player
            int randomDirection = getRandomNumber(5);
            int newMonsterX = monsterX;
            int newMonsterY = monsterY;

            switch (randomDirection) {
                case 0:
                    // Move left
                    if (isValidTile(board, monsterX - 1, monsterY)) {
                        newMonsterX = monsterX - 1;
                    }
                    break;
                case 1:
                    // Move right
                    if (isValidTile(board, monsterX + 1, monsterY)) {
                        newMonsterX = monsterX + 1;
                    }
                    break;
                case 2:
                    // Move up
                    if (isValidTile(board, monsterX, monsterY - 1)) {
                        newMonsterY = monsterY - 1;
                    }
                    break;
                case 3:
                    // Move down
                    if (isValidTile(board, monsterX, monsterY + 1)) {
                        newMonsterY = monsterY + 1;
                    }
                    break;
                // case 4: Stay in the same place (no movement)

                default:
                    break;
            }

            setPosition(new Position(newMonsterX, newMonsterY));
        }
    }
    private int getRandomNumber(int i) {
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        return randomNumber;
    }
    private boolean isValidTile(GameBoard board, int x, int y) {
        return board.isValidPosition(x, y) && board.getTile(x, y).isEmpty();
    }
    public void accept(Player player, MessageCallback messageCallback){
        Random rand = new Random();
        int attackRoll = rand.nextInt(player.getAttackPoints());
        int defenseRoll = rand.nextInt(this.getDefensePoints());
        if((attackRoll - defenseRoll) > 0){
            this.getHealth().setHealthAmount(getHealth().getHealthAmount()-attackRoll);
            if(getHealth().getHealthAmount() <= 0){ //The Enemy died
                player.setExperience(player.getExperience() + this.getExperienceValue());
                player.setPosition(this.getPosition());
                messageCallback.send("Enemy defeated"); //notify the game board

            }
        } else player.setTile('X'); //game end

    }

    @Override
    public void onDeath() {
        super.onDeath();
    }

    @Override
    public void send(String s) {

    }

}
