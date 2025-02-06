import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x= getSource().getX();
        int y= getSource().getY();
        List<ChessboardPoint>c=new ArrayList<>();
        c.add(new ChessboardPoint(x-2,y-1));
        c.add(new ChessboardPoint(x-2,y+1));
        c.add(new ChessboardPoint(x+2,y-1));
        c.add(new ChessboardPoint(x+2,y+1));
        c.add(new ChessboardPoint(x+1,y+2));
        c.add(new ChessboardPoint(x-1,y+2));
        c.add(new ChessboardPoint(x-1,y-2));
        c.add(new ChessboardPoint(x+1,y-2));
       ArrayList<ChessboardPoint>d=new ArrayList<>();
       for (int i=0;i<c.size();i++){
           if (c.get(i).getX()>=0&&c.get(i).getX()<=7&&c.get(i).getY()>=0&&c.get(i).getY()<=7){
               d.add(c.get(i));
           }
       }
       for (int i=0;i<d.size();i++){
           if (this.chessComponents[d.get(i).getX()][d.get(i).getY()].getChessColor()==this.chessComponents[x][y].getChessColor()){
               d.remove(d.get(i));
           }
       }
       return d;
    }
}