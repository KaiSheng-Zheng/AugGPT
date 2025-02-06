import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class KnightChessComponent extends ChessComponent{
    private static int[][] nmoves={{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=this.getSource();
        ChessboardPoint nc=null;
        List<ChessboardPoint> a=new ArrayList();

        for(int i=0;i<8;i++){
            nc=this.getSource().offset(nmoves[i][0],nmoves[i][1]);
            if(nc==null) continue;
            a.add(nc);
        }
        List<ChessboardPoint> b=new ArrayList<>();
        for(int i=0;i<a.size();i++){
            if(canmoveChess(source.getX(),source.getY(), a.get(i).getX(),a.get(i).getY())){
                b.add(a.get(i));

            }
        }
        Collections.sort(b);
        return b;
    }
}
