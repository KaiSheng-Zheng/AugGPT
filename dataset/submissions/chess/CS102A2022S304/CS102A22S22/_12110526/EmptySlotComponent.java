import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
}