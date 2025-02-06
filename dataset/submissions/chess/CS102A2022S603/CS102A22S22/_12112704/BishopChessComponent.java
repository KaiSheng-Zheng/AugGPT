import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(char name) {
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        // get current position
        ChessboardPoint currentPoint = this.getSource();

        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        // four directions
        int[] dx = {1, -1, 1, -1};
        int[] dy = {-1, 1, 1, -1};
        for (int i = 0; i < dx.length; i++) {
            for (int distance = 1; distance <= 8; distance++) {
                ChessboardPoint point = currentPoint.offset(dx[i] * distance, dy[i] * distance);
                if (point != null) {
                    int x = point.getX();
                    int y = point.getY();
                    if (chessComponents[x][y].name == '_') {
                        canMoveToPoints.add(point);
                    } else if (chessComponents[x][y].getChessColor() != this.getChessColor()) {
                        canMoveToPoints.add(point);
                        break;
                    } else if (chessComponents[x][y].getChessColor() == this.getChessColor()) {
                        break;
                    }
                }
            }
        }
        return canMoveToPoints;
    }
}
