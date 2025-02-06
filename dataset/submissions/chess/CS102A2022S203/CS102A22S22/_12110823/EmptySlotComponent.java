import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(){}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}