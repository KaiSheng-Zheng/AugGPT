import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = super.getSource();
        this.chessColor = super.getChessColor();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
