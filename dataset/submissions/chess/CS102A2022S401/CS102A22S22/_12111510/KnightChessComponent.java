import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        super.name = chessColor == ChessColor.WHITE ? 'n' : 'N';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        int[][] Move = new int[][]{{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        ChessboardPoint aaa = source;
        for (int i = 0; i < 8; i++) {
            ChessboardPoint bbb = aaa.offset(Move[i][0], Move[i][1]);
            if (bbb != null) {
                int x = bbb.getX();
                int y = bbb.getY();
                if (getChessColor(chessBoard[x][y].name) != chessColor) {
                    moveTo.add(new ChessboardPoint(x, y));
                }
            }
        }
        return moveTo;
    }

    @Override
    public String toString() {
        if (name == 'n') {
            return "n";
        } else {
            return "N";
        }
    }
}
