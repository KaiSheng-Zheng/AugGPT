import java.util.ArrayList;
import java.util.List;

public class EmptySlotChessComponent extends ChessComponent {
    public EmptySlotChessComponent() {
    }

    public EmptySlotChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<ChessboardPoint>();
    }
}
