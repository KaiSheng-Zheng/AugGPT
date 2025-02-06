import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private final int ID=4;
    private ChessColor chessColor;
    private final boolean canCross=true;

    public KnightChessComponent() {
        super();
        name='n';
        this.chessColor=ChessColor.WHITE;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public KnightChessComponent(ChessColor chessColor) {
        super();
        if (getChessColor()==ChessColor.BLACK){
            name= 'N';
        }else {
            name= 'n';
        }
        this.chessColor=chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint currentLocation=this.getSource();
        List<ChessboardPoint> canMoveTo= new ArrayList<>();
        int loactionX=currentLocation.getX();
        int locationY=currentLocation.getY();
        for (int i=-2;i<=2;i++){
            if (i==-2|i==2){
                if (currentLocation.offset(i,1,1)){
                    canMoveTo.add(new ChessboardPoint(currentLocation.getX()+i,currentLocation.getY()+1));
                }
                if (currentLocation.offset(i,-1,1)){
                    canMoveTo.add(new ChessboardPoint(currentLocation.getX()+i,currentLocation.getY()-1));
                }
            }else if (i==-1|i==1){
                if (currentLocation.offset(i,2,1)){
                    canMoveTo.add(new ChessboardPoint(currentLocation.getX()+i,currentLocation.getY()+2));
                }
                if (currentLocation.offset(i,-2,1)){
                    canMoveTo.add(new ChessboardPoint(currentLocation.getX()+i,currentLocation.getY()-2));

                }
            }
        }

        return canMoveTo;
    }


    public char getName() {
        if (getChessColor()==ChessColor.BLACK){
            return 'N';
        }else {
            return 'n';
        }
    }

    public String toString() {return String.valueOf(this.name);}

    public int getID() {
        return ID;
    }

}
