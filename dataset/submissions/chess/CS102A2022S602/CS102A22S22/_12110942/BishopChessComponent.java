import java.util.ArrayList;
import java.util.List;


public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame concreteChessGame){
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
        int[] a=new int[8];
        for(int i=1;i<8;i++)
        {
            if(a[4]==0&&concreteChessGame.canadd(this,i,i)) arrayList.add(new ChessboardPoint(x+i,y+i));
            else a[4]=1;
            if(!(concreteChessGame.getChess(x+i,y+i) instanceof EmptySlotComponent)) a[4]=1;
            if(a[5]==0&&concreteChessGame.canadd(this,-i,i)) arrayList.add(new ChessboardPoint(x-i,y+i));
            else a[5]=1;
            if(!(concreteChessGame.getChess(x-i,y+i) instanceof EmptySlotComponent)) a[5]=1;
            if(a[6]==0&&concreteChessGame.canadd(this,i,-i)) arrayList.add(new ChessboardPoint(x+i,y-i));
            else a[6]=1;
            if(!(concreteChessGame.getChess(x+i,y-i) instanceof EmptySlotComponent)) a[6]=1;
            if(a[7]==0&&concreteChessGame.canadd(this,-i,-i)) arrayList.add(new ChessboardPoint(x-i,y-i));
            else a[7]=1;
            if(!(concreteChessGame.getChess(x-i,y-i) instanceof EmptySlotComponent)) a[7]=1;
        }
        return arrayList;
    }
}