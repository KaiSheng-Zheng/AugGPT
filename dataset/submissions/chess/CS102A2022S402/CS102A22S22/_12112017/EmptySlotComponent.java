import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{


    public EmptySlotComponent(ChessboardPoint chessboardPoint, ChessColor color, char name) {
        super(chessboardPoint, color, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
