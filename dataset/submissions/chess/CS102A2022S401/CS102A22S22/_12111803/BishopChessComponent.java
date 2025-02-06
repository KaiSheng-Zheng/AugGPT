import java.util.List;
import java.util.ArrayList;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public BishopChessComponent(char name) {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
