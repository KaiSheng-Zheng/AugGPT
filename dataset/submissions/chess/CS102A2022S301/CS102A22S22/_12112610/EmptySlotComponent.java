import java.util.ArrayList;
import java.util.List;
public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(){
//        super(name ,chessColor, source,chessComponents);
//        char name, ChessColor chessColor, ChessboardPoint source,ChessComponent[][]chessComponents
    }
@Override
    public List<ChessboardPoint> canMoveTo() {
    return new ArrayList<>();
    }
}
