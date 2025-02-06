import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public final int level=0;
    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name){this.name=name;}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}