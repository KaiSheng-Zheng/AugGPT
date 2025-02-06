import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents; 
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'P':'p';
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
