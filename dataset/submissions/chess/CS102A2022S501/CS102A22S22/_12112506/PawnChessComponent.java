import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent [][]chessComponents;
    public char getName() {
        return name;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public PawnChessComponent(ChessboardPoint source,ChessColor color,ChessComponent [][]chessComponents){
        this.source=source;
        this.chessColor=color;
        this.chessComponents=chessComponents;
        if(chessColor.equals(ChessColor.BLACK)){
            this.name='P';
        }
        else if(chessColor.equals(ChessColor.WHITE)){
            this.name='p';
        }
    }

    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>chessboardPointList=new ArrayList<>();
        int fromX=source.getX();int fromY=source.getY();
        if(chessColor.equals(ChessColor.BLACK)){
            if(fromX==1){
                if(chessComponents[fromX+1][fromY] instanceof EmptySlotComponent
                        &&chessComponents[fromX+2][fromY] instanceof EmptySlotComponent){
                    chessboardPointList.add(new ChessboardPoint(fromX+2,fromY));
                }
            }
            if(fromX<7){
                if(chessComponents[fromX+1][fromY] instanceof EmptySlotComponent){
                    chessboardPointList.add(new ChessboardPoint(fromX+1,fromY));
                }
            }
            int i=fromX+1;int j=fromY+1;
            if(i<8&&j<8){
                if(!(chessComponents[i][j] instanceof EmptySlotComponent)
                        &&!chessComponents[i][j].getChessColor().equals(chessColor)){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                }
            }
            i=fromX+1;j=fromY-1;
            if(i<8&&j>=0){
                if(!(chessComponents[i][j] instanceof EmptySlotComponent)
                        &&!chessComponents[i][j].getChessColor().equals(chessColor)){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                }
            }
        }
        else if(chessColor.equals(ChessColor.WHITE)){
            if(fromX==6){
                if(chessComponents[fromX-1][fromY] instanceof EmptySlotComponent
                        &&chessComponents[fromX-2][fromY] instanceof EmptySlotComponent){
                    chessboardPointList.add(new ChessboardPoint(fromX-2,fromY));
                }
            }
            if(fromX>0){
                if(chessComponents[fromX-1][fromY] instanceof EmptySlotComponent){
                    chessboardPointList.add(new ChessboardPoint(fromX-1,fromY));
                }
            }
            int i=fromX-1;int j=fromY+1;
            if(i>=0&&j<8){
                if(!(chessComponents[i][j] instanceof EmptySlotComponent)
                        &&!chessComponents[i][j].getChessColor().equals(chessColor)){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                }
            }
            i=fromX-1;j=fromY-1;
            if(i>=0&&j>=0){
                if(!(chessComponents[i][j] instanceof EmptySlotComponent)
                        &&!chessComponents[i][j].getChessColor().equals(chessColor)){
                    chessboardPointList.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chessboardPointList;
    }
}
