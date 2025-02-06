import java.util.ArrayList;
import java.util.List;



public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> list = new ArrayList<>();

        list.addAll(ChessboardPoint.getXYYX(x, y));
        return list;
    }
}
