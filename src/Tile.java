public class Tile {

    private char tile;
    private Coordinates coordinates;

    public Tile (char tile, Coordinates coordinates)
    {
        this.tile = tile;
        this.coordinates = coordinates;
    }

    public char getTile() {
        return tile;
    }

    public Coordinates getCoordinates() {
        return coordinates;
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
