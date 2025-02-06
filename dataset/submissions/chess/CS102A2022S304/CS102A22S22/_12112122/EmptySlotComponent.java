import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessComponent[][] chessComponents){
        super(chessComponents);
        setChessColor(null);
    }

    @Override
    public String toString() {
        return "_";
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
