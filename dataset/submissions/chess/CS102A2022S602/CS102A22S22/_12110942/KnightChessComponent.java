import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame concreteChessGame){
        this.name=name;
        setChessColor(chessColor);
        setSource(source);
        setConcreteChessGame(concreteChessGame);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
        int x=getSource().getX(),y=getSource().getY();
        ConcreteChessGame concreteChessGame=getConcreteChessGame();
        if(concreteChessGame.canadd(this,1,2)) arrayList.add(new ChessboardPoint(x+1,y+2));
        if(concreteChessGame.canadd(this,-1,2)) arrayList.add(new ChessboardPoint(x-1,y+2));
        if(concreteChessGame.canadd(this,1,-2)) arrayList.add(new ChessboardPoint(x+1,y-2));
        if(concreteChessGame.canadd(this,-1,-2)) arrayList.add(new ChessboardPoint(x-1,y-2));
        if(concreteChessGame.canadd(this,2,1)) arrayList.add(new ChessboardPoint(x+2,y+1));
        if(concreteChessGame.canadd(this,-2,1)) arrayList.add(new ChessboardPoint(x-2,y+1));
        if(concreteChessGame.canadd(this,2,-1)) arrayList.add(new ChessboardPoint(x+2,y-1));
        if(concreteChessGame.canadd(this,-2,-1)) arrayList.add(new ChessboardPoint(x-2,y-1));
        return arrayList;
    }
}