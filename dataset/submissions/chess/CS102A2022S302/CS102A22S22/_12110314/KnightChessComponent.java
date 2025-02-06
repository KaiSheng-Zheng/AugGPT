import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(){
        super();
        name='N';
    }
    public KnightChessComponent(int x,int y){
        super(x, y);
        name='N';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ap=new ArrayList<>();
        {
            int dx=1;int dy=2;
            if (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
            }
        }
        {
            int dx=-1;int dy=2;
            if (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
            }
        }
        {
            int dx=1;int dy=-2;
            if (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
            }
        }
        {
            int dx=-1;int dy=-2;
            if (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
            }
        }
        {
            int dx=2;int dy=1;
            if (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
            }
        }
        {
            int dx=-2;int dy=1;
            if (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
            }
        }
        {
            int dx=2;int dy=-1;
            if (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
            }
        }
        {
            int dx=-2;int dy=-1;
            if (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
            }
        }
        return ap;
    }
}
