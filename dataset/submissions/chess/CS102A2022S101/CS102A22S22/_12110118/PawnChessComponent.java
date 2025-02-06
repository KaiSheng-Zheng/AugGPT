import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessComponent[][] chessComponent;
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame game,ChessComponent[][] chessComponent){
        super(source, chessColor, name,game,chessComponent);
        this.source=source;
        this.chessComponent=chessComponent;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList canMoveTo = new ArrayList<>();
        ChessboardPoint k = new ChessboardPoint(source.getX(),source.getY());
        int x = source.getX(),y=source.getY();
        if (this.getChessColor() == ChessColor.BLACK) {
            if (eatablePlus(x+1,y+1)&&chessComponent[x+1][y+1].name>97)
                canMoveTo.add(k.offset(1,1));
            if (eatablePlus(x+1,y-1)&&chessComponent[x+1][y-1].name>97)
                canMoveTo.add(k.offset(1,-1));
            if (eatablePlus(x+1,y)&&chessComponent[x+1][y].name=='_')
                canMoveTo.add(k.offset(1,0));
            if (eatablePlus(x+1,y)&&chessComponent[x+1][y].name=='_'&&x==1&&eatablePlus(x+2,y)&&chessComponent[x+2][y].name=='_')
                canMoveTo.add(k.offset(2,0));
        }
        if (this.getChessColor()==ChessColor.WHITE) {
            if (eatablePlus(x-1,y+1)&&chessComponent[x-1][y+1].name<91)
                canMoveTo.add(k.offset(-1,1));
            if (eatablePlus(x-1,y-1)&&chessComponent[x-1][y-1].name<91)
                canMoveTo.add(k.offset(-1,-1));
            if (eatablePlus(x-1,y)&&chessComponent[x-1][y].name=='_')
                canMoveTo.add(k.offset(-1,0));
            if (eatablePlus(x-1,y)&&chessComponent[x-1][y].name=='_'&&x==6&&eatablePlus(x-2,y)&&chessComponent[x-2][y].name=='_')
                canMoveTo.add(k.offset(-2,0));
        }
        return canMoveTo;
    }
}
