public abstract class Tile implements Comparable<Tile> {
    protected char tile;
    protected Position position;

    public Tile (char tile, Position position)
    {
        this.tile = tile;
        this.position = position;
    }

    protected Tile(char tile){
        this.tile = tile;
    }

    protected void initialize(Position position){
        this.position = position;
    }

    public char getTile() {
        return tile;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void accept(Unit unit);

    @Override
    public int compareTo(Tile tile) {
        return getPosition().compareTo(tile.getPosition());
    }

    @Override
    public String toString() {
        return String.valueOf(tile);
    }

    public Position getCoordinates() {
        return position;
    }

    public boolean isEmpty()
    {
        if(tile == '.'){
            return true;
        }
        return false;
    }

    public boolean isWall()
    {
        if(tile == '#'){
            return true;
        }
        return false;
    }

    public boolean isPlayer()
    {
        if(tile == '@'){
            return true;
        }
        return false;
    }

    public boolean isEnemy()
    {
        if(tile == 'E'){
            return true;
        }
        return false;
    }
}



