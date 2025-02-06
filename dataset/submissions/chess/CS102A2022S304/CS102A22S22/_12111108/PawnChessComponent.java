import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessColor chessColor = this.getChessColor();
        List<ChessboardPoint> result = new ArrayList<>();
        int[][] directions = null;
        int bounds = 1;
        if (chessColor.equals(ChessColor.BLACK)){
            directions = new int[][]{{1,0},{1,-1},{1,1}};
            if (this.getSource().getX() == 1){
                bounds = 2;
            }
        }else {
            directions = new int[][]{{-1,0},{-1,-1},{-1,1}};
            if (this.getSource().getX() == 6){
                bounds = 2;
            }
        }
        directionMove(directions, result, bounds);
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
    public void directionMove(int[][] directions, List<ChessboardPoint> result, int bounds){
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        for (int j = 1; j <=bounds; j++) {
            int curX = x + directions[0][0]*j;
            int curY = y + directions[0][1]*j;
            if (curX < 0 || curX >7 || curY < 0 || curY > 7
                    || (!GetChessBoard.chessComponents[curX][curY].getChessColor().equals(ChessColor.NONE))){
                break;
            }
            if (GetChessBoard.chessComponents[curX][curY].name == '_'){
                result.add(new ChessboardPoint(curX, curY));
            }
            int curX1 = x + directions[1][0]*j;
            int curY1 = y + directions[1][1]*j;

            // missing boundary check here, will cause ArrayIndexOutOfBoundsException if y = 0, colour = BLACK
            if (GetChessBoard.chessComponents[curX1][curY1].name != '_' && !GetChessBoard.chessComponents[curX1][curY1].getChessColor().equals(getChessColor())){
                result.add(new ChessboardPoint(curX1, curY1));
            }
            int curX2 = x + directions[2][0]*j;
            int curY2 = y + directions[2][1]*j;
            if (GetChessBoard.chessComponents[curX2][curY2].name != '_' && !GetChessBoard.chessComponents[curX2][curY2].getChessColor().equals(getChessColor())){
                result.add(new ChessboardPoint(curX2, curY2));
            }
        }
    }
}
