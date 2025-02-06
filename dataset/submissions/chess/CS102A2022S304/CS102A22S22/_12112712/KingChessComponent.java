import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor == ChessColor.BLACK){
            name = 'K';
        }else {
            name = 'k';
        }
    }
    public KingChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint){
        super(chessColor,chessboardPoint);
        if (chessColor == ChessColor.BLACK){
            name = 'K';
        }else {
            name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();

        return new ArrayList<ChessboardPoint>();
    };
}
