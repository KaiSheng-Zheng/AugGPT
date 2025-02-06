import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source) {
        this.setChessColor(ChessColor.NONE);
        this.setSource(source);
        this.name='_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<ChessboardPoint>();
    }
}