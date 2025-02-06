import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor color) {
        name = c;
        setChessColor(color);
        setSource(chessboardPoint);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();

        return list;
    }

}
