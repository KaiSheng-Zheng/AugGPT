import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor){
        super(chessboardPoint,chessColor);
        if (chessColor == ChessColor.BLACK){
            this.name = 'K';
        }else {
            this.name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }

}
