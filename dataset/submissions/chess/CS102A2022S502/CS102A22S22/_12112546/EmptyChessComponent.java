import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022/5/20 15:34
 */
public class EmptyChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
