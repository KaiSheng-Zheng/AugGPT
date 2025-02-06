import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(){

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int[][] directions = new int[][]{{-2,-1},{2,-1},{-2,1},{2,1},{-1,-2},{1,-2},{-1,2},{1,2}};
        List<ChessboardPoint> result = new ArrayList<>();
        directionMove(directions, result);
        Collections.sort(result, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() == o2.getX()){
                    return o1.getY() - o2.getY();
                }else {
                    return o1.getX() - o2.getX();
                }
            }
        });
        return result;
    }

    public void directionMove(int[][] directions, List<ChessboardPoint> result){
        for (int i = 0; i < directions.length; i++) {
                int x = this.getSource().getX();
                int y = this.getSource().getY();
                int curX = x + directions[i][0];
                int curY = y + directions[i][1];
                if (curX < 0 || curX >7 || curY < 0 || curY > 7
                || (GetChessBoard.chessComponents[curX][curY].getChessColor().equals(getChessColor()))){
                    continue;
                }
                if (GetChessBoard.chessComponents[curX][curY].name == '_'){
                    result.add(new ChessboardPoint(curX, curY));
                    continue;
                }
                if (GetChessBoard.chessComponents[curX][curY].name != '_'
                  && !GetChessBoard.chessComponents[curX][curY].getChessColor().equals(getChessColor())){
                    result.add(new ChessboardPoint(curX, curY));
                }
        }
    }



}
