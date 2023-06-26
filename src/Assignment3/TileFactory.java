package Assignment3;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TileFactory {
    private List<Supplier<Player>> playersList;
    private Map<Character, Supplier<Enemy>> enemiesMap;
    private Player selected;

    public TileFactory(){
        playersList = initPlayers();
        enemiesMap = initEnemies();
    }

    private Map<Character, Supplier<Enemy>> initEnemies() {
        List<Supplier<Enemy>> enemies = Arrays.asList(
                () -> new Monster('s',  "Lannister Solider", 80, 8, 3,25, 3),
                () -> new Monster('k', "Lannister Knight", 200, 14, 8, 50,   4),
                () -> new Monster('q', "Queen's Guard", 400, 20, 15, 100,  5),
                () -> new Monster('z', "Wright", 600, 30, 15,100, 3),
                () -> new Monster('b', "Bear-Wright", 1000, 75, 30, 250,  4),
                () -> new Monster('g', "Giant-Wright",1500, 100, 40,500,   5),
                () -> new Monster('w', "White Walker", 2000, 150, 50, 1000, 6),
                () -> new Boss('M', "The Mountain", 1000, 60, 25,  500, 6, 5),
                () -> new Boss('C', "Queen Cersei", 100, 10, 10,1000, 1, 8),
                () -> new Boss('K', "Night's King", 5000, 300, 150, 5000, 8, 3),
                () -> new Trap('B', "Bonus Trap", 1, 1, 1, 250,  1, 10),
                () -> new Trap('Q', "Queen's Trap", 250, 50, 10, 100, 3, 10),
                () -> new Trap('D', "Death Trap", 500, 100, 20, 250, 1, 10)
        );

        return enemies.stream().collect(Collectors.toMap(s -> s.get().getTile(), Function.identity()));
    }

    private List<Supplier<Player>> initPlayers() {
        return Arrays.asList(
                () -> new Warrior("Jon Snow", 300, 30, 4, 3),
                () -> new Warrior("The Hound", 400, 20, 6, 5),
                () -> new Mage("Melisandre", 100, 5, 1, 300, 30, 15, 5, 6),
                () -> new Mage("Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4),
                () -> new Rogue("Arya Stark", 150, 40, 2, 20),
                () -> new Rogue("Bronn", 250, 35, 3, 50),
                () -> new Hunter("Ygritte", 220, 30, 2, 6)
        );
    }

    public List<Player> listPlayers(){
        return playersList.stream().map(Supplier::get).collect(Collectors.toList());
    }

    public void printPlayers() {
        List<Player> players = listPlayers();
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i).getName());
        }
    }

    public Player getPlayer(int index) {
        List<Player> players = listPlayers();
        if (index >= 0 && index < players.size()) {
            return players.get(index);
        } else {
            throw new IllegalArgumentException("Invalid player index");
        }
    }

    // TODO: Add additional callbacks of your choice

    public Enemy produceEnemy(char tile, Position position, int health, int attack, int defense,
                              int visionRange, int experienceValue, int visibilityTime, int inVisibilityTime) {
        Supplier<Enemy> enemySupplier = enemiesMap.get(tile);
        if (enemySupplier != null) {
            Enemy enemy = enemySupplier.get();
            enemy.setPosition(position);
            enemy.getHealth().setHealthAmount(health);
            enemy.setAttackPoints(attack);
            enemy.setDefensePoints(defense);
            enemy.setExperienceValue(experienceValue);
            // Set any additional properties specific to the Enemy class
            enemy.setVisionRange(visionRange);
            enemy.setVisibilityTime(visibilityTime); // Set visibility time for traps
            enemy.setInVisibilityTime(inVisibilityTime); // Set invisibility time for traps
            return enemy;
        }
        return null; // or throw an exception if desired
    }

    public Player producePlayer(int idx, String name, int health, int attack, int defense) {
        Supplier<Player> playerSupplier = playersList.get(idx);
        if (playerSupplier != null) {
            Player player = playerSupplier.get();
            player.setName(name);
            player.getHealth().setHealthAmount(health);
            player.setAttackPoints(attack);
            player.setDefensePoints(defense);
            // Set any additional properties specific to the Player class
            player.setExperience(0); // Set initial experience
            player.setPlayerLevel(1); // Set initial player level
            return player;
        }
        return null; // or throw an exception if desired
    }

    public Empty produceEmpty(Position position, ...){
        ...
    }

    public Wall produceWall(Position position, ...){
        ...
    }
}