import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame concreteChessGame){
        this.name=name;
        setChessColor(chessColor);
        setSource(source);
        setConcreteChessGame(concreteChessGame);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
        int x=getSource().getX(),y=getSource().getY();
        int i;
        ConcreteChessGame concreteChessGame=getConcreteChessGame();
        if(getChessColor()==ChessColor.BLACK) {
            i=1;
            if(x==1)
                if(concreteChessGame.canadd(this,2,0)) arrayList.add(new ChessboardPoint(x+2,y));
        } else {
            i=-1;
            if(x==6)
                if(concreteChessGame.canadd(this,-2,0)) arrayList.add(new ChessboardPoint(x-2,y));
        }
        if(concreteChessGame.canadd(this,i,0)&&(concreteChessGame.getChess(x+i,y) instanceof EmptySlotComponent))
            arrayList.add(new ChessboardPoint(x+i,y));
        if(concreteChessGame.canadd(this,i,1)&&!(concreteChessGame.getChess(x+i,y+1) instanceof EmptySlotComponent))
            arrayList.add(new ChessboardPoint(x+i,y+1));
        if(concreteChessGame.canadd(this,i,-1)&&!(concreteChessGame.getChess(x+i,y-1) instanceof EmptySlotComponent))
            arrayList.add(new ChessboardPoint(x+i,y-1));
//        ChessboardPoint.sort(arrayList);
        return arrayList;
        }
}