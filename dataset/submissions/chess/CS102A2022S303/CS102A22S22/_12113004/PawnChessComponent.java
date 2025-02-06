import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(int x,int y, char name) {
        super.setName(name);
        if ('A'<=name && name<='Z'){
            // The upper case letter indicates black chess pieces,
            // while the lower case letter means white chess pieces.
            super.setChessColor(ChessColor.BLACK);
        }else super.setChessColor(ChessColor.WHITE);
        super.setSource(new ChessboardPoint(x,y));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> output = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        int[][] move;
        int[][] eat;
        int[] times;
        if (getChessColor()==ChessColor.WHITE){
            if (getSource().getX()==6){
                move = new int[][]{{-1, 0}};
                times = new int[]{1,2};
            }else {
                move = new int[][]{{-1, 0}};
                times = new int[]{1};
            }
            eat = new int[][]{{-1, -1}, {-1, +1}};
        }else {
            if (getSource().getX()==1){
                move = new int[][]{{+1, 0}};
                times = new int[]{1,2};
            }else {
                move = new int[][]{{+1, 0}};
                times = new int[]{1};
            }
            eat = new int[][]{{+1, -1}, {+1, +1}};

        }
        //just move
        for (int i = 0; i < move.length; i++) {
            first:
            {
                for (int j = 0; j < times.length; j++) {
                    int dx = move[i][0] * times[j];
                    int dy = move[i][1] * times[j];
                    if (move(chessComponents, x, y, dx, dy)) {
                        output.add(new ChessboardPoint(x + dx, y + dy));
                    } else break first;
                }
            }

        }
        //just eat
        for (int i = 0; i < eat.length; i++) {
            int dx = eat[i][0];
            int dy = eat[i][1];
            if (eat(chessComponents,x,y,dx,dy)){
                output.add(new ChessboardPoint(x+dx,y+dy));
            }
        }
        output.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return output;
    }

    public boolean move(ChessComponent[][] chessComponents, int x, int y, int dx, int dy){
        if (chessComponents[x][y].getSource().canMove(dx,dy)){
            return chessComponents[x+dx][y+dy].getChessColor()==ChessColor.NONE;
        }else return false;
    }


    public boolean eat(ChessComponent[][] chessComponents, int x, int y, int dx, int dy){
        if (chessComponents[x][y].getSource().canMove(dx,dy)){
            return chessComponents[x+dx][y+dy].getChessColor()!=ChessColor.NONE && chessComponents[x+dx][y+dy].getChessColor()!=getChessColor();
        }else return false;
    }




}
