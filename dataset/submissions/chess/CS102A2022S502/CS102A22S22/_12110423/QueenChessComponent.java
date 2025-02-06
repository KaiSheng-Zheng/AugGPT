import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor){
        super(chessboardPoint,chessColor);
        if (chessColor == ChessColor.BLACK){
            this.name = 'Q';
        }else {
            this.name = 'q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
