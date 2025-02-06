import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=this.getSource();
        List<ChessboardPoint> a=new ArrayList<>();
        ChessboardPoint nc;
        for(int i=1;i<=7;i++){
            nc=source.offset(i,0);
            if(nc==null) break;
            a.add(nc);
        }

        for(int i=-1;i>=-7;i--){
            nc=source.offset(i,0);
            if(nc==null) break;
            a.add(nc);
        }
        for(int i=1;i<=7;i++){
            nc=source.offset(0,i);
            if(nc==null) break;
            a.add(nc);
        }
        for(int i=-1;i>=-7;i--){
            nc=source.offset(0,i);
            if(nc==null) break;
            a.add(nc);
        }

        for(int i=1;i<=7;i++){
            nc=source.offset(i,-i);
            if(nc==null) break;
            a.add(nc);
        }
        for(int i=1;i<=7;i++){
            nc=source.offset(i,i);
            if(nc==null) break;
            a.add(nc);
        }
        for(int i=1;i<=7;i++){
            nc=source.offset(-i,i);
            if(nc==null) break;
            a.add(nc);
        }
        for(int i=1;i<=7;i++){
            nc=source.offset(-i,-i);
            if(nc==null) break;
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
