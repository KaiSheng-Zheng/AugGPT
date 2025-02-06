import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int[][] directions = new int[][]{{-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
        List<ChessboardPoint> result = new ArrayList<>();
        int bounds = 7;
        directionMove(directions, result, bounds);
        Collections.sort(result, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {

                if (o1.getX() == o2.getX()) {
                    return o1.getY() - o2.getY();
                } else {
                    return o1.getX() - o2.getX();
                }

            }
        });
        return result;
    }

    public void directionMove(int[][] directions, List<ChessboardPoint> result, int bounds) {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        for (int i = 0; i < directions.length; i++) {
            for (int j = 1; j <= bounds; j++) {
                int curX = x + directions[i][0] * j;
                int curY = y + directions[i][1] * j;
                if (curX < 0 || curX > 7 || curY < 0 || curY > 7
                        || (GetChessBoard.chessComponents[curX][curY].getChessColor().equals(getChessColor()))) {
                    break;
                }
                if (GetChessBoard.chessComponents[curX][curY].name == '_') {
                    result.add(new ChessboardPoint(curX, curY));
                    continue;
                }
                if (GetChessBoard.chessComponents[curX][curY].name != '_' &&
                        !GetChessBoard.chessComponents[curX][curY].getChessColor().equals(getChessColor())) {
                    result.add(new ChessboardPoint(curX, curY));
                    break;
                }

            }
        }
    }
}
