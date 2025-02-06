import java.util.List;

public class KingChessComponent extends ChessComponent {
    public ChessColor color;
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor){
        color=chessColor;
        if(color.equals(ChessColor.BLACK))
            name='K';
        else
            name='k';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
