import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private final int ID=5;
    private ChessColor chessColor;

    private final boolean canCross=false;
    private int sgn;

    public PawnChessComponent() {
        super();
        name='p';
        this.chessColor=ChessColor.WHITE;
        sgn=-1;
    }

    public int getSgn() {
        return sgn;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public PawnChessComponent(ChessColor chessColor) {
        super();
        if (chessColor==ChessColor.BLACK){
            name= 'P';
            sgn=1;
        }else {
            name= 'p';
            sgn=-1;
        }
        this.chessColor=chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint currentLocation=this.getSource();

        List<ChessboardPoint> canMoveTo= new ArrayList<>();
        if (currentLocation.offset(sgn,0,1)){
            canMoveTo.add(currentLocation.offset(sgn,0));
            currentLocation.offset(-sgn,0);
        }

        if ((getSource().getX()==1&&chessColor==ChessColor.BLACK)|(getSource().getX()==6&&chessColor==ChessColor.WHITE)){
            canMoveTo.add(currentLocation.offset(2*sgn,0));
            currentLocation.offset(-2*sgn,0);

        }



        return canMoveTo;
    }


    public char getName() {
        if (chessColor==ChessColor.BLACK){
            return 'P';
        }else {
            return 'p';
        }
    }

    public String toString() {return String.valueOf(this.name);}

    public int getID() {
        return ID;
    }

}
