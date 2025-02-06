import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(int x, int y,ChessColor a, char name) {
        super.setSource(new ChessboardPoint(x,y));
        super.setChessColor(a);
        super.setName(name);
    }

    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
}
