import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {


    public KnightChessComponent(ChessColor color, int x, int y) {
        super.setChessColor(color);
        if (color == ChessColor.WHITE) {
            name = 'n';
        } else {
            name = 'N';
        }
        super.setSource(new ChessboardPoint(x, y));
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Chessboard.chessboard[i][j].getChessColor() != super.getChessColor()) {
                    int row = super.getSource().getX(),
                            column = super.getSource().getY();
                    if (Math.abs(i - row) + Math.abs(j - column) == 3 && i != row && j != column) {
                        list.add(Chessboard.chessboard[i][j].getSource());
                    }
                }
            }
        }
        return list;
    }
}
