import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public ChessColor color;
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){
        color=chessColor;
        if(color.equals(ChessColor.BLACK))
            name='B';
        else
            name='b';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
