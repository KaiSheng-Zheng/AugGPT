import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int[] dx = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = new int[]{0, 0, -1, 1, -1, -1, 1, 1};
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> ans = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if ((xx >= 0 && xx <= 7) && (yy >= 0 && yy <= 7)
            && getChessComponents()[x + dx[i]][y + dy[i]].getChessColor() != getChessColor()) {
                ans.add(new ChessboardPoint(xx, yy));
            }
        }
        return ans;
    }
}
