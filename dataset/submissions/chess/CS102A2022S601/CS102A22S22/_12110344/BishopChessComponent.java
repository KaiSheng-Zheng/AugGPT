import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> p=new ArrayList<ChessboardPoint>();
        for(int i=1;getSource().getX()+i<=7&getSource().getY()+i<=7;i++){
            p.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
        }
        for(int i=1;getSource().getX()+i<=7&getSource().getY()-i>=0;i++){
            p.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()-i));
        }
        for(int i=1;getSource().getX()-i>=0&getSource().getY()+i<=7;i++){
            p.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
        }
        for(int i=1;getSource().getX()-i>=0&getSource().getY()-i>=0;i++){
            p.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
        }
        return p;
    }
}