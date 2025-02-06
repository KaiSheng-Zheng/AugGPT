import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    public EmptySlotComponent(ChessboardPoint source, ChessColor color, char name, ConcreteChessGame concreteChessGame) {
        super(source, color, name, concreteChessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
