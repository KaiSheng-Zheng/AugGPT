import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor == ChessColor.BLACK){
            name = 'N';
        }else {
            name = 'n';
        }
    }
    public KnightChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint){
        super(chessColor,chessboardPoint);
        if (chessColor == ChessColor.BLACK){
            name = 'N';
        }else {
            name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> s = new ArrayList<>();
        return s;
    };
}
