import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        ChessboardPoint po = new ChessboardPoint(getSource().getX(), getSource().getY());
        ChessComponent[][] chessboard = super.chessboard;
        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
        for (int i = 0; i < 8; i++) {
            int newx = getSource().getX() + dx[i];
            int newy = getSource().getY() + dy[i];
            if (newx <= 7 && newx >= 0 && newy <= 7 && newy >= 0) {
                if (chessboard[newx][newy].getChessColor().equals(ChessColor.NONE)) {
                    points.add(new ChessboardPoint(newx, newy));
                }
                else if(chessboard[newx][newy].getChessColor().equals(this.getChessColor())){}
                else {
                    points.add(new ChessboardPoint(newx, newy));
                }
            }
        }
        return points;
    }
}
