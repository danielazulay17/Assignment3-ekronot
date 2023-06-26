package Assignment3;
public abstract class Tile implements Comparable<Tile> {

    protected char tile;
    protected Position position;

    public Tile (char tile, Position position)
    {
        this.tile = tile;
        this.position = position;
    }

    protected void setTile(char tile){
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
    public int range(Unit p1, Unit p2) {
       int p1X=p1.getPosition().getX();
       int p1Y = p1.getPosition().getY();
       int p2X = p2.getPosition().getX();
       int p2Y = p2.getPosition().getY();
       double range = Math.sqrt(Math.pow((p2Y-p1Y),2) + Math.pow((p2X-p1X),2));
       return (int)range;
    }
    public int range(Position position, Unit p2) {
        int p1X=position.getX();
        int p1Y = position.getY();
        int p2X = p2.getPosition().getX();
        int p2Y = p2.getPosition().getY();
        double range = Math.sqrt(Math.pow((p2Y-p1Y),2) + Math.pow((p2X-p1X),2));
        return (int)range;
    }
    public int range (int pX, int pY, int eX, int eY){
        double range = Math.sqrt(Math.pow((eY-pY),2) + Math.pow((eX-pX),2));
        return (int)range;
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



