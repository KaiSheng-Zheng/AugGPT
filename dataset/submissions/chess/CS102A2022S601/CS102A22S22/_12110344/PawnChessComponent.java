import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        if(getChessColor().equals(ChessColor.NONE)){return new ArrayList<>();}
        ArrayList<ChessboardPoint> p=new ArrayList<ChessboardPoint>();
        if(getChessColor().equals(ChessColor.BLACK)){
            if(getSource().getY()==1){
                p.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
                p.add(new ChessboardPoint(getSource().getX(),getSource().getY()+2));
            }else if(getSource().getY()!=7){
                p.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
            }
        }else if(getChessColor().equals(ChessColor.WHITE)){
            if(getSource().getY()==6){
                p.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
                p.add(new ChessboardPoint(getSource().getX(),getSource().getY()-2));
            }else if(getSource().getY()!=0){
                p.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
            }
        }
        return p;
    }
}