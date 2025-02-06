import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private List<ChessboardPoint> canMove;
    private  List<ChessboardPoint> fuck =new ArrayList<>();

    public RookChessComponent(ChessboardPoint s,ChessColor c){
        this.source=s;
        this.chessColor=c;
        if (c==ChessColor.BLACK)
            name='R';
        if (c==ChessColor.WHITE)
            name='r';
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point = new ChessboardPoint(i,j);
                if(chessboard[source.getX()][source.getY()].getName()>=65&&chessboard[source.getX()][source.getY()].getName()<=90) {
                    if (chessboard[i][j].getName()>90) {

                        if (canMoveTo1( i, j)) {
                            answer.add(point);

                        }
                    }
                }
                else if(chessboard[source.getX()][source.getY()].getName()>=97&&chessboard[source.getX()][source.getY()].getName()<=122) {
                    if (chessboard[i][j].getName()<97) {
                        if (canMoveTo1( i, j)) {
                            answer.add(point);

                        }
                    }
                }
            }
        }
        return answer;
    }

    public boolean canMoveTo1(int x,int y){
        int sourceX = source.getX();
        int sourceY = source.getY();
        if (sourceX == x) {
            int row = sourceX;
            for (int col = Math.min(sourceY, y) + 1; col < Math.max(sourceY, y); col++) {
                if (chessboard[row][col].getName()!='_') {
                    return false;
                }
            }
        } else if (sourceY == y) {
            int col = sourceY;
            for (int row = Math.min(sourceX, x) + 1; row < Math.max(sourceX, x); row++) {
                if (chessboard[row][col].getName()!='_') {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    @Override
    public char getName() {
        return name;
    }
}


