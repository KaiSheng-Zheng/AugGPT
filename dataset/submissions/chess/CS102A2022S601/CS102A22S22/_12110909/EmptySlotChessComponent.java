import java.util.ArrayList;
import java.util.List;

public class EmptySlotChessComponent extends ChessComponent{
    public EmptySlotChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public String toString(){
        return "_";
    }
}
