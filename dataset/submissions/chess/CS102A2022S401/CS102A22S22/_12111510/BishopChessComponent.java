import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
       name = chessColor == ChessColor.WHITE?'b':'B';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        ChessboardPoint aaa1 = source;
        int[][] Move = new int[][]{{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        for (int i = 0; i < 4; i++) {
            ChessboardPoint aaa = aaa1;
            while (true){
                aaa = aaa.offset(Move[i][0], Move[i][1]);
                if (aaa != null) {
                    int x = aaa.getX();int y = aaa.getY();
                    if (getChessColor(chessBoard[x][y].name) == chessColor) {
                        break;
                    }
                    moveTo.add(new ChessboardPoint(x, y));
                    if (getChessColor(chessBoard[x][y].name) != ChessColor.NONE) {
                        break;
                    }
                }else {
                    break;
                }

            }
        }
        return moveTo;
    }


    @Override
    public String toString() {
        if(name =='b'){
            return "b";
        }else {
            return "B";
        }
    }
}
