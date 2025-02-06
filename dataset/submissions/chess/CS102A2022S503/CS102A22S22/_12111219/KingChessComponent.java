import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessColor chessColor,ChessboardPoint source){

        this.setChessColor(chessColor);
        this.setSource(source);
        this.name=chessColor==ChessColor.WHITE?'k':'K';

    }
    @Override
    public  List<ChessboardPoint> canMoveTo() {



        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(i==0&&j==0){
                    continue;
                }
                if (getSource().offset(i, j) != null && Occupied(chessComponents[getSource().getX()][getSource().getY()], chessComponents[getSource().getX() + i][getSource().getY() + j])) {
                 chessboardPoints.add(getSource().offset(i,j));
                }
            }
        }

//        chessboardPoints.add(new ChessboardPoint(6,3));
        return chessboardPoints;
    }



//@Override
//public List<ChessboardPoint> canMoveTo() {
//    List<ChessboardPoint> chessboardPointList=new ArrayList<>();
//    int originY=getSource().getY();
//    int originX=getSource().getX();
//    ChessboardPoint chessboardPoint=new ChessboardPoint(originX,originY);
//    boolean Valid=true;
//
//    if (originX+1<=7&&notSameChessColor(originX+1,originY)){
//        chessboardPointList.add(chessboardPoint.offset(1,0));
//        if (originY+1<=7&&notSameChessColor(originX+1,originY+1)){
//            chessboardPointList.add(chessboardPoint.offset(1,1));
//        }
//        if (originY-1>=0&&notSameChessColor(originX+1,originY-1)){
//            chessboardPointList.add(chessboardPoint.offset(1,-1));
//        }
//    }
//    if (originX-1>=0&&notSameChessColor(originX-1,originY)){
//        chessboardPointList.add(chessboardPoint.offset(-1,0));
//        if (originY+1<=7&&notSameChessColor(originX-1,originY+1)){
//            chessboardPointList.add(chessboardPoint.offset(-1,1));
//        }
//        if (originY-1>=0&&notSameChessColor(originX-1,originY-1)){
//            chessboardPointList.add(chessboardPoint.offset(-1,-1));
//        }
//    }
//    if (originY+1<=7&&notSameChessColor(originX,originY+1)){
//        chessboardPointList.add(chessboardPoint.offset(0,1));
//    }
//    if (originY-1>=0&&notSameChessColor(originX,originY-1)){
//        chessboardPointList.add(chessboardPoint.offset(0,-1));
//    }
//    return chessboardPointList;
//}


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
//        chessboardPoints.add(getSource().offset(0,1));}
//        chessboardPoints.add(getSource().offset(0,-1));
//        chessboardPoints.add(getSource().offset(1,0));
//        chessboardPoints.add(getSource().offset(-1,0));
//        chessboardPoints.add(getSource().offset(1,1));
//        chessboardPoints.add(getSource().offset(1,-1));
//        chessboardPoints.add(getSource().offset(-1,-1));
//        chessboardPoints.add(getSource().offset(-1,1));