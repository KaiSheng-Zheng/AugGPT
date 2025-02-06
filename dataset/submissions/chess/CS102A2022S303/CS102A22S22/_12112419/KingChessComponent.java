import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = super.getSource();
        this.chessColor = super.getChessColor();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> point = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint canTo = new ChessboardPoint(i, j);
                 if (!chessC[i][j].getChessColor().equals(chessC[x][y].getChessColor())) {
                    if ((Math.abs(i - x) == 1 && Math.abs(j - y) == 1) || (Math.abs(i - x) == 0 && Math.abs(j - y) == 1) || (Math.abs(i - x) == 1 && Math.abs(j - y) == 0)) {
                        point.add(canTo);
                    }
                }
            }
        }
        return point;
    }
}
