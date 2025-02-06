import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessComponent[][] chessComponent;
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame game,ChessComponent[][] chessComponents){
        super(source, chessColor, name,game,chessComponents);
        this.source=source;
        this.chessComponent=chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList canMoveTo = new ArrayList<>();
        ChessboardPoint k = new ChessboardPoint(source.getX(),source.getY());
        int x = source.getX(),y=source.getY();int x1=x,x2=x,x3=x,x4=x,y1=y,y2=y,y3=y,y4=y;
        while (y1+1<8&&eatablePlus(x1,y1+1)){
            canMoveTo.add(k.offset(x1-source.getX(),y1+1-source.getY()));
           if (chessComponent[x1][y1+1].name!='_')
            break;y1++;

        }
        while (y2-1>=0&&eatablePlus(x2,y2-1)){
            canMoveTo.add(k.offset(x2-source.getX(),y2-1-source.getY()));
            if (chessComponent[x2][y2-1].name=='_')
            y2--;
            else break;
        }
        while (x3+1<8&&eatablePlus(x3+1,y3)){
            canMoveTo.add(k.offset(x3+1-source.getX(),y3-source.getY()));
            if (chessComponent[x3+1][y3].name=='_')
            x3++;
            else break;
        }
        while (x4-1>=0&&eatablePlus(x4-1,y4)){
            canMoveTo.add(k.offset(x4-1-source.getX(),y4-source.getY()));
            if (chessComponent[x4-1][y4].name=='_')
            x4--;
            else break;
        }


        return canMoveTo;
    }
}