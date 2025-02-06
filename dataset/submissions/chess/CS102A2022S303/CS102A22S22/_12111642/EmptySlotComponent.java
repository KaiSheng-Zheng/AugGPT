import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessColor color,int x,int y,ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
        setSource(new ChessboardPoint(x,y));
        setChessColor(color);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    @Override
    public String toString(){
            return String.valueOf('_');
    }
}