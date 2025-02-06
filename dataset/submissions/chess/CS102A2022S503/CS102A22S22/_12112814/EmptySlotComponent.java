import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    public EmptySlotComponent(ConcreteChessGame chessGame, ChessboardPoint source, ChessColor chessColor) {
        super(chessGame, source, chessColor);
        name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}