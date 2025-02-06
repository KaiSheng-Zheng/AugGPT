import java.util.ArrayList;
import java.util.List;
public class Board extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
   private static ChessComponent[][] chessComponent1;
   public static void loadboard(ChessComponent[][] chessComponents){
       chessComponent1=chessComponents;
   }
    public static ChessComponent[][] getChessComponent1() {
        return chessComponent1;
    }
}
