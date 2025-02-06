import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo = new ArrayList<>();
        int[][] move1 = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                ChessboardPoint newPlace = this.source.offset(move1[i][0], move1[i][1]);
                if (newPlace != null && this.chessColor != chessComponents[newPlace.getX()][newPlace.getY()].chessColor) {
                    canMoveTo.add(newPlace);
                    if (chessComponents[newPlace.getX()][newPlace.getY()].chessColor != ChessColor.NONE) {
                        break;
                    }
                    if (move1[i][0] < 0) {
                        move1[i][0]--;
                    }
                    if (move1[i][0] > 0) {
                        move1[i][0]++;
                    }
                    if (move1[i][1] < 0) {
                        move1[i][1]--;
                    }
                    if (move1[i][1] > 0) {
                        move1[i][1]++;
                    }
                } else {
                    break;
                }
            }
        }
        return canMoveTo;
    }
}