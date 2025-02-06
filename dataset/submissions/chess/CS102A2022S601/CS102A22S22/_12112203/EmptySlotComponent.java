import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name = '_';
    }
}
