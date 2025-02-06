import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;
    public  PawnChessComponent(int x,int y,char name,ChessComponent[][] components){
        super(x,y,name);
        chessComponents=components;
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessboardPoint point=this.getPoint();
        if(point.getX()==1&&this.getChessColor()==ChessColor.BLACK){
            chessboardPoints.add(point.offset(1,0));
            chessboardPoints.add(point.offset(2,0));
            if(point.offset(1,1)!=null)
                chessboardPoints.add(point.offset(1,1));
            if(point.offset(1,-1)!=null)
                chessboardPoints.add(point.offset(1,-1));
        }
        else if(point.getX()==6&&this.getChessColor()==ChessColor.WHITE){
            chessboardPoints.add(point.offset(-1,0));
            chessboardPoints.add(point.offset(-2,0));
            if(point.offset(-1,1)!=null)
                chessboardPoints.add(point.offset(-1,1));
            if(point.offset(-1,-1)!=null)
                chessboardPoints.add(point.offset(-1,-1));
        }
        else if(this.getChessColor()==ChessColor.BLACK)
        {
            if(point.offset(1,1)!=null)
                chessboardPoints.add(point.offset(1,1));
            if(point.offset(1,-1)!=null)
                chessboardPoints.add(point.offset(1,-1));
            if(point.offset(1,0)!=null)
                chessboardPoints.add(point.offset(1,0));
        }
        else {
            if(point.offset(-1,1)!=null)
                chessboardPoints.add(point.offset(-1,1));
            if(point.offset(-1,-1)!=null)
                chessboardPoints.add(point.offset(-1,-1));
            if(point.offset(-1,0)!=null)
                chessboardPoints.add(point.offset(-1,0));
        }
        Iterator<ChessboardPoint> iterator=chessboardPoints.listIterator();
        while (iterator.hasNext()){
            ChessboardPoint delete=iterator.next();
            if(getComponent(chessComponents,getPoint()).getChessColor()==getComponent(chessComponents,delete).getChessColor())
                iterator.remove();
            else if(delete.getY()!=getPoint().getY()&&getComponent(chessComponents,delete).getName()=='_')
                iterator.remove();
            else if(delete.getY()==getPoint().getY()&&getComponent(chessComponents,delete).getName()!='_')
                iterator.remove();

        }
        return chessboardPoints;
    }
}
