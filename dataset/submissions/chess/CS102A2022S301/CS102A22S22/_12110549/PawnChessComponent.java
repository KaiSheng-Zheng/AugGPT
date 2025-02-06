import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name) {
       
        this.name=name;
        this.source=source;
        this.chessColor=chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
    
        return null;
    }
}