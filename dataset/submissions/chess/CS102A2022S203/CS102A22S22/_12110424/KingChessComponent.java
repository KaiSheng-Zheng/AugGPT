import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(int x, int y, ChessColor a, char name) {
        super.setSource(new ChessboardPoint(x,y));
        super.setChessColor(a);
        super.setName(name);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        canMoveTo.addAll(super.up(1));
        canMoveTo.addAll(super.down(1));
        canMoveTo.addAll(super.left(1));
        canMoveTo.addAll(super.right(1));
        canMoveTo.addAll(super.leftUp(1));
        canMoveTo.addAll(super.leftDown(1));
        canMoveTo.addAll(super.rightUp(1));
        canMoveTo.addAll(super.rightDown(1));
        return canMoveTo;
    }


}
