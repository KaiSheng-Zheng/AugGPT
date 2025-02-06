import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private List<ChessboardPoint> canMove;
    private  List<ChessboardPoint> fuck =new ArrayList<>();

    public PawnChessComponent(ChessboardPoint s,ChessColor c){
        this.source=s;
        this.chessColor=c;
        if (c==ChessColor.BLACK)
            name='P';
        if (c==ChessColor.WHITE)
            name='p';
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


    public boolean canMoveTo1( int targetX, int targetY){

        if(chessColor==ChessColor.BLACK){
            if(source.getX()==1&&targetX==3&&targetY== source.getY()){
                if(chessboard[2][targetY].getName()=='_'&&chessboard[3][targetY].getName()=='_')
                    return true;
            }
            if(Math.abs(targetY- source.getY())==1&&targetX-source.getX()==1){
                if(chessboard[targetX][targetY].getName()!='_') {
                    return true;
                }
            }
            if(targetX-source.getX()==1&&targetY== source.getY()&&chessboard[targetX][targetY].getName()=='_'){
                return true;
            }
        }
        if(chessColor==ChessColor.WHITE){
            if(source.getX()==6&&targetX==4&&targetY== source.getY()){
                if(chessboard[4][targetY].getName()=='_'&&chessboard[5][ source.getY()].getName()=='_' )
                    return true;
            }
            else{
                if(Math.abs(targetY- source.getY())==1&&source.getX()-targetX==1){
                    if(chessboard[targetX][targetY].getName()!='_') {
                        return true;
                    }
                }else if(source.getX()-targetX==1&&targetY== source.getY()&&chessboard[targetX][targetY].getName()=='_'){
                    return true;
                }
            }
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
