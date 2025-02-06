import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent() {
    }

    public EmptySlotComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, char name,ConcreteChessGame chessGame) {
        super(chessColor, chessboardPoint, name,chessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
