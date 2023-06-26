package Assignment3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameBoard implements MessageCallback {
    private List<Tile> tiles;

    public GameBoard(Tile[][] board){
        tiles = new ArrayList<>();
        for(Tile[] line : board){
            tiles.addAll(Arrays.asList(line));
        }
    }

    public boolean isValidPosition(int x, int y) {
        return getTile(x, y) != null;
    }

    public Tile getTile(int x, int y) {
        for (Tile t : tiles) {
            if (t.getPosition().equals(Position.at(x, y))) {
                return t;
            }
        }
        throw new IllegalArgumentException("No tile found at position (" + x + ", " + y + ")");
    }

    public void remove(Enemy e) {
        tiles.remove(e);
        Position p = e.getPosition();
        tiles.add(new Empty('.',p));
    }

    @Override
    public String toString() {
        tiles = tiles.stream().sorted().collect(Collectors.toList());
        // TODO: Implement me
    }

    public void send(String s, Enemy enemy) {
        if (s.equals("Enemy defeated")) {
            remove(enemy);

    }


}}