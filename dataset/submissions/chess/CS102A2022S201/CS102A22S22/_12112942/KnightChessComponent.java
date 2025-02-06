import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public ChessColor color;
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor){
        color=chessColor;
        if(color.equals(ChessColor.BLACK))
            name='N';
        else
            name='n';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
