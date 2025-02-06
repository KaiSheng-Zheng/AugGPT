import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> temp = new ArrayList<ChessboardPoint>();
        int tempX=this.getSource().getX();
        int tempY=this.getSource().getY();

        if (newChessboard[tempX][tempY].getChessColor()==ChessColor.BLACK){
            if (tempX+1>=0&&tempX+1<=7&&tempY+2>=0&&tempY+2<=7){
                if (newChessboard[tempX+1][tempY+2].getChessColor()!=ChessColor.BLACK){
                    temp.add(new ChessboardPoint(tempX+1,tempY+2));
                }
            }
            if (tempX-1>=0&&tempX-1<=7&&tempY+2>=0&&tempY+2<=7){
                if (newChessboard[tempX-1][tempY+2].getChessColor()!=ChessColor.BLACK){
                    temp.add(new ChessboardPoint(tempX-1,tempY+2));
                }
            }
            if (tempX+1>=0&&tempX+1<=7&&tempY-2>=0&&tempY-2<=7){
                if (newChessboard[tempX+1][tempY-2].getChessColor()!=ChessColor.BLACK)
                    temp.add(new ChessboardPoint(tempX+1,tempY-2));
            }
            if (tempX-1>=0&&tempX-1<=7&&tempY-2>=0&&tempY-2<=7){
                if (newChessboard[tempX-1][tempY-2].getChessColor()!=ChessColor.BLACK)
                    temp.add(new ChessboardPoint(tempX-1,tempY-2));
            }
            if (tempX+2>=0&&tempX+2<=7&&tempY+1>=0&&tempY+1<=7){
                if (newChessboard[tempX+2][tempY+1].getChessColor()!=ChessColor.BLACK)
                    temp.add(new ChessboardPoint(tempX+2,tempY+1));
            }
            if (tempX-2>=0&&tempX-2<=7&&tempY+1>=0&&tempY+1<=7){
                if (newChessboard[tempX-2][tempY+1].getChessColor()!=ChessColor.BLACK)
                    temp.add(new ChessboardPoint(tempX-2,tempY+1));
            }
            if (tempX+2>=0&&tempX+2<=7&&tempY-1>=0&&tempY-1<=7){
                if (newChessboard[tempX+2][tempY-1].getChessColor()!=ChessColor.BLACK)
                    temp.add(new ChessboardPoint(tempX+2,tempY-1));
            }
            if (tempX-2>=0&&tempX-2<=7&&tempY-1>=0&&tempY-1<=7){
                if (newChessboard[tempX-2][tempY-1].getChessColor()!=ChessColor.BLACK)
                    temp.add(new ChessboardPoint(tempX-2,tempY-1));
            }
        }

        else if (newChessboard[tempX][tempY].getChessColor()==ChessColor.WHITE){
            if (tempX+1>=0&&tempX+1<=7&&tempY+2>=0&&tempY+2<=7){
                if (newChessboard[tempX+1][tempY+2].getChessColor()!=ChessColor.WHITE){
                    temp.add(new ChessboardPoint(tempX+1,tempY+2));
                }
            }
            if (tempX-1>=0&&tempX-1<=7&&tempY+2>=0&&tempY+2<=7){
                if (newChessboard[tempX-1][tempY+2].getChessColor()!=ChessColor.WHITE){
                    temp.add(new ChessboardPoint(tempX-1,tempY+2));
                }
            }
            if (tempX+1>=0&&tempX+1<=7&&tempY-2>=0&&tempY-2<=7){
                if (newChessboard[tempX+1][tempY-2].getChessColor()!=ChessColor.WHITE)
                temp.add(new ChessboardPoint(tempX+1,tempY-2));
            }
            if (tempX-1>=0&&tempX-1<=7&&tempY-2>=0&&tempY-2<=7){
                if (newChessboard[tempX-1][tempY-2].getChessColor()!=ChessColor.WHITE)
                temp.add(new ChessboardPoint(tempX-1,tempY-2));
            }
            if (tempX+2>=0&&tempX+2<=7&&tempY+1>=0&&tempY+1<=7){
                if (newChessboard[tempX+2][tempY+1].getChessColor()!=ChessColor.WHITE)
                temp.add(new ChessboardPoint(tempX+2,tempY+1));
            }
            if (tempX-2>=0&&tempX-2<=7&&tempY+1>=0&&tempY+1<=7){
                if (newChessboard[tempX-2][tempY+1].getChessColor()!=ChessColor.WHITE)
                temp.add(new ChessboardPoint(tempX-2,tempY+1));
            }
            if (tempX+2>=0&&tempX+2<=7&&tempY-1>=0&&tempY-1<=7){
                if (newChessboard[tempX+2][tempY-1].getChessColor()!=ChessColor.WHITE)
                temp.add(new ChessboardPoint(tempX+2,tempY-1));
            }
            if (tempX-2>=0&&tempX-2<=7&&tempY-1>=0&&tempY-1<=7){
                if (newChessboard[tempX-2][tempY-1].getChessColor()!=ChessColor.WHITE)
                temp.add(new ChessboardPoint(tempX-2,tempY-1));
            }
        }

        return temp;
    }
}


