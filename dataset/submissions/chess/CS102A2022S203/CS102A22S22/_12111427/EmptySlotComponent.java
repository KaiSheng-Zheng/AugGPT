import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent() {
        super.setChessColor(ChessColor.NONE);
        super.name = '_';
    }

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
