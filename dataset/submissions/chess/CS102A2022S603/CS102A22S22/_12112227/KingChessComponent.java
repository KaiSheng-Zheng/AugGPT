import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo = new ArrayList<>();
        int[][] move = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < 8; i++) {
            ChessboardPoint newPlace = this.source.offset(move[i][0], move[i][1]);
            if (newPlace != null && this.chessColor != chessComponents[newPlace.getX()][newPlace.getY()].chessColor) {
                canMoveTo.add(newPlace);
            }
        }
        return canMoveTo;
    }
}