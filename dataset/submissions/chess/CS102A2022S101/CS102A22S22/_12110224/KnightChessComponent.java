import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor color){
        source = chessboardPoint;
        chessColor = color;
        if (color == ChessColor.BLACK)
            name = 'N';
        else if (color == ChessColor.WHITE)
            name = 'n';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
