import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public final int level=4;
    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name){
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}