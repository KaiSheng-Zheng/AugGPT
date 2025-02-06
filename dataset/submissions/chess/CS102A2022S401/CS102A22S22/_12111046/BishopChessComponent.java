import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;
    public BishopChessComponent(int x,int y,char name, ChessComponent[][] components){
        super(x,y,name);
        chessComponents=components;
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessboardPoint point=this.getPoint();
        for(int i = 1;i <=8;i++)
        {
            if(point.offset(i,i)!=null)
                chessboardPoints.add(point.offset(i,i));
            if(point.offset(-1*i,i)!=null)
                chessboardPoints.add(point.offset(-1*i,i));
            if(point.offset(i,-1*i)!=null)
                chessboardPoints.add(point.offset(i,-1*i));
            if(point.offset(-1*i,-1*i)!=null)
                chessboardPoints.add(point.offset(-1*i,-1*i));

        }
        Iterator<ChessboardPoint> iterator=chessboardPoints.listIterator();
        while (iterator.hasNext()) {
            ChessboardPoint delete = iterator.next();
            if (getComponent(chessComponents, getPoint()).getChessColor() == getComponent(chessComponents, delete).getChessColor())
                iterator.remove();
        }
        iterator=chessboardPoints.listIterator();
        while (iterator.hasNext()) {
            ChessboardPoint delete = iterator.next();
            if(isDigBlocked(getPoint(),delete))
                iterator.remove();
        }
        return chessboardPoints;
    }
    private boolean isDigBlocked(ChessboardPoint source,ChessboardPoint dest){
        int i,j;
        if(source.getX()>dest.getX())
            i=-1;
        else
            i=1;
        if(source.getY()>dest.getY())
            j=-1;
        else
            j=1;
        ChessboardPoint p=source.offset(i,j);
        while(p.getX()!=dest.getX())
        {

            if(getComponent(chessComponents,p).getName()!='_')
                return true;
            p=p.offset(i,j);
        }
        return false;
    }

}
