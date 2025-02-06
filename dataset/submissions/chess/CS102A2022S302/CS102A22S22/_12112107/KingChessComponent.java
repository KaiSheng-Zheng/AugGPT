import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor){
        this.chessboardPoint = chessboardPoint;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK){
            name = 'K';
        } else if (chessColor == ChessColor.WHITE) {
            name = 'k';
        }
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

    public boolean sameDiagonal(int sourceX, int sourceY, int targetX, int targetY){
        if(Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY))
            return true;
        else
            return false;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        int r1 = Math.max(sourceX,targetX),
                c1 = Math.max(sourceY,targetY),
                r2 = Math.min(sourceX,targetX),
                c2 = Math.min(sourceY,targetY);
        if((Math.abs(r1-r2)+Math.abs(c1-c2)!=1)&& !(Math.abs(r1-r2)==1&&sameDiagonal(sourceX,sourceY,targetX,targetY))){
            return canCastle(sourceX,sourceY,targetX,targetY);
        }
        return true;
    }

    public boolean canCastle(int x,int y,int a,int b){return false;}

    public char getName(){
        return name;
    }

    public String toString(){
        return String.valueOf(name);
    }
}