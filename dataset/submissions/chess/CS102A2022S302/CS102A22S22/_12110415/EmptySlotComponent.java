import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint point){
        super(point,ChessColor.NONE,'_');
    }


    @Override
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<ChessboardPoint>();
    }
}
