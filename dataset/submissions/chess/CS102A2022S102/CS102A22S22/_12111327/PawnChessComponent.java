import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private static final int ID = 6;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>(23);
        ChessboardPoint point = getSource();
        int x = point.getX();
        int y = point.getY();
        int forward = getChessColor().equals(ChessColor.WHITE) ? -1 : 1;
        addToList(x, y + forward, list);
        addToList(x + 1, y + forward, list);
        addToList(x - 1, y + forward, list);
        if (y == 6 && forward == -1)
            addToList(x, y + 2 * forward, list);
        if (y == 1 && forward == 1)
            addToList(x, y + 2 * forward, list);
        return list;
    }
}
