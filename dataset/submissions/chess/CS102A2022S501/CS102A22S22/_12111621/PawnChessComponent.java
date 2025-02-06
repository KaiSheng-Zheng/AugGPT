import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent{
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] chessComponents;
    private ChessboardPoint source;
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public ChessboardPoint getSource() {
        return source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
}
