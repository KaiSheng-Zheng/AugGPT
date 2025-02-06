import java.util.ArrayList;
import java.util.List;

public class EmptyChessComponent extends ChessComponent{

    public EmptyChessComponent(ChessboardPoint chessboardPoint) {
        super(chessboardPoint, ChessColor.NONE, '_');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<ChessboardPoint>();
    }


}
