import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        ChessboardPoint po = new ChessboardPoint(getSource().getX(), getSource().getY());
        ChessComponent[][] chessboard = super.chessboard;
        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = {0, -1, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < 8; i++) {
            int newx = getSource().getX() + dx[i];
            int newy = getSource().getY() + dy[i];
            if (newx <= 7 && newx >= 0 && newy <= 7 && newy >= 0) {
                if (chessboard[newx][newy].getChessColor().equals(ChessColor.NONE)) {
                    points.add(po.offset(dx[i], dy[i]));
                }
                else if(chessboard[newx][newy].getChessColor().equals(this.getChessColor())){}
                else points.add(po.offset(dx[i],dy[i]));
            }
        }
        return points;
    }
}