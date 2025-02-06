import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private final int ID=2;
    private ChessColor chessColor;
    private final boolean canCross=false;

    public RookChessComponent() {
        super();
        name='r';
        this.chessColor=ChessColor.WHITE;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public RookChessComponent(ChessColor chessColor) {
        super();
        if (chessColor==ChessColor.BLACK){
            name= 'R';
        }else {
            name= 'r';
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
        return canMoveTo;
    }


    public char getName() {
        if (chessColor==ChessColor.BLACK){
            return 'R';
        }else {
            return 'r';
        }
    }

    public String toString() {return String.valueOf(this.name);}

    public int getID() {
        return ID;
    }


}
