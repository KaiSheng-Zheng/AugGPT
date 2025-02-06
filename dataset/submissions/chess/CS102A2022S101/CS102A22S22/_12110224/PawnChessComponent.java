import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor color){
        chessColor = color;
        source = chessboardPoint;
        if (chessColor == ChessColor.BLACK)
            name = 'P';
        else if(chessColor == ChessColor.WHITE)
            name = 'p';

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}