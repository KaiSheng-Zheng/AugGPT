import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint point, ChessColor color) {
        super(point, color);
        if (color == ChessColor.BLACK) {
            this.name = 'N';
        } else {
            this.name = 'n';
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.canMoveTo(new ChessboardPoint(i, j))) {
                    canMoveTo.add(new ChessboardPoint(i, j));
                }
            }
        }
        return canMoveTo;
    }

    public boolean canMoveTo(ChessboardPoint point) {
        ChessboardPoint source = this.getPoint();
        if (point.getX() == source.getX() + 2 || point.getX() == source.getX() - 2) {
            if (point.getY() == source.getY() + 1 || point.getY() == source.getY() - 1) {
                if (chessBoard[point.getX()][point.getY()].getChessColor() != this.getChessColor()) {
                    return true;
                }
            }
        } else if (point.getY() == source.getY() + 2 || point.getY() == source.getY() - 2) {
            if (point.getX() == source.getX() + 1 || point.getX() == source.getX() - 1) {
                if (chessBoard[point.getX()][point.getY()].getChessColor() != this.getChessColor()) {
                    return true;
                }
            }
        }
        return false;
    }
}
