import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        // get current position
        ChessboardPoint currentPoint = this.getSource();

        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        // eight directions
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
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

    public KingChessComponent(char name) {
        this.name = name;
    }
}
