import java.util.ArrayList;
import java.util.List;

public class HasChessComponent extends ChessComponent{
    public HasChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<ChessboardPoint>();
    }
}