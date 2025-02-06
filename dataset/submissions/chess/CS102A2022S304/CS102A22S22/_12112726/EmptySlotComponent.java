import java.util.Collections;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor){
        super(source, chessColor);
        super.name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return Collections.EMPTY_LIST;
    }
}
