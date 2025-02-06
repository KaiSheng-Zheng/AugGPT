import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(ChessboardPoint source) {
        setSource(source);
        name='_';
        setChessColor(ChessColor.NONE);
    }

    public EmptySlotComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
