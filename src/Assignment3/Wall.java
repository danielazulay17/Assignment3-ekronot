package Assignment3;
public class Wall extends Tile{

    public Wall(char tile, Position position) {
        super(tile, position);
    }

    @Override
    public void accept(Unit unit) {

    }

    public void accept(Player player) {
        player.setPosition(player.getPosition());
    }
}
