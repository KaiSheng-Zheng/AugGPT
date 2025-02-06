import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    private boolean isFirstMove() {
        if (getChessColor() == ChessColor.WHITE) {
            return getSource().getX() == 6;
        } else {
            return getSource().getX() == 1;
        }
    }

    public PawnChessComponent(char name) {
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        // get current position
        ChessboardPoint currentPoint = this.getSource();

        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        // one directions
        int[] dx = {-1};
        int[] dy = {0};
        // move 2 square if it is the first move
        int distance = 1;
        if (isFirstMove()) {
            distance = 2;
        }
        // If is black then reverse direction
        if (name == 'P') {
            dx[0] = 1;
        }
        //
        for (int i = 0; i < dx.length; i++) {
            for (int d = 1; d <= distance; d++) {
                ChessboardPoint point = currentPoint.offset(dx[i] * d, dy[i] * d);
                if (point != null) {
                    int xx = point.getX();
                    int yy = point.getY();
                    if (chessComponents[xx][yy].name == '_') {
                        canMoveToPoints.add(point);
                    }
                }
            }
        }
        // capture
        // two directions
        int[] captureDx = {-1, -1};
        int[] captureDy = {-1, 1};
        // If is Black then reverse direction
        if (name == 'P') {
            captureDx[0] = 1;
            captureDx[1] = 1;
        }
        for (int i = 0; i < captureDx.length; i++) {
            ChessboardPoint point = currentPoint.offset(captureDx[i], captureDy[i]);
            if (point != null) {
                int xx = point.getX();
                int yy = point.getY();
                if (chessComponents[xx][yy].name != '_' &&
                        chessComponents[xx][yy].getChessColor() != this.getChessColor()) {
                    canMoveToPoints.add(point);
                }
            }
        }
        return canMoveToPoints;
    }
}
