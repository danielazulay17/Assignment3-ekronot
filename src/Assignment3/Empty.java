package Assignment3;
public class Empty extends Tile {
    public Empty(char tile, Position position) {
        super(tile, position);
    }

    @Override
    public void accept(Unit unit) {

    }

    public void accept(Player player){
        player.setPosition(this.getPosition());
    }
}
