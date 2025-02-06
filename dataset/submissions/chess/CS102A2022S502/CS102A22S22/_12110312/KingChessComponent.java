import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint point, ChessColor color) {
        super(point, color);
        if (color == ChessColor.BLACK) {
            this.name = 'K';
        } else {
            this.name = 'k';
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessboardPoint source = this.getPoint();
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
        int displacementX = point.getX() - source.getX();
        int displacementY = point.getY() - source.getY();
        if (displacementX < 2 && displacementX > -2 && displacementY < 2 && displacementY > -2) {
            if (displacementX == 0 && displacementY == 0) {
                return false;
            } else if (chessBoard[point.getX()][point.getY()].getChessColor() == this.getChessColor()) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
