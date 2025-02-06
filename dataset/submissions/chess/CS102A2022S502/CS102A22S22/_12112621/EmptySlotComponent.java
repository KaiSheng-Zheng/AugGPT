import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(int x, int y, ChessColor chessColor, char name, ChessComponent[][] chessboard) {
        super(x, y, chessColor,name,chessboard);
    }

    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }

    public boolean ableToMoveTo(ChessComponent b) {
        return false;
    }
}
