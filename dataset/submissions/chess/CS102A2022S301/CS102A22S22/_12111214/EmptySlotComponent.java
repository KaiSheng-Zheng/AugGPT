import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,'_');
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo=new ArrayList<>(){};
        return canMoveTo;
    }
}