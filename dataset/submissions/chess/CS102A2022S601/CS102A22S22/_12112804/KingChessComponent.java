import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    boolean killed;
    public KingChessComponent(ChessColor chessColor,ChessboardPoint source)
    {
        super.chessColor=chessColor;
        super.source=source;
        if(chessColor==ChessColor.WHITE)
            super.name='k';
        else if(chessColor==ChessColor.BLACK)
            super.name='K';
    }
    public List<ChessboardPoint> canMoveTo()
    {
        List<ChessboardPoint> points=new ArrayList<>();
        for (int i = source.getX()-1; i < source.getX()+2; i++) {
            for (int j = source.getY()-1; j < source.getY()+2; j++) {
                if(j<0||j>7||i<0||i>7)
                {
                    ;
                }
                else if(chessBoard[i][j].getChessColor()!=chessColor)
                    points.add(new ChessboardPoint(i,j));
            }
        }
        return points;
    }
}
