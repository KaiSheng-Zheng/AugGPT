import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public ChessColor color;
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
        color=chessColor;
        if(color.equals(ChessColor.BLACK))
            name='P';
        else
            name='p';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
