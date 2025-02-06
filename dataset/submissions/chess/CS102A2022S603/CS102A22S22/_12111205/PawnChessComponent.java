import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    private ChessComponent[][] chessComponents;
    private int usedTime=0;

    public PawnChessComponent() {
        super();
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setSource(ChessboardPoint chessboardPoint) {
        this.source = chessboardPoint;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setUsedTime(){
        usedTime++;
    }

    public int getUsedTime(){
        return usedTime;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint location = source;
        ChessComponent[][] situation = chessComponents;
        ChessColor color = chessColor;
        int counter=getUsedTime();
        int Y = location.getX(); int X = location.getY();
        List<ChessboardPoint> a = new ArrayList<>();
        ChessboardPoint b;
        if(usedTime==1){
            if(color==ChessColor.BLACK){
                if(situation[X+1][Y] instanceof EmptySlotComponent  &&X==1&&situation[X+2][Y] instanceof EmptySlotComponent && X+2<=7){
                    b=new ChessboardPoint(X+2,Y);
                    a.add(b);
                }
            }
            if (color==ChessColor.WHITE){
                if(situation[X-1][Y] instanceof EmptySlotComponent &&X==6&& situation[X-2][Y] instanceof EmptySlotComponent && X-2>=0){
                    b=new ChessboardPoint(X-2,Y);
                    a.add(b);
                }
            }
        }
        if(color==ChessColor.BLACK){
            if(situation[X+1][Y] instanceof EmptySlotComponent && X+1<=7){
                b=new ChessboardPoint(X+1,Y);
                a.add(b);
            }
            if(X+1<=7 && Y-1>=0 && !(situation[X+1][Y-1] instanceof EmptySlotComponent) && !(situation[X+1][Y-1].getChessColor().equals(color))){
                b=new ChessboardPoint(X+1,Y-1);
                a.add(b);
            }
            if(X+1<=7 && Y+1<=7 && !(situation[X+1][Y+1] instanceof EmptySlotComponent) && !(situation[X+1][Y+1].getChessColor().equals(color))){
                b=new ChessboardPoint(X+1,Y+1);
                a.add(b);
            }
        }
        if(color==ChessColor.WHITE){
            if(X-1>=0 && situation[X-1][Y] instanceof EmptySlotComponent){
                b=new ChessboardPoint(X-1,Y);
                a.add(b);
            }
            if(X-1>=0 && Y-1>=0 && !(situation[X-1][Y-1] instanceof EmptySlotComponent) && !(situation[X-1][Y-1].getChessColor().equals(color))){
                b=new ChessboardPoint(X-1,Y-1);
                a.add(b);
            }
            if(X-1>=0 && Y+1<=7 && !(situation[X-1][Y+1] instanceof EmptySlotComponent) && !(situation[X-1][Y+1].getChessColor().equals(color))){
                b=new ChessboardPoint(X-1,Y+1);
                a.add(b);
            }
        }
        return a;
    }
}
