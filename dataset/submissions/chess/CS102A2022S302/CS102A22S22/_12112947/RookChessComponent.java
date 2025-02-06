import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents; 
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'R':'r';
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}