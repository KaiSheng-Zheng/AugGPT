import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public ChessColor color;
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor){
        color=chessColor;
        if(color.equals(ChessColor.BLACK))
            name='Q';
        else
            name='q';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
