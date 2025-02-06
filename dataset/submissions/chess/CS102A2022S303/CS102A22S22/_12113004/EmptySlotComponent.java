import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(int x, int y, char name) {
        super.setName(name);
        super.setChessColor(ChessColor.NONE);
        super.setSource(new ChessboardPoint(x,y));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
