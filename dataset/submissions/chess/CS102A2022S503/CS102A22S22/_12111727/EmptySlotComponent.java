import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        super(chessboardPoint,chessColor,name,chessComponents);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}