import java.util.List;
import java.util.ArrayList;
public class KingChessComponent extends ChessComponent{
    ChessboardPoint chessboardPoint;
    ConcreteChessGame concreteChessGame;
    public KingChessComponent(){
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
