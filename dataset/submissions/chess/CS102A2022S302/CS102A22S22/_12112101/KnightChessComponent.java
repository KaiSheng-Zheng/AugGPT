import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    private List<ChessboardPoint> canMove;
    private  List<ChessboardPoint> fuck =new ArrayList<>();

    public KnightChessComponent(ChessboardPoint s,ChessColor c){
        this.source=s;
        this.chessColor=c;
        if (c==ChessColor.BLACK)
            name='N';
        if (c==ChessColor.WHITE)
            name='n';
    }



    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point = new ChessboardPoint(i,j);
                if(chessboard[source.getX()][source.getY()].getName()>=65&&chessboard[source.getX()][source.getY()].getName()<=90) {
                    if (i != source.getX() && j != source.getY()&&chessboard[i][j].getName()>90) {
                        if (canMoveTo1( i, j)) {
                            answer.add(point);
                        }
                    }
                }
                else if(chessboard[source.getX()][source.getY()].getName()>=97&&chessboard[source.getX()][source.getY()].getName()<=122) {
                    if (i != source.getX() && j != source.getY()&&chessboard[i][j].getName()<97) {
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
        int r1 = source.getX(),c1 = source.getY();
        if(Math.abs(r1- x)==1&&Math.abs(c1- y)==2){
            return true;
        }else if(Math.abs(r1- x)==2&&Math.abs(c1- y)==1){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public char getName() {
        return name;
    }


}
