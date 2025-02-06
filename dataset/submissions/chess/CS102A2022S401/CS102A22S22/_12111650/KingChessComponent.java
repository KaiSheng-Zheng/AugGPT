import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint point,ChessColor color,char name){
        super(point,color,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<ChessboardPoint>();
       ChessboardPoint p = getSource();
       int x = p.getX();
       int y = p.getY();
       ChessColor color = chessComponents[x][y].getChessColor();
       if(x-1>=0&&x+1<8){
           ChessboardPoint p1 = new ChessboardPoint(x+1,y);
           ChessboardPoint p2 = new ChessboardPoint(x-1,y);
           ans.add(p1);
           ans.add(p2);
           if(y-1>=0&&y+1<8){
               ChessboardPoint p3 = new ChessboardPoint(x,y-1);
               ChessboardPoint p4 = new ChessboardPoint(x,y+1);
               ChessboardPoint p5 = new ChessboardPoint(x+1,y-1);
               ChessboardPoint p6 = new ChessboardPoint(x+1,y+1);
               ChessboardPoint p7 = new ChessboardPoint(x-1,y+1);
               ChessboardPoint p8 = new ChessboardPoint(x-1,y-1);
               ans.add(p3);ans.add(p4);ans.add(p5);ans.add(p6);ans.add(p7);ans.add(p8);
           }
           else if(y-1<0){
               ChessboardPoint p4 = new ChessboardPoint(x,y+1);
               ChessboardPoint p6 = new ChessboardPoint(x+1,y+1);
               ChessboardPoint p7 = new ChessboardPoint(x-1,y+1);
               ans.add(p4);;ans.add(p6);ans.add(p7);
           }
           else {
               ChessboardPoint p3 = new ChessboardPoint(x,y-1);
               ChessboardPoint p5 = new ChessboardPoint(x+1,y-1);
               ChessboardPoint p8 = new ChessboardPoint(x-1,y-1);
               ans.add(p3);ans.add(p5);ans.add(p8);
           }
       }
       else if(x-1<0){
           ChessboardPoint p1 = new ChessboardPoint(x+1,y);
           ans.add(p1);
           if(y-1>=0&&y+1<8){
               ChessboardPoint p3 = new ChessboardPoint(x,y-1);
               ChessboardPoint p4 = new ChessboardPoint(x,y+1);
               ChessboardPoint p5 = new ChessboardPoint(x+1,y-1);
               ChessboardPoint p6 = new ChessboardPoint(x+1,y+1);
               ans.add(p3);ans.add(p4);ans.add(p5);ans.add(p6);
           }
           else if(y-1<0){
               ChessboardPoint p4 = new ChessboardPoint(x,y+1);
               ChessboardPoint p6 = new ChessboardPoint(x+1,y+1);
               ans.add(p4);;ans.add(p6);
           }
           else {
               ChessboardPoint p3 = new ChessboardPoint(x,y-1);
               ChessboardPoint p5 = new ChessboardPoint(x+1,y-1);
               ans.add(p3);ans.add(p5);
           }
       }
       else {
           ChessboardPoint p2 = new ChessboardPoint(x-1,y);
           ans.add(p2);
           if(y-1>=0&&y+1<8){
               ChessboardPoint p3 = new ChessboardPoint(x,y-1);
               ChessboardPoint p4 = new ChessboardPoint(x,y+1);
               ChessboardPoint p7 = new ChessboardPoint(x-1,y+1);
               ChessboardPoint p8 = new ChessboardPoint(x-1,y-1);
               ans.add(p3);ans.add(p4);ans.add(p7);ans.add(p8);
           }
           else if(y-1<0){
               ChessboardPoint p4 = new ChessboardPoint(x,y+1);
               ChessboardPoint p7 = new ChessboardPoint(x-1,y+1);
               ans.add(p4);ans.add(p7);
           }
           else {
               ChessboardPoint p3 = new ChessboardPoint(x,y-1);
               ChessboardPoint p8 = new ChessboardPoint(x-1,y-1);
               ans.add(p3);ans.add(p8);
           }
       }
        ans.removeIf(P -> chessComponents[P.getX()][P.getY()].getChessColor() == color);
       return ans;
    }
}
