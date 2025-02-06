import java.util.List;
public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public QueenChessComponent(ChessColor chesscolor) {
        this.chessColor=chesscolor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
