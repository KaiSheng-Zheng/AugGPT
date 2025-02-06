import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessColor color;
    private char name;

    public void setPoint(ChessboardPoint point) {
        this.point = point;
    }

    private ChessboardPoint point;

    public QueenChessComponent(ChessboardPoint point,ChessColor color,char name){
        this.color=color;
        this.point=point;
        this.name=name;
    }
    public ChessColor getChessColor() {
        return color;
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canmove=new ArrayList<>();
                                  //there's might be something wrong
        for(int i=1;i<8;i++){
            if(point.getX()-i>=0&&chessboard[point.getX()-i][point.getY()].getChessColor()!=color){
                canmove.add(point.offset(-i, 0));
            }
            if(point.getX()-i>=0&&
                    !chessboard[point.getX()-i][point.getY()].toString().equals("_")){
                break;
            }
        }     
        for(int i=1;i<8;i++){
            if(point.getX()+i<=7&&chessboard[point.getX()+i][point.getY()].getChessColor()!=color){
                canmove.add(point.offset(i, 0));
            }
            if(point.getX()+i<=7&&
                    !chessboard[point.getX()+i][point.getY()].toString().equals("_")){
                break;
            }
        }
        for(int i=1;i<8;i++){
            if(point.getY()+i<=7&&chessboard[point.getX()][point.getY()+i].getChessColor()!=color){
                canmove.add(point.offset(0, i));
            }
            if(point.getY()+i<=7&&
                    !chessboard[point.getX()][point.getY()+i].toString().equals("_")){
                break;
            }
        }
        for(int i=1;i<8;i++){
            if(point.getY()-i>=0&&chessboard[point.getX()][point.getY()-i].getChessColor()!=color){
                canmove.add(point.offset(0, -i));
            }
            if(point.getY()-i>=0&&
                    !chessboard[point.getX()][point.getY()-i].toString().equals("_")){
                break;
            }
        }
        for(int i=1;i<8;i++){
            if(point.getX()+i<=7&&point.getY()+i<=7&&
                    chessboard[point.getX()+i][point.getY()+i].getChessColor()!=color){
                canmove.add(point.offset(i,i));
            }
            if(point.getX()+i<=7&&point.getY()+i<=7&&
                    !chessboard[point.getX()+i][point.getY()+i].toString().equals("_")){
                break;
            }
        }
        for(int i=1;i<8;i++){
            if(point.getX()+i<=7&&point.getY()-i>=0&&
                    chessboard[point.getX()+i][point.getY()-i].getChessColor()!=color){
                canmove.add(point.offset(i,-i));
            }
            if(point.getX()+i<=7&&point.getY()-i>=0&&
                    !chessboard[point.getX()+i][point.getY()-i].toString().equals("_")){
                break;
            }
        }
        for(int i=1;i<8;i++){
            if(point.getX()-i>=0&&point.getY()+i<=7&&
                    chessboard[point.getX()-i][point.getY()+i].getChessColor()!=color){
                canmove.add(point.offset(-i,i));
            }
            if(point.getX()-i>=0&&point.getY()+i<=7&&
                    !chessboard[point.getX()-i][point.getY()+i].toString().equals("_")){
                break;
            }
        }
        for(int i=1;i<8;i++){
            if(point.getX()-i>=0&&point.getY()-i>=0&&
                    chessboard[point.getX()-i][point.getY()-i].getChessColor()!=color){
                canmove.add(point.offset(-i,-i));
            }
            if(point.getX()-i>=0&&point.getY()-i>=0&&
                    !chessboard[point.getX()-i][point.getY()-i].toString().equals("_")){
                break;
            }
        }

        return canmove;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
