import java.util.Collections;
import java.util.List;

public  class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint point, ChessColor color) {
        super(point,color);
        this.name = '_';
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return Collections.emptyList();
    }
}