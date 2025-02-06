import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(int x, int y, ChessColor a, char name) {
        super.setSource(new ChessboardPoint(x,y));
        super.setChessColor(a);
        super.setName(name);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        canMoveTo.addAll(super.up(8));
        canMoveTo.addAll(super.down(8));
        canMoveTo.addAll(super.left(8));
        canMoveTo.addAll(super.right(8));
        return canMoveTo;
    }
}
