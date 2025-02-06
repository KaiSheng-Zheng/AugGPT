import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private static final int ID = 5;

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>(23);
        ChessboardPoint point = getSource();
        int x = point.getX();
        int y = point.getY();
        addToList(x + 2, y + 1, list);
        addToList(x + 2, y - 1, list);
        addToList(x - 2, y + 1, list);
        addToList(x - 2, y - 1, list);
        addToList(x + 1, y + 2, list);
        addToList(x + 1, y - 2, list);
        addToList(x - 1, y + 2, list);
        addToList(x - 1, y - 2, list);
        return list;
    }
}
