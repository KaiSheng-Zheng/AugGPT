import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        super.name='_';
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessboard) {
        super(source, chessColor, chessboard);
        super.name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}