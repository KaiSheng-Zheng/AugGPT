import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class EmptySlotComponent extends ChessComponent {

    // creates a new PawnChessComponent
    public EmptySlotComponent(ChessboardPoint source) {
        super(source, ChessColor.NONE, '_');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
 
        return list;
    }

}
