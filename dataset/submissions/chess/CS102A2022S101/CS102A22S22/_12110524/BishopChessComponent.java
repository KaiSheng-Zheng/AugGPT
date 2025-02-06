import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(boolean color, int x, int y) {
        this.name = color ? 'B' : 'b';
        this.setSource(new ChessboardPoint(x, y));
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList list = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX(), y = this.getSource().getY(), dx, dy;
        int[] mx = {1, 1, -1, -1}, my = {1, -1, -1, 1};
        for (int i = 0; i <= 3; i++){
            dx = x;
            dy = y;
            while (true) {
                dx += mx[i];
                dy += my[i];
                if (dx < 0 || dx >7 || dy < 0 || dy > 7) break;
                ChessComponent target = board[dx][dy];
                if (target.name != '_' && Character.isUpperCase(target.name) == Character.isUpperCase(this.name)) break;
                list.add(new ChessboardPoint(dx, dy));
                if (target.name != '_') break;
            }
        }
        return list;
    }
}