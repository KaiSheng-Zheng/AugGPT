import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
                if (x > i && j > y) {
                    for (int m = i + 1, n = j + 1; m < x && n < y; m++, n++) {
                        ChessboardPoint canTo = new ChessboardPoint(m, n);
                        if (chessC[m][n] instanceof EmptySlotComponent) {
                            point.add(canTo);
                        }
                        if (!chessC[m][n].getChessColor().equals(chessC[x][y].getChessColor())) {
                            point.add(canTo);
                            break;
                        }
                    }
                }
                if (x > i && j < y) {
                    for (int m = i + 1, n = y + 1; m < x && n < j; m++, n++) {
                        ChessboardPoint canTo = new ChessboardPoint(m, n);
                        if (chessC[m][n] instanceof EmptySlotComponent) {
                            point.add(canTo);
                        }
                        if (!chessC[m][n].getChessColor().equals(chessC[x][y].getChessColor())) {
                            point.add(canTo);
                            break;
                        }
                    }
                }
                if (x < i && j > y) {
                    for (int m = x + 1, n = j + 1; m < i && n < y; m++, n++) {
                        ChessboardPoint canTo = new ChessboardPoint(m, n);
                        if (chessC[m][n] instanceof EmptySlotComponent) {
                            point.add(canTo);
                        }
                        if (!chessC[m][n].getChessColor().equals(chessC[x][y].getChessColor())) {
                            point.add(canTo);
                            break;
                        }
                    }
                }
                if (x < i && j < y) {
                    for (int m = x + 1, n = y + 1; m < i && n < j; m++, n++) {
                        ChessboardPoint canTo = new ChessboardPoint(m, n);
                        if (chessC[m][n] instanceof EmptySlotComponent) {
                            point.add(canTo);
                        }
                        if (!chessC[m][n].getChessColor().equals(chessC[x][y].getChessColor())) {
                            point.add(canTo);
                            break;
                        }
                    }
                }
            }
        }
        return point;
    }
}
