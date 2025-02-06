import java.util.ArrayList;
import java.util.List;
public class EmptySlotComponent extends ChessComponent{

    public ChessComponent[][] chessComponents;
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    private ChessboardPoint source;
    public ChessboardPoint getSource() {
        return source;
    }
   @Override
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
}
