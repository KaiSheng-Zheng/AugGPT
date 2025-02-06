import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(char name) {
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        // get current position
        ChessboardPoint currentPoint = this.getSource();

        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        // eight directions
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
        for (int i = 0; i < dx.length; i++) {
            ChessboardPoint point = currentPoint.offset(dx[i], dy[i]);
            if (point != null) {
                int xx = point.getX();
                int yy = point.getY();
                if (chessComponents[xx][yy].name == '_' ||
                        chessComponents[xx][yy].getChessColor() != this.getChessColor()) {
                    canMoveToPoints.add(point);
                }
            }
        }
        return canMoveToPoints;
    }
}
