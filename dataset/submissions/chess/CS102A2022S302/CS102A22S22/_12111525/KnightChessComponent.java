import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor) {
        super(source,chessColor);
        this.chessColor = chessColor;
        this.source = source;
        if (chessColor == ChessColor.BLACK){
            name = 'N';
        }
        if (chessColor == ChessColor.WHITE){
            name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
