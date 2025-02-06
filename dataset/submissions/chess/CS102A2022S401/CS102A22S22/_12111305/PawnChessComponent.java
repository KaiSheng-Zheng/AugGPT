import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,ChessComponent[][] chessComponents){
        this.source=source;
        this.chessColor=chessColor;
        this.chessComponents=chessComponents;
        if(chessColor==ChessColor.BLACK){
            name='P';
        }else{
            name='p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x=source.getX();
        int y=source.getY();
        List<ChessboardPoint> preTarget=new ArrayList<>();

        if(chessColor==ChessColor.BLACK){
            if(x==1&&chessComponents[x+1][y]instanceof EmptySlotComponent&&chessComponents[x+2][y].getChessColor()!=this.chessColor){
                preTarget.add(new ChessboardPoint(x+2,y));
            }
            if(x+1<=7&&chessComponents[x+1][y].getChessColor()==ChessColor.NONE){
                preTarget.add(new ChessboardPoint(x+1,y));
            }

            if(y-1>=0&&x+1<=7&&chessComponents[x+1][y-1].getChessColor()==ChessColor.WHITE){
                preTarget.add(new ChessboardPoint(x+1,y-1));
            }
            if(y+1<=7&&x+1<=7&&chessComponents[x+1][y+1].getChessColor()==ChessColor.WHITE){
                preTarget.add(new ChessboardPoint(x+1,y+1));
            }
        }else if(chessColor==ChessColor.WHITE){
            if(x==6&&chessComponents[x-1][y]instanceof EmptySlotComponent&&chessComponents[x-2][y].getChessColor()!=this.chessColor){
                preTarget.add(new ChessboardPoint(x-2,y));
            }
            if(x-1>=0&&chessComponents[x-1][y].getChessColor()==ChessColor.NONE){
                preTarget.add(new ChessboardPoint(x-1,y));
            }

            if(y-1>=0&&x-1>=0&&chessComponents[x-1][y-1].getChessColor()==ChessColor.BLACK){
                preTarget.add(new ChessboardPoint(x-1,y-1));
            }
            if(y+1<=7&&x-1>=0&&chessComponents[x-1][y+1].getChessColor()==ChessColor.BLACK){
                preTarget.add(new ChessboardPoint(x-1,y+1));
            }
        }

        Collections.sort(preTarget, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                int flag=o1.getX()-o2.getX();
                if(flag==0){
                    flag=o1.getY()-o2.getY();
                }
                return flag;
            }
        });
        return preTarget;
    }

    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }

    public String toString() {
        if(chessColor==ChessColor.BLACK){
            return "P";
        }else{
            return "p";
        }
    }
}
