
import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    public EmptySlotComponent(ChessboardPoint point,ChessColor color,ChessComponent[][] chessComponents){
        super(point,color);
        setChessComponents(chessComponents);
    }
    @Override
    public String toString(){
        return "_";
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<ChessboardPoint>();
    }
}
