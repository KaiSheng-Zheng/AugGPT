import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> E = new ArrayList<>();
        return E;
    }

    public EmptySlotComponent( ChessboardPoint source,ChessColor chessColor,char name) {
        super(source,ChessColor.NONE, name);
    }
}
