import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo = new ArrayList<>();
        int[][] move = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        for (int i = 0; i < 8; i++) {
            ChessboardPoint newPlace = getSource().offset(move[i][0], move[i][1]);
            if (newPlace != null && getChessColor() != chessComponents[newPlace.getX()][newPlace.getY()].chessColor) {
                canMoveTo.add(newPlace);
            }
        }
        return canMoveTo;
    }
}