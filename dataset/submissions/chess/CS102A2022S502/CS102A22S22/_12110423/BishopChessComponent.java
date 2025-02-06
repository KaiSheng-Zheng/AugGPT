import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor){
        super(chessboardPoint,chessColor);
        if (chessColor == ChessColor.BLACK){
            this.name = 'B';
        }else {
            this.name = 'b';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
