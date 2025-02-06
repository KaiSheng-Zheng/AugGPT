import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(){
        this.name = '_';
        this.setChessColor(ChessColor.NONE);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
