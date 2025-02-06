import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor){
        this.chessboardPoint = chessboardPoint;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK){
            name = 'N';
        } else if (chessColor == ChessColor.WHITE) {
            name = 'n';
        }
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> answer = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point = new ChessboardPoint(i,j);
                if(chessboard[chessboardPoint.getX()][chessboardPoint.getY()].getName()>=65&&chessboard[chessboardPoint.getX()][chessboardPoint.getY()].getName()<=90) {
                    if (i != chessboardPoint.getX() && j != chessboardPoint.getY()&&chessboard[i][j].getName()>90) {
                        if (moveChess(chessboardPoint.getX(), chessboardPoint.getY(), i, j)) {
                            answer.add(point);
                        }
                    }
                }
                else if(chessboard[chessboardPoint.getX()][chessboardPoint.getY()].getName()>=97&&chessboard[chessboardPoint.getX()][chessboardPoint.getY()].getName()<=122) {
                    if (i != chessboardPoint.getX() && j != chessboardPoint.getY()&&chessboard[i][j].getName()<97) {
                        if (moveChess(chessboardPoint.getX(), chessboardPoint.getY(), i, j)) {
                            answer.add(point);
                        }
                    }
                }
            }
        }
        return answer;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        int r1 = sourceX,c1 = sourceY,r2 = targetX,c2 = targetY;
        if(Math.abs(r1-r2)==1&&Math.abs(c1-c2)==2){
            return true;
        }else if(Math.abs(r1-r2)==2&&Math.abs(c1-c2)==1){
            return true;
        }
        return false;
    }


    public char getName(){
        return name;
    }

    public String toString(){
        return String.valueOf(name);
    }
}