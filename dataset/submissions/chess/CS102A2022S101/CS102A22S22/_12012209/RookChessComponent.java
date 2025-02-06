import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private int x;
    private int y;
    private char f;

    public RookChessComponent(int x, int y,char f) {
        this.x = x;
        this.y = y;
        this.f=f;
    }
    private ArrayList<ChessboardPoint> ass=new ArrayList<>();
    ChessboardPoint boo=new ChessboardPoint(x,y);

    @Override
    public List<ChessboardPoint> canMoveTo() {
        boo.setX(x);
        boo.setY(y);

        if (f=='R'){
            int i;
            for (i=-7;i<=7;i++){
                if(i==0)
                {
                    continue;
                }
                if (boo.offset(0,i)!=null) ass.add(boo.offset(0,i));
                else  break;
            }
            if (x>=0&&x<=7&&y+i>=0&&y+i<=7&&('a'<ConcreteChessGame.chessComponents[x][y+i].name)&&(ConcreteChessGame.chessComponents[x][y+i].name<'z')){
                ass.add(new ChessboardPoint(x,y+i));
            }

            for (i=-7;i<=7;i++){
                if(i==0)
                {
                    continue;
                }
                if (boo.offset(i,0)!=null) ass.add(boo.offset(i,0));
                else  break;
            }
            if (x+i>=0&&x+i<=7&&y>=0&&y<=7&&('a'<ConcreteChessGame.chessComponents[x+i][y].name)&&(ConcreteChessGame.chessComponents[x+i][y].name<'z')){
                ass.add(new ChessboardPoint(x+i,y));
            }
        }
        if (f=='r'){
            int i;
            for (i=-7;i<=7;i++){
                if(i==0)
                {
                    continue;
                }
                if (boo.offset(0,i)!=null) ass.add(boo.offset(0,i));
                else  break;
            }
            if (x>=0&&x<=7&&y+i>=0&&y+i<=7&&('A'<ConcreteChessGame.chessComponents[x][y+i].name)&&(ConcreteChessGame.chessComponents[x][y+i].name<'Z')){
                ass.add(new ChessboardPoint(x,y+i));
            }

            for (i=-7;i<=7;i++){
                if(i==0)
                {
                    continue;
                }
                if (boo.offset(i,0)!=null) ass.add(boo.offset(i,0));
                else  break;
            }
            if (x+i>=0&&x+i<=7&&y>=0&&y<=7&&('A'<ConcreteChessGame.chessComponents[x+i][y].name)&&(ConcreteChessGame.chessComponents[x+i][y].name<'Z')){
                ass.add(new ChessboardPoint(x+i,y));
            }
        }
        return ass;
    }
}