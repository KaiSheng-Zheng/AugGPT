import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private int serialNumber=3;
    //private ChessColor chessColor;
// private char name;
    //private ChessboardPoint source;
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];

    public BishopChessComponent() {
        super();
    }
    public BishopChessComponent(char name,ChessColor chessColor){
        super.setName(name);
        super.setChessColor(chessColor);
    }
    public BishopChessComponent(char name,ChessColor chessColor,ChessboardPoint source,ChessComponent[][] chessComponents){
        super.setName(name);
        super.setChessColor(chessColor);
        super.setSource(source);
        this.chessComponents=chessComponents;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return String.valueOf(name);
    }

    public ChessColor getChessColor() {
        return super.getChessColor();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList=new ArrayList<>();
        int originY=getSource().getY();
        int originX=getSource().getX();
        ChessboardPoint chessboardPoint=new ChessboardPoint(originX,originY);
        boolean Valid=true;
        for (int i=1;originX+i<=7&&originY+i<=7;i++){
            if (chessComponents[originX+i][originY+i]instanceof EmptySlotComponent){
                chessboardPointList.add(chessboardPoint.offset(i,i));
            }else if (chessComponents[originX+i][originY+i].getChessColor()!=getChessColor()){
                chessboardPointList.add(chessboardPoint.offset(i,i));
                break;
            }else {
                break;
            }
        }

        for (int i=1;originX-i>=0&&originY+i<=7;i++){
            if (chessComponents[originX-i][originY+i]instanceof EmptySlotComponent){
                chessboardPointList.add(chessboardPoint.offset(-i,i));
            }else if (chessComponents[originX-i][originY+i].getChessColor()!=getChessColor()){
                chessboardPointList.add(chessboardPoint.offset(-i,i));
                break;
            }else {
                break;
            }
        }

        for (int i=1;originX+i<=7&&originY-i>=0;i++){
            if (chessComponents[originX+i][originY-i]instanceof EmptySlotComponent){
                chessboardPointList.add(chessboardPoint.offset(i,-i));
            }else if (chessComponents[originX+i][originY-i].getChessColor()!=getChessColor()){
                chessboardPointList.add(chessboardPoint.offset(i,-i));
                break;
            }else {
                break;
            }
        }

        for (int i=1;originX-i>=0&&originY-i>=0;i++){
            if (chessComponents[originX-i][originY-i]instanceof EmptySlotComponent){
                chessboardPointList.add(chessboardPoint.offset(-i,-i));
            }else if (chessComponents[originX-i][originY-i].getChessColor()!=getChessColor()){
                chessboardPointList.add(chessboardPoint.offset(-i,-i));
                break;
            }else{
                break;
            }
        }
        return chessboardPointList;
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
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
