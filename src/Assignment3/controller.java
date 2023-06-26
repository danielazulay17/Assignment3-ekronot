package Assignment3;

public class controller implements MessageCallback{

    private Player p; //model
    private Enemy e; //model
    private GameBoard gameBoard; //view

    public controller(Player p, Enemy e, GameBoard gameBoard){
        this.p = p;
        this.e = e;
        this.gameBoard = gameBoard;
    }

    @Override
    public void send(String s) {
    }

    public void enemyDeath(Enemy e){
        gameBoard.remove(e);
    }
}
