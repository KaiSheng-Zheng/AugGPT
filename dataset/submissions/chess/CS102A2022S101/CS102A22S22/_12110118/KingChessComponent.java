
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ConcreteChessGame game;
    private ChessColor chessColor;
    private ChessComponent[][]chessComponents;
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame game, ChessComponent[][] chessComponents){
        super(source, chessColor, name,game,chessComponents);
        this.source=source;
        this.name=name;
        this.game=game;
        this.chessComponents=chessComponents;
        this.chessColor=chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList canMoveTo = new ArrayList<>();
        ChessboardPoint k = new ChessboardPoint(source.getX(), source.getY());
        int x = source.getX(), y = source.getY();
        ChessboardPoint a=new ChessboardPoint(x-1,y-1);canMoveTo.add(a);
        ChessboardPoint b=new ChessboardPoint(x-1,y);canMoveTo.add(b);
        ChessboardPoint c=new ChessboardPoint(x-1,y+1);canMoveTo.add(c);
        ChessboardPoint d=new ChessboardPoint(x,y-1);canMoveTo.add(d);
        ChessboardPoint e=new ChessboardPoint(x,y+1);canMoveTo.add(e);
        ChessboardPoint f=new ChessboardPoint(x+1,y-1);canMoveTo.add(f);
        ChessboardPoint g=new ChessboardPoint(x+1,y);canMoveTo.add(g);
        ChessboardPoint h=new ChessboardPoint(x+1,y+1);canMoveTo.add(h);
        ChessboardPoint[]all={a,b,c,d,e,f,g,h};
        for (ChessboardPoint i:all){
            int m= i.getX();int n= i.getY();
            if (k.offset(i.getX()-x,i.getY()-y)==null)
                canMoveTo.remove(i);
            if (eatablePlus(i.getX(), i.getY())!=true)
                canMoveTo.remove(i);


               // if (k.offset(i-x,j-y)==null||chessColor==getChessColor(game.getChess(i,j)))
                 //   canMoveTo.remove(new ChessboardPoint(i,j));

        }
    return canMoveTo;

}}
