package Assignment3;
import java.util.Scanner;

public interface MessageCallback {
    void send(String s);
}
interface InputReader {
    String read();
}
class CLI {
    private MessageCallback m;
    private InputReader r;

    public CLI() {

        m = (S) -> displayMessage;
        r = () -> readLine();
    }

    private void displayMessage(String m) {
        System.out.println(m);
    }

    private String readLine() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public Player getPlayer() {
        System.out.println("Select a player");
        TileFactory players = new TileFactory();
        players.printPlayers();
        int i = Integer.parseInt(r.read());  // Read the user's selection
        Player p = players.getPlayer(i);
        p.initialize(m, r);
        return p;

    }

}