import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(){
        super();
        name='K';
    }
    public KingChessComponent(int x,int y){
        super(x, y);
        name='K';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ap=new ArrayList<>();
        for (int dx=-1;dx<2;dx++){
            for (int dy=-1;dy<2;dy++){
                if (dx==0&&dy==0){
                    continue;
                }
                if (valid(dx,dy)){
                    ap.add(source.xinWei(dx,dy));
                }
            }
        }
        return ap;
    }
}
