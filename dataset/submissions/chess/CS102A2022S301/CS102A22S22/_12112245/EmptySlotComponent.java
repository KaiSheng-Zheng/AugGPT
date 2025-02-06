import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessComponent[][] chessComponents, ChessboardPoint source) {
        this.source = source;
        this.chessComponents = chessComponents;

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}