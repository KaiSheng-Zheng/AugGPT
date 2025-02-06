import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    public EmptySlotComponent(int x, int y) {
        this.setSource(new ChessboardPoint(x, y));
        this.setChessColor(ChessColor.NONE);
        this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<ChessboardPoint>();
    }
}
