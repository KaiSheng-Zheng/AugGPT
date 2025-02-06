import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(int i, int j, ChessColor color, char n) {
        super(i, j, color, n);
    }

    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> point = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i != x || j != y) {
                    if (chessboard[i][j].getChessColor() != this.getChessColor()) {
                        if ((Math.abs(i - x) == 1 && Math.abs(j - y) == 2) ||
                                (Math.abs(i - x) == 2 && Math.abs(j - y) == 1)) {
                            point.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        }
        return point;
    }
}
