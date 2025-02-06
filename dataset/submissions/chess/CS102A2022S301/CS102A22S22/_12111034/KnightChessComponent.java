import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveToPoint = new ArrayList<>();
        ConcreteChessGame knight = new ConcreteChessGame();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean k1 = getSource().getX() == i - 1 && (getSource().getY() == j - 2 || getSource().getY() == j + 2);
                boolean k2 = getSource().getX() == i - 2 && (getSource().getY() == j - 1 || getSource().getY() == j + 1);
                boolean k3 = getSource().getX() == i + 1 && (getSource().getY() == j - 2 || getSource().getY() == j + 2);
                boolean k4 = getSource().getX() == i + 2 && (getSource().getY() == j - 1 || getSource().getY() == j + 1);
                if (k1) {
                    canMoveToPoint.add(new ChessboardPoint(i, j));
                } else if (k2) { // Not on the same row or the same column.
                    canMoveToPoint.add(new ChessboardPoint(i, j));
                } else if (k3) {
                    canMoveToPoint.add(new ChessboardPoint(i, j));
                } else if (k4) {
                    canMoveToPoint.add(new ChessboardPoint(i, j));
                }
                canMoveToPoint.add(new ChessboardPoint(i, j));
            }
        }return canMoveToPoint;
    }
}
