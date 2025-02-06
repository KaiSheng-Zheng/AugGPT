import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        name = chessColor == ChessColor.WHITE?'r':'R';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        int[][] Move = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        for (int i = 0; i < 4; i++) {
            ChessboardPoint aaa = source;
            while (true){
                aaa = aaa.offset(Move[i][0], Move[i][1]);
                if (aaa == null) {
                    break;
                }
                int x = aaa.getX();int y = aaa.getY();
                if (getChessColor(chessBoard[x][y].name) == chessColor) {
                    break;
                }
                moveTo.add(new ChessboardPoint(x, y));
                if (getChessColor(chessBoard[x][y].name) != ChessColor.NONE) {
                    break;
                }
            }
        }

        return moveTo;
    }

    @Override
    public String toString() {
        if(name =='r'){
            return "r";
        }else {
            return "R";
        }
    }
}
