import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor color) {
        name = c;
        setChessColor(color);
        setSource(chessboardPoint);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessColor color = getChessColor();
        List<ChessboardPoint> list = new ArrayList<>();


        return list;
    }

}
