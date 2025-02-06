import java.util.ArrayList;
import java.util.List;
public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor){
        this.chessboardPoint = chessboardPoint;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK){
            name = 'R';
        } else if (chessColor == ChessColor.WHITE) {
            name = 'r';
        }
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (sourceX == targetX) {
            int row = sourceX;
            for (int col = Math.min(sourceY, targetY) + 1; col < Math.max(sourceY, targetY); col++) {
                if (chessboard[row][col].getName()!='_') {
                    return false;
                }
            }
        } else if (sourceY == targetY) {
            int col = sourceY;
            for (int row = Math.min(sourceX, targetX) + 1; row < Math.max(sourceX, targetX); row++) {
                if (chessboard[row][col].getName()!='_') {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> answer = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point = new ChessboardPoint(i,j);
                if(chessboard[chessboardPoint.getX()][chessboardPoint.getY()].getName()>=65&&chessboard[chessboardPoint.getX()][chessboardPoint.getY()].getName()<=90) {
                    if (chessboard[i][j].getName()>90) {

                        if (moveChess(chessboardPoint.getX(), chessboardPoint.getY(), i, j)) {
                            answer.add(point);

                        }
                    }
                }
                else if(chessboard[chessboardPoint.getX()][chessboardPoint.getY()].getName()>=97&&chessboard[chessboardPoint.getX()][chessboardPoint.getY()].getName()<=122) {
                    if (chessboard[i][j].getName()<97) {
                        if (moveChess(chessboardPoint.getX(), chessboardPoint.getY(), i, j)) {
                            answer.add(point);

                        }
                    }
                }
            }
        }
        return answer;
    }



    private void getChessboardGraph() {
        StringBuilder Answer = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Answer.append(chessboard[i][j].getName());
                if(j==7)
                    Answer.append('\n');
            }
        }
        System.out.println(Answer.toString());
    }

    public char getName(){
        return name;
    }

    public String toString(){
        return String.valueOf(name);
    }
}