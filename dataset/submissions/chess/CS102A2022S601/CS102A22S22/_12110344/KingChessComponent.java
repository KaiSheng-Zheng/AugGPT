import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> p=new ArrayList<ChessboardPoint>();
        if(judgeIfOut(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1))){
            p.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
        }
        if(judgeIfOut(new ChessboardPoint(getSource().getX()-1,getSource().getY()))){
            p.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
        }
        if(judgeIfOut(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1))){
            p.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
        }
        if(judgeIfOut(new ChessboardPoint(getSource().getX(),getSource().getY()-1))){
            p.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
        }
        if(judgeIfOut(new ChessboardPoint(getSource().getX(),getSource().getY()+1))){
            p.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
        }
        if(judgeIfOut(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1))){
            p.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
        }
        if(judgeIfOut(new ChessboardPoint(getSource().getX()+1,getSource().getY()))){
            p.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
        }
        if(judgeIfOut(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1))){
            p.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
        }
        return p;
    }
    public boolean judgeIfOut(ChessboardPoint a){
        if(a.getX()<0|a.getX()>7|a.getY()<0|a.getY()>7){
            return false;
        }
        return true;
    }
}