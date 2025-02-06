import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();

        List<ChessboardPoint> points = new ArrayList<>();
        boolean flag;


        flag = false;
        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            ChessboardPoint dst = new ChessboardPoint(i, j);
            if (isEmptyChess(dst)) {
                points.add(dst);
            } else if (!flag && isOpposite(getSource(), dst)) {
                points.add(dst);
                flag = true;
            } else {
                break;
            }
        }

        flag = false;
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            ChessboardPoint dst = new ChessboardPoint(i, j);
            if (isEmptyChess(dst)) {
                points.add(dst);
            } else if (!flag && isOpposite(getSource(), dst)) {
                points.add(dst);
                flag = true;
            } else {
                break;
            }
        }

        flag = false;
        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            ChessboardPoint dst = new ChessboardPoint(i, j);
            if (isEmptyChess(dst)) {
                points.add(dst);
            } else if (!flag && isOpposite(getSource(), dst)) {
                points.add(dst);
                flag = true;
            } else {
                break;
            }
        }

        flag = false;
        for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
            ChessboardPoint dst = new ChessboardPoint(i, j);
            if (isEmptyChess(dst)) {
                points.add(dst);
            } else if (!flag && isOpposite(getSource(), dst)) {
                points.add(dst);
                flag = true;
            } else {
                break;
            }
        }


        return points;
    }
}
