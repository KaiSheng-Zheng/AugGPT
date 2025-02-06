import java.util.List;
import java.util.ArrayList;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public QueenChessComponent(char name) {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}