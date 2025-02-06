import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents; 
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'Q':'q';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}