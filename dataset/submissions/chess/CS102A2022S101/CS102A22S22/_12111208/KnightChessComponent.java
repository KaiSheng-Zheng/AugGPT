import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private int serialNumber=4;
    //private ChessColor chessColor;
    //private char name;
    //private ChessboardPoint source;
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    public KnightChessComponent() {
        super();
    }
    public KnightChessComponent(char name,ChessColor chessColor){
        super.setName(name);
        super.setChessColor(chessColor);
    }
    public KnightChessComponent(char name,ChessColor chessColor,ChessboardPoint source,ChessComponent[][] chessComponents){
        super.setName(name);
        super.setChessColor(chessColor);
        super.setSource(source);
        this.chessComponents=chessComponents;
    }

    @Override
    public ChessColor getChessColor() {
        return super.getChessColor();
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList=new ArrayList<>();
        int originY=getSource().getY();
        int originX=getSource().getX();
        ChessboardPoint chessboardPoint=new ChessboardPoint(originX,originY);
        boolean Valid=true;

        if (originY-2>=0){
            if (originX+1<=7&&notSameChessColor(originX+1,originY-2)){
                chessboardPointList.add(chessboardPoint.offset(1,-2));
            }
            if (originX-1>=0&&notSameChessColor(originX-1,originY-2)){
                chessboardPointList.add(chessboardPoint.offset(-1,-2));
            }
        }

        if(originY+2<=7){
            if (originX+1<=7&&notSameChessColor(originX+1,originY+2)){
                chessboardPointList.add(chessboardPoint.offset(1,2));
            }
            if (originX-1>=0&&notSameChessColor(originX-1,originY+2)){
                chessboardPointList.add(chessboardPoint.offset(-1,2));
            }
        }

        if (originX-2>=0){
            if (originY+1<=7&&notSameChessColor(originX-2,originY+1)){
                chessboardPointList.add(chessboardPoint.offset(-2,1));
            }
            if (originY-1>=0&&notSameChessColor(originX-2,originY-1)){
                chessboardPointList.add(chessboardPoint.offset(-2,-1));
            }
        }

        if (originX+2<=7){
            if (originY+1<=7&&notSameChessColor(originX+2,originY+1)){
                chessboardPointList.add(chessboardPoint.offset(2,1));
            }
            if (originY-1>=0&&notSameChessColor(originX+2,originY-1)){
                chessboardPointList.add(chessboardPoint.offset(2,-1));
            }
        }
        return chessboardPointList;
    }

    @Override
    public String getName() {
        return String.valueOf(name);
    }



    public ChessboardPoint getSource() {
        return super.getSource();
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public boolean notSameChessColor(int x,int y){
        return chessComponents[x][y].getChessColor()!=getChessColor();
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
