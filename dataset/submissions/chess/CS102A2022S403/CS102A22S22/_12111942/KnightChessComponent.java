import java.util.List;
public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public KnightChessComponent(ChessColor chesscolor) {
        this.chessColor=chesscolor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}