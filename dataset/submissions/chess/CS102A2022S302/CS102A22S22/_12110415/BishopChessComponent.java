import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint point, ChessColor chessColor, char name) {
        super(point, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> needToReturn = new ArrayList<>();

        for (int dx = -7; dx < 8; dx++) {
            if (super.getSource().offset(dx, dx) != null) {
                needToReturn.add(super.getSource().offset(dx, dx));
            }
        }

        while (needToReturn.contains(super.getSource())){
            needToReturn.remove(super.getSource());
        }

        return needToReturn;
    }
}
