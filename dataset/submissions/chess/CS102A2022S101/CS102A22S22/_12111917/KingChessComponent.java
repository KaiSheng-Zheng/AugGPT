import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponents;

    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        setChessboardPoint(chessboardPoint);
        setChessColor(chessColor);
        setName(name);
        this.chessComponents = chessComponents;

    }

    List<ChessboardPoint> lChessboardPoints = new ArrayList<>();

    @Override
    public List<ChessboardPoint> canMoveTo() {
        lChessboardPoints.clear();
        ChessboardPoint source = getChessboardPoint();
        int row = source.getX(), col = source.getY();
        int[][] delta = {{0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {-1, -1}};
        for (int[] x : delta) {
            int i = x[0], j = x[1];
            if (source.offset(i, j) != null) {
                if (chessComponents[row + i][col + j].getChessColor() != getChessColor() || chessComponents[row + i][col + j] instanceof EmptySlotComponent)
                    lChessboardPoints.add(source.offset(i, j));
            }
        }
        lChessboardPoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return lChessboardPoints;
    }
}
