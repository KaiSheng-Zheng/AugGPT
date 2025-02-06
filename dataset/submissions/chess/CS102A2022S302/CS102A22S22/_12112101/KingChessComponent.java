import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    private List<ChessboardPoint> canMove;
    private  List<ChessboardPoint> fuck =new ArrayList<>();

    public KingChessComponent(ChessboardPoint s,ChessColor c){
        this.source=s;
        this.chessColor=c;
        if (c==ChessColor.BLACK)
            name='K';
        if (c==ChessColor.WHITE)
            name='k';
    }

    public boolean sameDiagonal(int sourceX, int sourceY, int targetX, int targetY){
        if(Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY))
            return true;
        else
            return false;
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

    public boolean canMoveTo1(int x, int y) {
        int r1 = Math.max(source.getX(),x),
                c1 = Math.max(source.getY(),y),
                r2 = Math.min(source.getX(),x),
                c2 = Math.min(source.getY(),y);
        if((Math.abs(r1-r2)+Math.abs(c1-c2)==1)|| (Math.abs(r1-r2)==1&&sameDiagonal(source.getX(),source.getY(),x,y))){
            return true;
        }
        return false;
    }

    public char getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}


