import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor) {
        super(source,chessColor);
        this.chessColor = chessColor;
        this.source = source;
        if (chessColor == ChessColor.BLACK){
            name = 'Q';
        }
        if (chessColor == ChessColor.WHITE){
            name = 'q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
