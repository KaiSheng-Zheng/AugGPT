import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    private final ChessboardPoint source;
    private final ChessColor chessColor;

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    public ChessColor getChessColor() {
        return this.chessColor;
    }

    public ChessboardPoint getSource() {
        return this.source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}