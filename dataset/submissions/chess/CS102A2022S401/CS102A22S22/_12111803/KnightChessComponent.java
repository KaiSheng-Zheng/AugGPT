import java.util.List;
import java.util.ArrayList;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public KnightChessComponent(char name) {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
