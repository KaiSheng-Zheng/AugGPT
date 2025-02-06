import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> P = new ArrayList<>();
        if (getChessColor()==ChessColor.BLACK&&getSource().getX()==1){
             P.add(getSource().offset(1,0));
             P.add(getSource().offset(2,0));
         }
        if (getChessColor()==ChessColor.BLACK&&getSource().getX()!=1){
            P.add(getSource().offset(1,0));
        }
        else if (getChessColor()==ChessColor.WHITE&&getSource().getX()==6){
            P.add(getSource().offset(-1,0));
            P.add(getSource().offset(-2,0));
        }
        else if (getChessColor()==ChessColor.WHITE&&getSource().getX()!=6){
            P.add(getSource().offset(-1,0));
        }
        return P;
    }
}
