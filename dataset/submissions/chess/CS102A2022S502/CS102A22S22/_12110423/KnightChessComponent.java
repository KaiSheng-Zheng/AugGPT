import java.awt.*;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor){
        super(chessboardPoint,chessColor);
        if (chessColor == ChessColor.BLACK){
            this.name = 'N';
        }else {
            this.name = 'n';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
