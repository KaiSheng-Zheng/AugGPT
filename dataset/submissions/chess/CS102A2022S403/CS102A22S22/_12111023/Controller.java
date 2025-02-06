import java.util.ArrayList;
import java.util.Scanner;
public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> s = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            s.add("RNBQK___");
        }
        s.add("w");
        ConcreteChessGame a = new ConcreteChessGame();
        a.loadChessGame(s);
        System.out.println(a.getChessboardGraph());
        ChessComponent o = new KingChessComponent(0,1,ChessColor.BALCK,'K');
        System.out.println(o.canMoveTo());
    }
}
