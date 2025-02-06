import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private final int ID=1;
    private ChessColor chessColor;
    private final boolean canCross=false;

    public QueenChessComponent() {
        super();
        name='q';
        chessColor=ChessColor.WHITE;
    }

    public QueenChessComponent(ChessColor chessColor){
        super();
        if (chessColor==ChessColor.BLACK){
            name= 'Q';
        }else {
            name= 'q';
        }
        this.chessColor=chessColor;

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint currentLocation=this.getSource();
        List<ChessboardPoint> canMoveTo= new ArrayList<>();
        int loactionX=currentLocation.getX();
        int locationY=currentLocation.getY();
        for (int i=0;i<=7;i++){
            if (i!=locationY){
                canMoveTo.add(new ChessboardPoint(loactionX,i));
            }
            if (i!=loactionX){
                canMoveTo.add(new ChessboardPoint(i,locationY));
            }


        }
        int XPlusY=loactionX+locationY;
        for (int i=0;i<=XPlusY;i++){
            if (!(i==loactionX&&i==locationY)&&ChessboardPoint.isBounded(i,XPlusY-i)){
                canMoveTo.add(new ChessboardPoint(i,XPlusY-i));
            }
        }

        int XMinusY=loactionX-locationY;
        if (XMinusY>=0){
            for (int i=0;i<=7-XMinusY;i++){
                if (i!=locationY){
                    canMoveTo.add(new ChessboardPoint(i+XMinusY,i));
                }
            }
        }else {
            for (int i=0;i<=7+XMinusY;i++){
                if (i!=loactionX){
                    canMoveTo.add(new ChessboardPoint(i,i-XMinusY));
                }

            }
        }

        return canMoveTo;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }


    public char getName() {
        if (chessColor==ChessColor.BLACK){
            return 'Q';
        }else {
            return 'q';
        }
    }

    public String toString() {return String.valueOf(this.name);}



    public int getID() {
        return ID;
    }

}
