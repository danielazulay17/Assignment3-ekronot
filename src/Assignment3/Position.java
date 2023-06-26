package Assignment3;
public class Position {

    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX (int x){
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int compareTo(Position position) {
        return 1;
    }

    public static Position at(int x, int y){
        Position pos = new Position(x, y);
            return pos;
    }

}


