import java.util.List;

public class BishopChessComponent extends ChessComponent {
    boolean killed;
    public BishopChessComponent(ChessColor chessColor,ChessboardPoint source)
    {
        super.chessColor=chessColor;
        super.source=source;
        if(chessColor==ChessColor.WHITE)
            super.name='b';
        else if(chessColor==ChessColor.BLACK)
            super.name='B';

    }
    public List<ChessboardPoint> canMoveTo()
    {
        return null;
    }


}
