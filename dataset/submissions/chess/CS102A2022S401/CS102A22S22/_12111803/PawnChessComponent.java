import java.util.List;
import java.util.ArrayList;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public PawnChessComponent(char name) {

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}