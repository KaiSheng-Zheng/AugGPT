import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.name=name;
        this.setChessColor(chessColor);
        this.setSource(source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
