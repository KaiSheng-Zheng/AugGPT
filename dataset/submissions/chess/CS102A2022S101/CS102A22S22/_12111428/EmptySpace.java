import java.util.ArrayList;
import java.util.List;

public class EmptySpace extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }


}