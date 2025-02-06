import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;
    public KingChessComponent(int x,int y,char name,ChessComponent[][] components){
        super(x,y,name);
        chessComponents=components;
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessboardPoint point=this.getPoint();
        for(int i = - 1;i <=  1;i++)
            for(int j = - 1;j <= 1;j++)
                if((i != 0 || j != 0) ){
                    if(point.offset(i,j)!=null)
                        chessboardPoints.add(point.offset(i,j));
                }
        Iterator<ChessboardPoint> iterator=chessboardPoints.listIterator();
        while (iterator.hasNext()) {
            ChessboardPoint delete = iterator.next();
            if (getComponent(chessComponents, getPoint()).getChessColor() == getComponent(chessComponents, delete).getChessColor())
                iterator.remove();
        }
        return chessboardPoints;
    }
}
