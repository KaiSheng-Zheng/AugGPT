import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    private ChessComponent[][] c;
    public QueenChessComponent(char name,int x,int y,ChessComponent[][] c) {
        this.c=c;
        if (name == 'q') {
            this.name = name;
            this.setChessColor(ChessColor.WHITE);
            this.setSource(new ChessboardPoint( x, y));
        }
        if(name == 'Q'){
            this.name = name;
            this.setChessColor(ChessColor.BLACK);
            this.setSource(new ChessboardPoint( x, y));
        }
    }
    public  List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX(); ; int y = getSource().getY();
        this.find(x,y,1,0,list);
        this.find(x,y,-1,0,list);
        this.find(x,y,0,1,list);
        this.find(x,y,0,-1,list);
        this.find(x,y,1,1,list);
        this.find(x,y,1,-1,list);
        this.find(x,y,-1,1,list);
        this.find(x,y,-1,-1,list);
        return list;
    }
    public void find(int x, int y, int xmove,int ymove, List<ChessboardPoint> list){
        x += xmove;
        y += ymove;
        while (x>=0&&x<8&&y>=0&&y<8) {
            if (c[x][y].name == '_')
                list.add(new ChessboardPoint(x, y));
            else if (c[x][y].getChessColor() != this.getChessColor()) {
                list.add(new ChessboardPoint(x, y));
                return;
            }
            else
                return;
            x += xmove;
            y += ymove;
        }
    }
}

