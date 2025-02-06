import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    private List<ChessboardPoint> canMove;
    private  List<ChessboardPoint> fuck =new ArrayList<>();

    public QueenChessComponent(ChessboardPoint s,ChessColor c){
        this.source=s;
        this.chessColor=c;
        if (c==ChessColor.BLACK)
            name='Q';
        if (c==ChessColor.WHITE)
            name='q';
    }


    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point = new ChessboardPoint(i, j);
                if (chessboard[source.getX()][source.getY()].getName() >= 65 && chessboard[source.getX()][source.getY()].getName() <= 90) {
                    if (chessboard[i][j].getName() > 90) {
                        if (canMoveTo1(source.getX(), source.getY(), i, j)) {
                            answer.add(point);
                        }
                    }
                } else if (chessboard[source.getX()][source.getY()].getName() >= 97 && chessboard[source.getX()][source.getY()].getName() <= 122) {
                    if (chessboard[i][j].getName() < 97) {
                        if (canMoveTo1(source.getX(), source.getY(), i, j)) {
                            answer.add(point);
                        }
                    }
                }
            }
        }
        return answer;
    }

    public boolean sameDiagonal(int sx,int sy ,int x,int y){
        if(Math.abs(sx-x)==Math.abs(sy-y))
            return true;
        else
            return false;
    }

        public boolean canMoveTo1(int sourceX, int sourceY, int targetX, int targetY){
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

    public char getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
