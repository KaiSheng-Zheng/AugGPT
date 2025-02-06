import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<>();
        int[] dx = new int[]{-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = new int[]{-1, 1, -1, 1, -2, -2, 2, 2};
        int x = getSource().getX();
        int y = getSource().getY();
        for (int i = 0; i < 8; i++) {
            if (ChessboardPoint.judge(x, y, dx[i], dy[i])
            && getChessComponents()[x + dx[i]][y + dy[i]].getChessColor() != getChessColor()) {
                ans.add(new ChessboardPoint(x + dx[i], y + dy[i]));
            }
        }
        return ans;
    }
}
