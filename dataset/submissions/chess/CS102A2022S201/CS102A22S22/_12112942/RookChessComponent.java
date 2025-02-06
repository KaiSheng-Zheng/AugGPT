import java.util.List;

public class RookChessComponent extends ChessComponent {
    public ChessColor color;
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor){
        color=chessColor;
        if(color.equals(ChessColor.BLACK))
            name='R';
        else
            name='r';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
