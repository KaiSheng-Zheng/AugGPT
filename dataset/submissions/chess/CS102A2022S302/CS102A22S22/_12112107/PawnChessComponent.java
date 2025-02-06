import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor){
        this.chessboardPoint = chessboardPoint;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK){
            name = 'P';
        } else if (chessColor == ChessColor.WHITE) {
            name = 'p';
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

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessColor==ChessColor.BLACK){
            if(sourceX==1&&targetX==3&&targetY==sourceY){
                if(chessboard[2][targetY].getName()=='_'&&chessboard[3][targetY].getName()=='_')
                    return true;
            }
            if(Math.abs(targetY-sourceY)==1&&targetX-sourceX==1){
                    if(chessboard[targetX][targetY].getName()!='_') {
                        return true;
                    }
                }
            if(targetX-sourceX==1&&targetY==sourceY&&chessboard[targetX][targetY].getName()=='_'){
                    return true;
                }
        }
        if(chessColor==ChessColor.WHITE){
            if(sourceX==6&&targetX==4&&targetY==sourceY){
                if(chessboard[4][targetY].getName()=='_'&&chessboard[5][targetY].getName()=='_')
                    return true;
            }
            if(Math.abs(targetY-sourceY)==1&&sourceX-targetX==1){
                if(chessboard[targetX][targetY].getName()!='_') {
                    return true;
                }
            }
            if(sourceX-targetX==1&&targetY==sourceY&&chessboard[targetX][targetY].getName()=='_'){
                return true;
            }
        }
        return false;
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

    @Override
    public char getName(){
        return name;
    }

    public String toString(){
        return String.valueOf(name);
    }
}