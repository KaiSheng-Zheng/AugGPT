import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public final int level=2;
    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name){this.name=name;}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}