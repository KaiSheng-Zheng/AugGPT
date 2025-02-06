
import java.util.ArrayList;
import java.util.List;
public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent (ChessboardPoint source, ChessColor chesscolor) {
        super(source, chesscolor);
        if (chesscolor == ChessColor.NONE) {
            this.name = '_';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>() ;
    }
    public boolean ableToMove(ChessComponent a) {
        return false;
    }
}
