import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent() {
    }

    public EmptySlotComponent(int x, int y,ChessColor color) {
        super();
        super.setSource(new ChessboardPoint(x,y));
        super.setChessColor(ChessColor.NONE);
        name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
