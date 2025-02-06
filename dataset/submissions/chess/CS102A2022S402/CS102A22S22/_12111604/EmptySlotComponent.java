import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent( ChessboardPoint source, ChessColor chessColor, char name) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
