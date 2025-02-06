import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(ChessboardPoint source) {
        constructor(source,ChessColor.NONE,'_');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
