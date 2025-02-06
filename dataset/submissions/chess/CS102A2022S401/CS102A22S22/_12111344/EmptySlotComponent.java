import java.util.List;
import java.util.ArrayList;
public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessColor chessColor,ChessboardPoint source,char name){
        super(chessColor,source,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    protected char name(){return name;}
}
