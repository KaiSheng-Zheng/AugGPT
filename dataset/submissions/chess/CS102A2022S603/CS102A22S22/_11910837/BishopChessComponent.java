import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BishopChessComponent extends ChessComponent{
    private final int ID=3;
    private ChessColor chessColor;
    private final boolean canCross=false;

    public ChessColor getChessColor() {
        return chessColor;
    }

    public BishopChessComponent() {
        super();
        chessColor=ChessColor.WHITE;
        name='b';
    }

    public BishopChessComponent(ChessColor chessColor) {
        super();
        if (chessColor==ChessColor.BLACK){
            name= 'B';
        }else {
            name= 'b';
        }
        this.chessColor=chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint currentLocation=this.getSource();
        List<ChessboardPoint> canMoveTo= new ArrayList<>();
        int loactionX=currentLocation.getX();
        int locationY=currentLocation.getY();

        int XPlusY=loactionX+locationY;
        for (int i=0;i<=XPlusY;i++){
            if (i!=loactionX&&ChessboardPoint.isBounded(i,XPlusY-i)){
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

    @Override
    public char getName() {
        if (chessColor==ChessColor.BLACK){
            return 'B';
        }else {
            return 'b';
        }
    }

    public String toString() {return String.valueOf(this.name);}

    public int getID() {
        return ID;
    }

}
