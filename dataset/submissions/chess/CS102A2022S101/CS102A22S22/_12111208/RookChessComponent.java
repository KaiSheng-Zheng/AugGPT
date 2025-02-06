import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private int serialNumber=2;
    //private ChessColor chessColor;
   // private char name;
   // private ChessboardPoint source;
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    public RookChessComponent() {
        super();
    }
    public RookChessComponent(char name,ChessColor chessColor){
        super.setName(name);
        super.setChessColor(chessColor);
    }
    public RookChessComponent(char name,ChessColor chessColor,ChessboardPoint source,ChessComponent[][] chessComponents){
        super.setName(name);
        super.setChessColor(chessColor);
        super.setSource(source);
        this.chessComponents=chessComponents;
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

        for (int i=1;originY-i>=0;i++){
            if (chessComponents[originX][originY-i]instanceof EmptySlotComponent){
                chessboardPointList.add(chessboardPoint.offset(0,-i));
            }else if (notSameChessColor(originX,originY-i)){
                chessboardPointList.add(chessboardPoint.offset(0,-i));
                break;
            }else {
                break;
            }
        }

        for (int i=1;originY+i<=7;i++){
            if (chessComponents[originX][originY+i]instanceof EmptySlotComponent){
                chessboardPointList.add(chessboardPoint.offset(0,i));
            }else if (notSameChessColor(originX,originY+i)){
                chessboardPointList.add(chessboardPoint.offset(0,i));
                break;
            }else {
                break;
            }
        }

        for (int i=1;originX-i>=0;i++){
            if (chessComponents[originX-i][originY]instanceof EmptySlotComponent){
                chessboardPointList.add(chessboardPoint.offset(-i,0));
            }else if (notSameChessColor(originX-i,originY)){
                chessboardPointList.add(chessboardPoint.offset(-i,0));
                break;
            }else {
                break;
            }
        }

        for (int i=1;originX+i<=7;i++){
            if (chessComponents[originX+i][originY]instanceof EmptySlotComponent){
                chessboardPointList.add(chessboardPoint.offset(i,0));
            }else if (notSameChessColor(originX+i,originY)){
                chessboardPointList.add(chessboardPoint.offset(i,0));
                break;
            }else {
                break;
            }
        }
        return chessboardPointList;
    }

    @Override
    public String getName() {
        return String.valueOf(name);
    }

    @Override
    public ChessColor getChessColor() {
        return super.getChessColor();
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
