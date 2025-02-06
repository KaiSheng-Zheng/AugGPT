import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(char name,ChessColor chessColor,ChessboardPoint source){
        super(name,chessColor,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    public List<ChessboardPoint>realMove(ChessComponent[][] board,ChessboardPoint source){
        return null;
    }
}
