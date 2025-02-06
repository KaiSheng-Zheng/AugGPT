import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessComponent[][] c;
    public KnightChessComponent(char name,int x,int y, ChessComponent[][] c) {
        this.c=c;
        if (name == 'n') {
            this.name = name;
            this.setChessColor(ChessColor.WHITE);
            this.setSource(new ChessboardPoint( x, y));
        }
        if(name == 'N'){
            this.name = name;
            this.setChessColor(ChessColor.BLACK);
            this.setSource(new ChessboardPoint( x, y));
        }
    }
    public  List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX(); ; int y = getSource().getY();
        this.find(x,y,1,2,list);
        this.find(x,y,1,-2,list);
        this.find(x,y,-1,2,list);
        this.find(x,y,-1,-2,list);
        this.find(x,y,2,1,list);
        this.find(x,y,-2,1,list);
        this.find(x,y,2,-1,list);
        this.find(x,y,-2,-1,list);
        return list;
    }
    public void find(int x, int y, int xmove,int ymove, List<ChessboardPoint> list){
        int X = x+xmove;
        int Y = y+ymove;
        if(X>=0&&X<8&&Y>=0&&Y<8){
            if (c[X][Y].name == '_')
                list.add(new ChessboardPoint(X, Y));
            else if (c[X][Y].getChessColor() != this.getChessColor())
                list.add(new ChessboardPoint(X, Y));
        }
    }
}
