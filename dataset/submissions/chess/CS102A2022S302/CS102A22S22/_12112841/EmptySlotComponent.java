import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint chessboardPoint,ChessColor color) {
        super(chessboardPoint,color);
        this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}