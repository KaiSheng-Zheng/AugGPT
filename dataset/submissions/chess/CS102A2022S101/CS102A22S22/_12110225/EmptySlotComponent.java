import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint chessboardPoint){
        this.setSource(chessboardPoint);
    }
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<ChessboardPoint>();
    }
}
