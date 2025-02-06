import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessColor color;
    private char name;

    public void setPoint(ChessboardPoint point) {
        this.point = point;
    }

    private ChessboardPoint point;

    public PawnChessComponent(ChessboardPoint point, ChessColor color, char name) {
        this.color = color;
        this.point = point;
        this.name = name;
    }
    public ChessColor getChessColor() {
        return color;
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmove = new ArrayList<>();

        boolean judge=false;
        if(color==ChessColor.WHITE){
            if(point.getX()==6){
                judge=true;
            }
            if(judge&&chessboard[4][point.getY()].toString().equals("_")){
                canmove.add(point.offset(-2,0));
            }

            if(point.getX()-1>=0&&chessboard[point.getX()-1][point.getY()].toString().equals("_")){
                canmove.add(point.offset(-1,0));

            }
            if(point.getX()-1>=0&&point.getY()+1<=7&&
                    chessboard[point.getX()-1][point.getY()+1].getChessColor()!=color&&
                    !chessboard[point.getX()-1][point.getY()+1].toString().equals("_")){
                canmove.add(point.offset(-1,1));
            }
            if(point.getX()-1>=0&&point.getY()-1>=0&&
                    chessboard[point.getX()-1][point.getY()-1].getChessColor()!=color&&
                    !chessboard[point.getX()-1][point.getY()-1].toString().equals("_")){
                canmove.add(point.offset(-1,-1));
            }
        }
        else{
            if(point.getX()==1){
                judge=true;
            }
            if(judge&&chessboard[3][point.getY()].toString().equals("_")){
                canmove.add(point.offset(2,0));
            }

            if(point.getX()+1<=7&&chessboard[point.getX()+1][point.getY()].toString().equals("_")){
                canmove.add(point.offset(1,0));
            }
            if(point.getX()+1<=7&&point.getY()+1<=7&&
                    chessboard[point.getX()+1][point.getY()+1].getChessColor()!=color&&
                    !chessboard[point.getX()+1][point.getY()+1].toString().equals("_")){
                canmove.add(point.offset(1,1));
            }
            if(point.getX()+1<=7&&point.getY()-1>=0&&
                    chessboard[point.getX()+1][point.getY()-1].getChessColor()!=color&&
                    !chessboard[point.getX()+1][point.getY()-1].toString().equals("_")){
                canmove.add(point.offset(1,-1));
            }
        }


        return canmove;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
