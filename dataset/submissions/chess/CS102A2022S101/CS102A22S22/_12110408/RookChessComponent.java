import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(int x, int y, ChessColor chessColor) {
        this.setSource(new ChessboardPoint(x, y));
        this.setChessColor(chessColor);
        this.name = chessColor.equals(ChessColor.BLACK) ? 'R' : 'r';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> availablePoints = new ArrayList<ChessboardPoint>();
        availablePoints.addAll(getAvailablePointsOfLine(1,0));
        availablePoints.addAll(getAvailablePointsOfLine(-1,0));
        availablePoints.addAll(getAvailablePointsOfLine(0,1));
        availablePoints.addAll(getAvailablePointsOfLine(0,-1));

        return availablePoints;
    }
}
