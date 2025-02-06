import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(int x, int y){
        setSource(new ChessboardPoint(x,y));
        setChessColor(ChessColor.NONE);
        name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
