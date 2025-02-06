import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    private ChessboardPoint source;
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public ChessboardPoint getSource() {
        return source;
    }
    public ChessComponent[][] chessComponents;
    private ChessboardPoint chessboardPoint;
    @Override
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
}
