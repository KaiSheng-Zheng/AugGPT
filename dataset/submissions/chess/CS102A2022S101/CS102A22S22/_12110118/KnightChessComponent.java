import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame game,ChessComponent[][] chessComponents){
        super(source, chessColor, name,game,chessComponents);
        this.source=source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList canMoveTo = new ArrayList<>();
        ChessboardPoint k = new ChessboardPoint(source.getX(),source.getY()),a=new ChessboardPoint(source.getX()+1,source.getY()+2),
                b=new ChessboardPoint(source.getX()+2,source.getY()+1),c=new ChessboardPoint(source.getX()+2,source.getY()-1),
                d=new ChessboardPoint(source.getX()+1,source.getY()-2),e=new ChessboardPoint(source.getX()-1,source.getY()+2)
                ,f=new ChessboardPoint(source.getX()-1,source.getY()-2),g=new ChessboardPoint(source.getX()-2,source.getY()+1),h=new ChessboardPoint(source.getX()-2,source.getY()-1);
        ChessboardPoint[]chessboardPoints={a,b,c,d,e,f,g,h};
       for (ChessboardPoint i:chessboardPoints){
           canMoveTo.add(i);
                if (k.offset(i.getX()-source.getX(),i.getY()-source.getY())==null)
                    canMoveTo.remove(i);
                if (eatablePlus(i.getX(), i.getY())!=true)
                    canMoveTo.remove(i);



            }
        return canMoveTo;
    }
}
