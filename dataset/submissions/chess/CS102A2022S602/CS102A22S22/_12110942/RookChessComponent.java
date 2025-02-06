import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame concreteChessGame){
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
        int[] a=new int[4];
        for(int i=1;i<8;i++)
        {
            ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
            if(a[0]==0&&concreteChessGame.canadd(this,i,0)) arrayList.add(new ChessboardPoint(x+i,y));
            else a[0]=1;
            if(!(concreteChessGame.getChess(x+i,y) instanceof EmptySlotComponent)) a[0]=1;
            if(a[1]==0&&concreteChessGame.canadd(this,-i,0)) arrayList.add(new ChessboardPoint(x-i,y));
            else a[1]=1;
            if(!(concreteChessGame.getChess(x-i,y) instanceof EmptySlotComponent)) a[1]=1;
            if(a[2]==0&&concreteChessGame.canadd(this,0,-i)) arrayList.add(new ChessboardPoint(x,y-i));
            else a[2]=1;
            if(!(concreteChessGame.getChess(x,y-i) instanceof EmptySlotComponent)) a[2]=1;
            if(a[3]==0&&concreteChessGame.canadd(this,0,i)) arrayList.add(new ChessboardPoint(x,y+i));
            else a[3]=1;
            if(!(concreteChessGame.getChess(x,y+i) instanceof EmptySlotComponent)) a[3]=1;
        }
//        ChessboardPoint.sort(arrayList);
        return arrayList;
    }
}