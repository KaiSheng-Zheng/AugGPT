import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessComponent[][] chessComponents, ChessboardPoint source) {
        this.name = '_';
        setChessColor(ChessColor.NONE);
        setSource(source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
