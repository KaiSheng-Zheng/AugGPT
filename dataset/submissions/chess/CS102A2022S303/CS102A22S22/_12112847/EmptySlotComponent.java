import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    static char name='_';

    public EmptySlotComponent(char name, ConcreteChessGame game, ChessboardPoint source) {
        super(name, game, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
