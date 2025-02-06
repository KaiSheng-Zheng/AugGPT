import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent (ChessboardPoint point,ChessColor color,char name){
        super(point,color,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<ChessboardPoint>();
        ChessboardPoint p = getSource();
        int x = p.getX();
        int y = p.getY();
        ChessColor color = chessComponents[x][y].getChessColor();
        if(x+1<8&&y+2<8){
            ChessboardPoint p1 = new ChessboardPoint(x+1,y+2);
            ans.add(p1);
        }
        if(x+1<8&&y-2>=0){
            ChessboardPoint p1 = new ChessboardPoint(x+1,y-2);
            ans.add(p1);
        }
        if(x-1>=0&&y+2<8){
            ChessboardPoint p1 = new ChessboardPoint(x-1,y+2);
            ans.add(p1);
        }
        if(x-1>=0&&y-2>=0){
            ChessboardPoint p1 = new ChessboardPoint(x-1,y-2);
            ans.add(p1);
        }
        if(x-2>=0&&y-1>=0){
            ChessboardPoint p1 = new ChessboardPoint(x-2,y-1);
            ans.add(p1);
        }
        if(x+2<8&&y-1>=0){
            ChessboardPoint p1 = new ChessboardPoint(x+2,y-1);
            ans.add(p1);
        }
        if(x-2>=0&&y+1<8){
            ChessboardPoint p1 = new ChessboardPoint(x-2,y+1);
            ans.add(p1);
        }
        if(x+2<8&&y+1<8){
            ChessboardPoint p1 = new ChessboardPoint(x+2,y+1);
            ans.add(p1);
        }
        ans.removeIf(P -> chessComponents[P.getX()][P.getY()].getChessColor() == color);
        return ans;
    }
}
