
import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(char name, ChessboardPoint source){
        setName(name);
        if(name == 'N'){
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
        int[] dx = {-1,-1,1,1,2,2,-2,-2};
        int[] dy = {-2,2,-2,2,-1,1,-1,1};
        for(int i=0;i<8;i++){
            int tmpX = x;
            int tmpY = y;
            while(true){
                tmpX += dx[i];
                tmpY += dy[i];
                if(tmpX<0||tmpX>=8||tmpY<0||tmpY>=8) break;
                L.add(now.offset(tmpX,tmpY));
            }
        }
        return L;
    }
}
