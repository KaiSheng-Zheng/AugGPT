import java.util.List;
import java.util.ArrayList;
public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
