import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(){
        setName('_');
    }
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<ChessboardPoint>();
    }
}