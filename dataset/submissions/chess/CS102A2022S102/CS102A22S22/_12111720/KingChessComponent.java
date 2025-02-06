import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(char name) {
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movablePoints = new ArrayList<>();
        int row = this.getSource().getX(), col = this.getSource().getY();

        return movablePoints;
    }
}
