import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = super.getSource();
        this.chessColor = super.getChessColor();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> point = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint canTo = new ChessboardPoint(i, j);
                if (j - y == 1 && i == x) {
                    if (chessC[x][j] instanceof EmptySlotComponent) {
                        point.add(canTo);
                    }
                }
                if (j - y == 2 && i == x) {
                    if (chessC[x][j] instanceof EmptySlotComponent && chessC[x][j - 1] instanceof EmptySlotComponent) {
                        point.add(canTo);
                    }
                }
                if (j - y == 1 && Math.abs(i - x) == 1) {
                    if (!chessC[i][j].getChessColor().equals(chessC[x][y].getChessColor())) {
                        point.add(canTo);
                    }
                }
            }
        }
        return point;
    }
}
