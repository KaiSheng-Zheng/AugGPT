import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private final int ID=0;
    private ChessColor chessColor;
    private final boolean canCross=true;


    public ChessColor getChessColor() {
        return chessColor;
    }

    public KingChessComponent() {
        super();
        name='k';
        this.chessColor=ChessColor.WHITE;
    }

    public KingChessComponent(ChessColor chessColor) {
        super();
        if (chessColor==ChessColor.BLACK){
            name= 'K';
        }else {
            name= 'k';
        }
        this.chessColor=chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint currentLocation=this.getSource();
        List<ChessboardPoint> canMoveTo= new ArrayList<>();
        for (int i=-1;i<=1;i++){
            for (int j=-1;j<=1;j++){
                if (currentLocation.offset(i,j,1)&&!(i==0&&j==0)){
                    canMoveTo.add(currentLocation.offset(i,j));
                    currentLocation.offset(-i,-j);
                }
            }
        }
        return canMoveTo;
    }


    public char getName() {
        if (chessColor==ChessColor.BLACK){
            return 'K';
        }else {
            return 'k';
        }
    }

    public String toString() {return String.valueOf(this.name);}

    @Override
    public int getID() {
        return ID;
    }

}
