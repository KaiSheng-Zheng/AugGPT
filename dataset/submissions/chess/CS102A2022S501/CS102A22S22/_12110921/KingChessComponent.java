import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public final int level=5;
    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name){
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}