import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private boolean moved=false;

    public boolean isMoved() {
        return moved;
    }

    public void setMoved() {
        this.moved = true;
    }

    public PawnChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint){
        super();
        setChessColor(chessColor);
        setSource(chessboardPoint);
        if(chessColor==ChessColor.BLACK)name='P';
        if(chessColor==ChessColor.WHITE)name='p';

    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> cMT=new ArrayList<>();
        if(getName()=='p'){
            if(getSource().getX()>0&& getColor(getSource().getX()-1,getSource().getY())==ChessColor.NONE){
                cMT.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
                if(getSource().getX()>1&& getColor(getSource().getX()-2,getSource().getY())==ChessColor.NONE&& !moved){
                cMT.add(new ChessboardPoint(getSource().getX()-2,getSource().getY()));
                }
            }
            if(getSource().getX()>0&&getSource().getY()>0&& getColor(getSource().getX()-1,getSource().getY()-1)==ChessColor.BLACK)cMT.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
            if(getSource().getX()>0&&getSource().getY()<7&& getColor(getSource().getX()-1,getSource().getY()+1)==ChessColor.BLACK)cMT.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
        }
        if(getName()=='P'){
            if(getSource().getX()<7&& getColor(getSource().getX()+1,getSource().getY())==ChessColor.NONE){
                cMT.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
                if(getSource().getX()<6&& getColor(getSource().getX()+2,getSource().getY())==ChessColor.NONE&& !moved){
                cMT.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()));
                }
            }
            if(getSource().getX()<7&&getSource().getY()>0&& getColor(getSource().getX()+1,getSource().getY()-1)==ChessColor.WHITE)cMT.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
            if(getSource().getX()<7&&getSource().getY()<7&& getColor(getSource().getX()+1,getSource().getY()+1)==ChessColor.WHITE)cMT.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));

        }
        return cMT;
    }
}
