import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x= getSource().getX();
        int y= getSource().getY();
        ArrayList<ChessboardPoint> a = new ArrayList<>();
            for (int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                        if (x+i>=0&&x+i<=7&&y+j>=0&&y+j<=7){
                            a.add(new ChessboardPoint(x+i,y+j));
                        }
                    }
                }
            List<ChessboardPoint>b=new ArrayList<>();
            for (int i=0;i<a.size();i++){
                if (this.chessComponents[a.get(i).getX()][a.get(i).getY()].getChessColor()!=chessComponents[x][y].getChessColor()){
                    b.add(a.get(i));
                }
            }
            return b;
    }
}
