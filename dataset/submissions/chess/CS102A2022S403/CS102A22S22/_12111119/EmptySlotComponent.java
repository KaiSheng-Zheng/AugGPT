import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint point, ChessColor color, ConcreteChessGame concreteChessGame) {
        super(point, color, concreteChessGame);
        name = '_';
    }
    @Override
    public String toString() {
        return String.valueOf(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
