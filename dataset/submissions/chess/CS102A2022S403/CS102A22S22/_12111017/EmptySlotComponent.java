import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(){
        super.name = '_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
