import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();

        List<ChessboardPoint> points = new ArrayList<>();

        boolean flag = false;
        for (int i = y + 1; i < 8; i++) {
            ChessboardPoint dst = new ChessboardPoint(x, i);
            if (isEmptyChess(dst)) {
                points.add(dst);
            } else if (!flag && isOpposite(getSource(), dst)) {
                points.add(dst);
                flag = true;
                break;
            } else {
                break;
            }
        }

        flag = false;
        for (int i = y - 1; i >= 0; i--) {
            ChessboardPoint dst = new ChessboardPoint(x, i);
            if (isEmptyChess(dst)) {
                points.add(dst);
            }  if (!flag && isOpposite(getSource(), dst)) {
                points.add(dst);
                flag = true;
                break;
            } else {
                break;
            }
        }


        flag = false;
        for (int i = x + 1; i < 8; i++) {
            ChessboardPoint dst = new ChessboardPoint(i, y);
            if (isEmptyChess(dst)) {
                points.add(dst);
            } else if (!flag && isOpposite(getSource(), dst)) {
                points.add(dst);
                flag = true;
                break;
            } else {
                break;
            }
        }
        flag = false;
        for (int i = x - 1; i >= 0; i--) {
            ChessboardPoint dst = new ChessboardPoint(i, y);
            if (isEmptyChess(dst)) {
                points.add(dst);
            } else if (!flag && isOpposite(getSource(), dst)) {
                points.add(dst);
                flag = true;
                break;
            } else {
                break;
            }
        }


        return points;
    }
}
