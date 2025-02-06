import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent() {}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoint =new ArrayList<>();
        return canMovePoint;
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}
