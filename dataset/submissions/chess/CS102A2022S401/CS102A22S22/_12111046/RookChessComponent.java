import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;
    RookChessComponent(int x,int y,char name,ChessComponent[][] components){
        super(x,y,name);
        chessComponents=components;
    }
    public List<ChessboardPoint> canMoveTo(){

        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessboardPoint point=this.getPoint();
        for(int i = 1;i <=8;i++)
        {

            if(point.offset(i,0)!=null)
                chessboardPoints.add(point.offset(i,0));
            if(point.offset(0,i)!=null)
                chessboardPoints.add(point.offset(0,i));
            if(point.offset(-1*i,0)!=null)
                chessboardPoints.add(point.offset(-1*i,0));
            if(point.offset(0,-1*i)!=null)
                chessboardPoints.add(point.offset(0,-1*i));

        }
        Iterator<ChessboardPoint> iterator=chessboardPoints.listIterator();
        while (iterator.hasNext()) {
            ChessboardPoint delete = iterator.next();
            if (getComponent(chessComponents, getPoint()).getChessColor() == getComponent(chessComponents, delete).getChessColor())
                iterator.remove();
            else if(!isValidRockMove(getPoint(),delete))
                iterator.remove();
        }
        return chessboardPoints;
    }
    private boolean isValidRockMove(ChessboardPoint source,ChessboardPoint dest){
        if(dest.getY()==source.getY()){
            if(Math.abs(source.getX()-dest.getX())==1)
                return true;
            if(source.getX()>dest.getX()){
                for(int i=source.getX()-1;i>dest.getX();i--){
                    if(getComponent(chessComponents,new ChessboardPoint(i,source.getY())).getName()!='_')
                        return false;
                }
            }
            else
            {
                for(int i=source.getX()+1;i<dest.getX();i++){
                    if(getComponent(chessComponents,new ChessboardPoint(i,source.getY())).getName()!='_')
                        return false;
                }
            }
        }
        else{
            if(Math.abs(source.getY()-dest.getY())==1)
                return true;
            if(source.getY()>dest.getY()){
                for(int i=source.getY()-1;i>dest.getY();i--){
                    if(getComponent(chessComponents,new ChessboardPoint(source.getX(),i)).getName()!='_')
                        return false;
                }
            }
            else
            {
                for(int i=source.getY()+1;i<dest.getY();i++){
                    if(getComponent(chessComponents,new ChessboardPoint(source.getX(),i)).getName()!='_')
                        return false;
                }
            }
        }
        return true;
    }

}
