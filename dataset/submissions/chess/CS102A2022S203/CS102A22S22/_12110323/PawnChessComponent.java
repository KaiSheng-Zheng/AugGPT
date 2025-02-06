import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> temp = new ArrayList<ChessboardPoint>();
        int tempX=this.getSource().getX();
        int tempY=this.getSource().getY();

        if (newChessboard[tempX][tempY].getChessColor()==ChessColor.BLACK){
            if (tempX==1){
                if (newChessboard[tempX+1][tempY].name=='_'){
                    temp.add(new ChessboardPoint(tempX+1,tempY));
                }
                if (newChessboard[tempX+1][tempY].name=='_' &&newChessboard[tempX+2][tempY].name=='_'){
                    temp.add(new ChessboardPoint(tempX+2,tempY));
                }
                if (tempX+1>=0&&tempX+1<=7&&tempY+1>=0&&tempY+1<=7){
                    if (newChessboard[tempX+1][tempY+1].getChessColor()==ChessColor.WHITE)
                        temp.add(new ChessboardPoint(tempX+1,tempY+1));
                }
                if (tempX+1>=0&&tempX+1<=7&&tempY-1>=0&&tempY-1<=7){
                    if (newChessboard[tempX+1][tempY-1].getChessColor()==ChessColor.WHITE)
                        temp.add(new ChessboardPoint(tempX+1,tempY-1));
                }
            }
            else {
                if (newChessboard[tempX+1][tempY].name=='_'){
                    temp.add(new ChessboardPoint(tempX+1,tempY));
                }
                if (tempX+1>=0&&tempX+1<=7&&tempY+1>=0&&tempY+1<=7){
                    if (newChessboard[tempX+1][tempY+1].getChessColor()==ChessColor.WHITE)
                    temp.add(new ChessboardPoint(tempX+1,tempY+1));
                }
                if (tempX+1>=0&&tempX+1<=7&&tempY-1>=0&&tempY-1<=7){
                    if (newChessboard[tempX+1][tempY-1].getChessColor()==ChessColor.WHITE)
                    temp.add(new ChessboardPoint(tempX+1,tempY-1));
                }
            }


        }
        else if (newChessboard[tempX][tempY].getChessColor()==ChessColor.WHITE){
            if (tempX==6){
                if (newChessboard[tempX-1][tempY].name=='_'){
                    temp.add(new ChessboardPoint(tempX-1,tempY));
                }
                if (newChessboard[tempX-1][tempY].name=='_' &&newChessboard[tempX-2][tempY].name=='_'){
                    temp.add(new ChessboardPoint(tempX-2,tempY));
                }
                if (tempX-1>=0&&tempX-1<=7&&tempY+1>=0&&tempY+1<=7){
                    if (newChessboard[tempX-1][tempY+1].getChessColor()==ChessColor.BLACK)
                    temp.add(new ChessboardPoint(tempX-1,tempY+1));
                }
                if (tempX-1>=0&&tempX-1<=7&&tempY-1>=0&&tempY-1<=7){
                    if (newChessboard[tempX-1][tempY-1].getChessColor()==ChessColor.BLACK)
                    temp.add(new ChessboardPoint(tempX-1,tempY-1));
                }
            }
            else {
                if (newChessboard[tempX-1][tempY].name=='_'){
                    temp.add(new ChessboardPoint(tempX-1,tempY));
                }
                if (tempX-1>=0&&tempX-1<=7&&tempY+1>=0&&tempY+1<=7){
                    if (newChessboard[tempX-1][tempY+1].getChessColor()==ChessColor.BLACK)
                        temp.add(new ChessboardPoint(tempX-1,tempY+1));
                }
                if (tempX-1>=0&&tempX-1<=7&&tempY-1>=0&&tempY-1<=7){
                    if (newChessboard[tempX-1][tempY-1].getChessColor()==ChessColor.BLACK)
                        temp.add(new ChessboardPoint(tempX-1,tempY-1));
                }
            }


        }
        return temp;
    }
}
