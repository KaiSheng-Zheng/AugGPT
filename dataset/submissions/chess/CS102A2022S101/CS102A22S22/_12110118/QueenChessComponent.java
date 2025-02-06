import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessColor chessColor;
    private ChessboardPoint source;
    private ChessComponent[][] chessComponent;
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame game,ChessComponent[][] chessComponents){
        super(source, chessColor, name,game,chessComponents);
        this.source=source;
        this.chessColor=chessColor;
        this.chessComponent=chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList canMoveTo = new ArrayList<>();
        ChessboardPoint k = new ChessboardPoint(source.getX(),source.getY());
        int x = source.getX(),y=source.getY();int x1=x,x2=x,x3=x,x4=x,y1=y,y2=y,y3=y,y4=y;int x11=x,x22=x,x33=x,x44=x,y11=y,y22=y,y33=y,y44=y;
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
        while (y1+1<8&&eatablePlus(x11,y11+1)){ // should be y11+1<8, not y1+1<8
            canMoveTo.add(k.offset(x11-source.getX(),y11+1-source.getY()));
            if (chessComponent[x11][y11+1].name=='_')y11++;
            else break;

        }
        while (y22-1>=0&&eatablePlus(x22,y22-1)){
            canMoveTo.add(k.offset(x22-source.getX(),y22-1-source.getY()));
            if (chessComponent[x22][y22-1].name=='_')
                y22--;
            else break;
        }
        while (x33+1<8&&eatablePlus(x33+1,y33)){
            canMoveTo.add(k.offset(x33+1-source.getX(),y33-source.getY()));
            if (chessComponent[x33+1][y33].name=='_')
                x33++;
            else break;
        }
        while (x44-1>=0&&eatablePlus(x44-1,y44)){
            canMoveTo.add(k.offset(x44-1-source.getX(),y44-source.getY()));
            if (chessComponent[x44-1][y44].name=='_')
                x44--;
            else break;
        }


        return canMoveTo;
    }
}
