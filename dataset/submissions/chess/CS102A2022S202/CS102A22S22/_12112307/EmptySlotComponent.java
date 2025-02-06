import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessColor chessColor,int x,int y) {
        this.name = '_';
        this.x = x;
        this.y = y;
    }

    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
}
