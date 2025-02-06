import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor color){
        source = chessboardPoint;
        chessColor = color;
        if(chessColor == ChessColor.BLACK)
            name = 'B';
        else if(chessColor == ChessColor.WHITE)
            name ='b';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}