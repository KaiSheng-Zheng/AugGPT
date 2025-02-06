import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private int x;
    private int y;

    public KingChessComponent(int x, int y) {
        this.x = x;
        this.y = y;
    }
    private ArrayList<ChessboardPoint> ass=new ArrayList<>();
    private int[] dx={-1,-1,-1,0,0,0,1,1,1};
    private int[] dy={-1,0,1,-1,0,1,-1,0,1};
    ChessboardPoint boo=new ChessboardPoint(x,y);

    @Override
    public List<ChessboardPoint> canMoveTo() {
        boo.setX(x);
        boo.setY(y);
       for (int i=0;i<=dy.length-1;i++){
           if (boo.offset(dx[i],dy[i])!=null)
          ass.add(boo.offset(dx[i],dy[i]));
       }
       return ass;
    }
}


