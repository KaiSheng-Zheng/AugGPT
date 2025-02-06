import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(boolean color, int x, int y) {
        this.name = color ? 'K' : 'k';
        this.setSource(new ChessboardPoint(x, y));
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList list = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX(), y = this.getSource().getY(), dx, dy;
        int[] mx = {0, 1, 1, 1, 0, -1, -1, -1}, my = {1, 1, 0, -1, -1, -1, 0, 1};
        for (int i = 0; i <=7 ; i++) {
            dx = x+mx[i];
            dy = y+my[i];
            if (dx < 0 || dx >7 || dy < 0 || dy > 7) continue;
            ChessComponent target = board[dx][dy];
            if (target.name != '_' && Character.isUpperCase(target.name) == Character.isUpperCase(this.name)) continue;
            list.add(new ChessboardPoint(dx, dy));
        }
        return list;
    }
}