import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    boolean killed;
    public KnightChessComponent(ChessColor chessColor,ChessboardPoint source)
    {
        super.chessColor=chessColor;
        super.source=source;
        if(chessColor==ChessColor.WHITE)
            super.name='n';
        else if(chessColor==ChessColor.BLACK)
            super.name='N';
    }
    public List<ChessboardPoint> canMoveTo()
    {
        return null;
    }
}
