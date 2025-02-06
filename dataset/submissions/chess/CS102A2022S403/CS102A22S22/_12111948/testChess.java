import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testChess {
    public static void main(String[] args) {
        ConcreteChessGame concreteChessGame = new ConcreteChessGame();
        List<String> board = new ArrayList<>();
        board.add("RN_QKBNR");
        board.add("PPPPPPPP");
        board.add("________");
        board.add("___B____");
        board.add("________");
        board.add("________");
        board.add("ppp_pppp");
        board.add("rnbqkbnr");
        board.add("w");
//        Scanner input = new Scanner(System.in);
//        for(int i = 0;i < 9;i++){
//            board.add(input.next());
//        }
        concreteChessGame.loadChessGame(board);
        List<ChessboardPoint> chessboardPoints = concreteChessGame.getCanMovePoints(new ChessboardPoint(1,1));
        for(ChessboardPoint chessboardPoint : chessboardPoints){
            System.out.println(chessboardPoint);
        }
    }
}
