import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent  extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public EmptySlotComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
