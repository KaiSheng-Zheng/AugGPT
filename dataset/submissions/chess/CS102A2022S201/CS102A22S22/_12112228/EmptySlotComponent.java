import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(int  x, int y  , ChessColor chessColor,char name,ChessComponent[][] e) {
        super( x, y , chessColor, name,e);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<ChessboardPoint>();
    }
}
