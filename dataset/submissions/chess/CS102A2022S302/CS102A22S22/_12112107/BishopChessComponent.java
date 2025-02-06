import java.util.*;

public class BishopChessComponent extends ChessComponent {
    private List<ChessboardPoint> answer = new ArrayList<>();

    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor) {
        this.chessboardPoint = chessboardPoint;
        this.chessColor = chessColor;
        if (chessColor == ChessColor.BLACK) {
            name = 'B';
        } else if (chessColor == ChessColor.WHITE) {
            name = 'b';
        }
    }
    public void setChessboardPoint(ChessboardPoint chessboardPoint){
        this.chessboardPoint = chessboardPoint;
    }
    public boolean sameDiagonal(int sourceX, int sourceY, int targetX, int targetY){
        if(Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY))
            return true;
        else
            return false;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (!sameDiagonal(sourceX ,sourceY, targetX, targetY)) {
            return false;
        }
        if (sourceX < targetX && sourceY < targetY) {
            for (int i = sourceX; i < targetX; i++) {
                for (int j= sourceY; j < targetY; j++) {
                    if (i != sourceX && j != sourceY) {
                        if (sameDiagonal(i, j, sourceX, sourceY)) {
                            if (chessboard[i][j].getName() != '_') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if (sourceX > targetX && sourceY > targetY) {
            for (int i = targetX + 1; i <= sourceX; i++) {
                for (int j = targetY + 1; j <= sourceY; j++) {
                    if (i != sourceX && j != sourceY) {
                        if (sameDiagonal(i, j, sourceX, sourceY)) {
                            if (chessboard[i][j].getName() != '_') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if (sourceX < targetX && sourceY > targetY) {
            for (int i = sourceX; i < targetX; i++) {
                for (int j = targetY + 1; j <= sourceY; j++) {
                    if (i != sourceX && j != sourceY) {
                        if (sameDiagonal(i, j, sourceX, sourceY)) {
                            if (chessboard[i][j].getName() != '_') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if (sourceX > targetX && sourceY < targetY) {
            for (int i = targetX + 1; i <= sourceX; i++) {
                for (int j = sourceY; j < targetY; j++) {
                    if (i != sourceX && j != sourceY) {
                        if (sameDiagonal(i, j, sourceX, sourceY)) {
                            if (chessboard[i][j].getName() != '_') {
                                return false;
                            }
                        }
                    }
                }
            }
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

    @Override
    public char getName(){
        return name;
    }

    public String toString(){
        return String.valueOf(name);
    }
}
