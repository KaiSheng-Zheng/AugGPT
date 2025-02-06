import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(int x, int y, ChessColor a, char name) {
        super.setSource(new ChessboardPoint(x,y));
        super.setChessColor(a);
        super.setName(name);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        canMoveTo.addAll(super.up(8));
        canMoveTo.addAll(super.down(8));
        canMoveTo.addAll(super.left(8));
        canMoveTo.addAll(super.right(8));
        canMoveTo.addAll(super.leftUp(8));
        canMoveTo.addAll(super.leftDown(8));
        canMoveTo.addAll(super.rightUp(8));
        canMoveTo.addAll(super.rightDown(8));
        return canMoveTo;

    }

}
