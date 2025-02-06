import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint point, ChessColor color) {
        super(point, color);
        if (color == ChessColor.BLACK) {
            this.name = 'B';
        } else {
            this.name = 'b';
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
        if ((source.getX() - point.getX()) == (source.getY() - point.getY())) {
            int row = Math.min(source.getX(), point.getX());
            int col = Math.min(source.getY(), point.getY());
            int abs = Math.abs(source.getX() - point.getX());
            for (int k = 1; k < abs; k++){
                if (!(chessBoard[row+k][col+k] instanceof EmptySlotComponent)){
                    return false;
                }
            }
        } else if ((source.getX() - point.getX()) == -(source.getY() - point.getY())) {
            int row = Math.max(source.getX(), point.getX());
            int col = Math.min(source.getY(), point.getY());
            int abs = Math.abs(source.getX() - point.getX());
            for (int k = 1; k < abs; k++){
                if (!(chessBoard[row-k][col+k] instanceof EmptySlotComponent)){
                    return false;
                }
            }
        } else {
            return false;
        }
        if (chessBoard[point.getX()][point.getY()].getChessColor() == this.getChessColor()) {
            return false;
        }
        return true;
    }
}
