import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = super.getSource();
        this.chessColor = super.getChessColor();
    }

//    public void setChess(ChessComponent[][] chessComponents) {
//        chessC = chessComponents;
//    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> point = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint canTo = new ChessboardPoint(i, j);
                if (((Math.abs(i - x) == 2 && Math.abs(j - y) == 1) || (Math.abs(i - x) == 1 && Math.abs(j - y) == 2))) {
                    if (!chessC[i][j].getChessColor().equals(chessC[x][y].getChessColor())) {
                        point.add(canTo);
                    }
                }
            }
        }
        return point;
    }
}
