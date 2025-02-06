import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{



    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> CanMove=new ArrayList<>();
        return CanMove;
    }
}
