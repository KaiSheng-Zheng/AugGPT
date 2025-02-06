import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    public EmptySlotComponent(ChessboardPoint chessboardPoint, ChessColor color) {
        this.setChessColor(color);
        this.setSource(chessboardPoint);
        this.name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
