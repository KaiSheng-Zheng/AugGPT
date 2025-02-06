import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private static final int ID = 4;

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>(15);
        ChessboardPoint point = getSource();
        int x = point.getX();
        int y = point.getY();
        while (true) {
            if (!addToList(++x, ++y, list))
                break;
        }
        x = point.getX();
        y = point.getY();
        while (true) {
            if (!addToList(--x, ++y, list))
                break;
        }
        x = point.getX();
        y = point.getY();
        while (true) {
            if (!addToList(++x, --y, list))
                break;
        }
        x = point.getX();
        y = point.getY();
        while (true) {
            if (!addToList(--x, --y, list))
                break;
        }
        return list;
    }
}
