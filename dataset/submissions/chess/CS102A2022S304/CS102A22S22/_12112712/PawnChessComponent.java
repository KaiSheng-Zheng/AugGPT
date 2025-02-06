import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor chessColor){
        super(chessColor);
        if (chessColor == ChessColor.BLACK){
            name = 'P';
        }else {
            name = 'p';
        }
    }

    public PawnChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint){
        super(chessColor,chessboardPoint);
        if (chessColor == ChessColor.BLACK){
            name = 'P';
        }else {
            name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
       return new ArrayList<ChessboardPoint>();
    };
}
