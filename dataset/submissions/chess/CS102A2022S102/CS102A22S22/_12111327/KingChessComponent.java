import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private static final int ID = 1;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>(8);
        ChessboardPoint point = getSource();
        int x = point.getX();
        int y = point.getY();
        addToList(x + 1, y, list);
        addToList(x - 1, y, list);
        addToList(x, y + 1, list);
        addToList(x, y - 1, list);
        addToList(x + 1, y + 1, list);
        addToList(x + 1, y - 1, list);
        addToList(x - 1, y + 1, list);
        addToList(x - 1, y - 1, list);
        return list;
    }
}
