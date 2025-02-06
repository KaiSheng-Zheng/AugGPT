import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessColor chessColor, char name, int x, int y, ChessComponent[][] chessComponents) {
        super(chessColor, name, x, y, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
