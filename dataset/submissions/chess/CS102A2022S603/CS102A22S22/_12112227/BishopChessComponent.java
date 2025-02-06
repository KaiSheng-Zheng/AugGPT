import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo = new ArrayList<>();
        int[][] move = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                ChessboardPoint newPlace = this.source.offset(move[i][0], move[i][1]);
                if (newPlace != null && this.chessColor!= chessComponents[newPlace.getX()][newPlace.getY()].chessColor) {
                    canMoveTo.add(newPlace);
                    if (chessComponents[newPlace.getX()][newPlace.getY()].chessColor != ChessColor.NONE) {
                        break;
                    }
                    if (move[i][0] < 0) {
                        move[i][0]--;
                    } else {
                        move[i][0]++;
                    }
                    if (move[i][1] < 0) {
                        move[i][1]--;
                    } else {
                        move[i][1]++;
                    }

                } else {
                    break;
                }
            }
        }
        return canMoveTo;
    }
}