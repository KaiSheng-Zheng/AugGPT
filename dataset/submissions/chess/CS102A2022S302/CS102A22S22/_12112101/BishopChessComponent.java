import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    private  List<ChessboardPoint> flag =new ArrayList<>();

    public BishopChessComponent(ChessboardPoint s,ChessColor c) {
        this.source = s;
        this.chessColor = c;
        if (c == ChessColor.BLACK)
            name = 'B';
        if (c == ChessColor.WHITE)
            name = 'b';
    }

    public boolean sameDiagonal(int sourceX, int sourceY, int targetX, int targetY){
        if(Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY))
            return true;
        else
            return false;
    }

    public char getName(){
        return name;
    }


    @Override
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



    public boolean canMoveTo1(int targetX, int targetY){
        if (!sameDiagonal(source.getX() ,source.getY(), targetX, targetY)) {
            return false;
        }
        if (source.getX() < targetX && source.getY() < targetY) {
            for (int i = source.getX(); i < targetX; i++) {
                for (int j= source.getY(); j < targetY; j++) {
                    if (i != source.getX() && j != source.getY()) {
                        if (sameDiagonal(i, j, source.getX(), source.getY())) {
                            if (chessboard[i][j].getName() != '_') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if (source.getX() > targetX && source.getY() > targetY) {
            for (int i = targetX + 1; i <= source.getX(); i++) {
                for (int j = targetY + 1; j <= source.getY(); j++) {
                    if (i != source.getX() && j != source.getY()) {
                        if (sameDiagonal(i, j, source.getX(), source.getY())) {
                            if (chessboard[i][j].getName() != '_') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if (source.getX() < targetX && source.getY() > targetY) {
            for (int i = source.getX(); i < targetX; i++) {
                for (int j = targetY + 1; j <= source.getY(); j++) {
                    if (i != source.getX() && j != source.getY()) {
                        if (sameDiagonal(i, j, source.getX(), source.getY())) {
                            if (chessboard[i][j].getName() != '_') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if (source.getX() > targetX && source.getY() < targetY) {
            for (int i = targetX + 1; i <= source.getX(); i++) {
                for (int j = source.getY(); j < targetY; j++) {
                    if (i != source.getX() && j != source.getY()) {
                        if (sameDiagonal(i, j, source.getX(), source.getY())) {
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
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

