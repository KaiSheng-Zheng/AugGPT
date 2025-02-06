import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source) {
        super(ChessColor.NONE, source,'_');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
            return new ArrayList<>();
        }
    }