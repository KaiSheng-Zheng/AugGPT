import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor){
        super(chessboardPoint,chessColor);
        if (chessColor == ChessColor.BLACK){
            this.name = 'P';
        }else {
            this.name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
