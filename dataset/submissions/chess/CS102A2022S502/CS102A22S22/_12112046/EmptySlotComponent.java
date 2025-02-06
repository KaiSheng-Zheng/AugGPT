import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public EmptySlotComponent(){}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}
