import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ConcreteChessGame game;
    private ChessComponent[][] chessComponent;
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame game,ChessComponent[][] chessComponents){
        super(source, chessColor, name,game,chessComponents);
        this.source=source;
        this.chessComponent=chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList canMoveTo = new ArrayList<>();
        ChessboardPoint k = new ChessboardPoint(source.getX(),source.getY());
        int x = source.getX(),y=source.getY();int x1=x,x2=x,x3=x,x4=x,y1=y,y2=y,y3=y,y4=y;
        while (eatablePlus(x1+1,y1+1)){

            canMoveTo.add(k.offset(x1+1-source.getX(),y1+1-source.getY()));

            if (chessComponent[x1+1][y1+1].name=='_'){x1++;y1++;}
               else break;

        }
        while (eatablePlus(x2+1,y2-1)){

            canMoveTo.add(k.offset(x2+1-source.getX(),y2-1-source.getY()));


            if (chessComponent[x2+1][y2-1].name=='_'){y2--; x2++;}
              else  break;
        }
        while (eatablePlus(x3-1,y3+1)){

            canMoveTo.add(k.offset(x3-1-source.getX(),y3+1-source.getY()));


            if (chessComponent[x3-1][y3+1].name=='_'){y3++; x3--;}
              else  break;
        }
        while (eatablePlus(x4-1,y4-1)){

            canMoveTo.add(k.offset(x4-1-source.getX(),y4-1-source.getY()));


            if (chessComponent[x4-1][y4-1].name=='_'){y4--; x4--;}
               else break;
        }
        return canMoveTo;
    }
}
