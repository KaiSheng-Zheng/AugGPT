import java.util.ArrayList;
import java.util.List;
public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor){
        this.chessboardPoint = chessboardPoint;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK){
            name = 'Q';
        } else if (chessColor == ChessColor.WHITE) {
            name = 'q';
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

    public boolean sameDiagonal(int sourceX, int sourceY, int targetX, int targetY){
        if(Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY))
            return true;
        else
            return false;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (sameDiagonal( sourceX,  sourceY,  targetX,  targetY)) {
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
        if (sourceX == targetX) {
            int row = sourceX;
            for (int col = Math.min(sourceY, targetY) + 1;
                 col < Math.max(sourceY, targetY); col++) {
                if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (sourceY == targetY) {
            int col = sourceY;
            for (int row = Math.min(sourceX, targetX) + 1;
                 row < Math.max(sourceX, targetX); row++) {
                if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else { // Not on the same row or the same column.
            return false;
        }
        return true;
    }

    public char getName(){
        return name;
    }

    public String toString(){
        return String.valueOf(name);
    }
}