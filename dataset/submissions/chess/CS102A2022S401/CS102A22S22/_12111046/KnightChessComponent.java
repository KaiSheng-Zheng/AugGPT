import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;
    public KnightChessComponent(int x,int y,char name,ChessComponent[][] components){
        super(x,y,name);
        chessComponents=components;
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessboardPoint point=this.getPoint();
        for(int i = - 2;i <=  2;i++)
            for(int j = - 2;j <=  2;j++)
                if((Math.abs(i) * Math.abs(j) == 2)&& point.offset(i,j)!=null)
                    chessboardPoints.add(point.offset(i,j));
        Iterator<ChessboardPoint> iterator=chessboardPoints.listIterator();
        while (iterator.hasNext()) {
            ChessboardPoint delete = iterator.next();
            if (getComponent(chessComponents, getPoint()).getChessColor() == getComponent(chessComponents, delete).getChessColor())
                iterator.remove();
        }
        return chessboardPoints;
    }

}

