import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private int serialNumber=5;
    //private ChessColor chessColor;
    //private char name;
    //private ChessboardPoint source;
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    public PawnChessComponent() {
        super();
    }
    public PawnChessComponent(char name,ChessColor chessColor){
        super.setName(name);
        super.setChessColor(chessColor);
    }
    public PawnChessComponent(char name,ChessColor chessColor,ChessboardPoint source,ChessComponent[][] chessComponents){
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

        if(getChessColor()==ChessColor.WHITE){
            if (originX==6){
                for (int i=1;i<=2;i++){
                    if ((chessComponents[originX-i][originY]instanceof EmptySlotComponent)){
                        chessboardPointList.add(chessboardPoint.offset(-i,0));
                    }
                }

            }else {
                if ((chessComponents[originX-1][originY]instanceof EmptySlotComponent)){
                    chessboardPointList.add(chessboardPoint.offset(-1,0));
                }

            }
        }else {
            if (originX==1){
                for (int i=1;i<=2;i++){
                    if ((chessComponents[originX+i][originY]instanceof EmptySlotComponent)){
                        chessboardPointList.add(chessboardPoint.offset(i,0));
                    }
                }
            }else {
                if ((chessComponents[originX+1][originY]instanceof EmptySlotComponent)){
                    chessboardPointList.add(chessboardPoint.offset(1,0));
                }
            }
        }

        if(getChessColor()==ChessColor.WHITE){
            if (originY<7&&originX>0&&(chessComponents[originX-1][originY+1].getChessColor()==ChessColor.BLACK)){
                    chessboardPointList.add(chessboardPoint.offset(-1,1));
            }else if (originX>0&&originY>0&&(chessComponents[originX-1][originY-1].getChessColor()==ChessColor.BLACK)){
                    chessboardPointList.add(chessboardPoint.offset(-1,-1));
            }
        }else {
            if (originX<7&&originY<7&&(chessComponents[originX+1][originY+1].getChessColor()==ChessColor.WHITE)){
                    chessboardPointList.add(chessboardPoint.offset(1,1));
            }else if (originX<7&&originY>0&&(chessComponents[originX+1][originY-1].getChessColor()==ChessColor.WHITE)){
                    chessboardPointList.add(chessboardPoint.offset(1,-1));
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
