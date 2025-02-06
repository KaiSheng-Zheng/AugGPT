import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents; 
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'B':'b';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}