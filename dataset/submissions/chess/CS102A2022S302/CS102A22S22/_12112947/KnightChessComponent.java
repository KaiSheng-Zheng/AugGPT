import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents; 
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'N':'n';
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
