import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name){this.name=name;}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}