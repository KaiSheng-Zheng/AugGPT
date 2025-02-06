import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
        name = chessColor == ChessColor.WHITE?'k':'K';
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        int[][] Move = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        for (int i = 0; i < 8; i++) {
            ChessboardPoint aaa = source;
                aaa = aaa.offset(Move[i][0], Move[i][1]);
                if (aaa == null) {
                    continue;
                }
                int x = aaa.getX();int y = aaa.getY();
                if (getChessColor(chessBoard[x][y].name) == chessColor) {
                    continue;
                }
                moveTo.add(new ChessboardPoint(x, y));
            }
        return moveTo;
    }


    @Override
    public String toString() {
        if(name =='k'){
            return "k";
        }else {
            return "K";
        }
    }
}
