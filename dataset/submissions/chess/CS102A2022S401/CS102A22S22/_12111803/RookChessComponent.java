import java.util.List;
import java.util.ArrayList;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public RookChessComponent(char name) {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}