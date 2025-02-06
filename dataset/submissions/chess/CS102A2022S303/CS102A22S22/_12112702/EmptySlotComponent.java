import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public EmptySlotComponent(int x, int y) {
        ChessboardPoint location = new ChessboardPoint(x,y);
        super.setSource(location);
        super.setChessColor(ChessColor.NONE);
        super.setName('_');
    }
}