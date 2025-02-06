import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint point,ChessColor color,char name){
        super(point,color,name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<ChessboardPoint>();
        return ans;
    }
}
