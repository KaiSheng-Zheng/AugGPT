import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame concreteChessGame){
        this.name=name;
        setChessColor(chessColor);
        setSource(source);
        setConcreteChessGame(concreteChessGame);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
        int x=getSource().getX(),y=getSource().getY();
        int i=1;
        ConcreteChessGame concreteChessGame=getConcreteChessGame();
        if(concreteChessGame.canadd(this,i,0)) arrayList.add(new ChessboardPoint(x+i,y));
        if(concreteChessGame.canadd(this,-i,0)) arrayList.add(new ChessboardPoint(x-i,y));
        if(concreteChessGame.canadd(this,0,-i)) arrayList.add(new ChessboardPoint(x,y-i));
        if(concreteChessGame.canadd(this,0,i)) arrayList.add(new ChessboardPoint(x,y+i));
        if(concreteChessGame.canadd(this,i,i)) arrayList.add(new ChessboardPoint(x+i,y+i));
        if(concreteChessGame.canadd(this,-i,i)) arrayList.add(new ChessboardPoint(x-i,y+i));
        if(concreteChessGame.canadd(this,i,-i)) arrayList.add(new ChessboardPoint(x+i,y-i));
        if(concreteChessGame.canadd(this,-i,-i)) arrayList.add(new ChessboardPoint(x-i,y-i));
//        ChessboardPoint.sort(arrayList);
        return arrayList;
    }
}