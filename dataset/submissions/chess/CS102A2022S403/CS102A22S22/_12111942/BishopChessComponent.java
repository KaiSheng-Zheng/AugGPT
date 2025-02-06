import java.util.List;
public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public BishopChessComponent(ChessColor chesscolor) {
        this.chessColor=chesscolor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}