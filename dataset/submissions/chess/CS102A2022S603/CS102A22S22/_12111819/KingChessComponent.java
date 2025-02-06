
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(char name, ChessboardPoint source){
        setName(name);
        if(name == 'K'){
            setChessColor(ChessColor.BLACK);
        }else {
            setChessColor(ChessColor.WHITE);
        }
        setSource(source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> L = new ArrayList<>();
        ChessboardPoint now = getSource();
        int x = now.getX();
        int y = now.getY();
        int[] dx = {-1,0,1,-1,1,-1,0,1};
        int[] dy = {-1,-1,-1,0,0,1,1,1};
        for(int i=0;i<8;i++){
            if(x+dx[i]>=0 && x+dx[i]<8 && y+dy[i]>=0 && y+dy[i]<8){
                L.add(now.offset(x+dx[i],y+dy[i]));
            }
        }
        return L;
    }
}
