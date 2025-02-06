import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor white, ChessboardPoint source) {
        setChessColor(white);
        setSource(source);
        if (white.equals(ChessColor.WHITE)){
            name='n';
        }else {
            name='N';
        }
    }
    public KnightChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l= new ArrayList<>();
        int[] dx={-1,-2,-2,-1,1,2,2,1};
        int[] dy={-2,-1,1,2,2,1,-1,-2};
        int nx=this.getChessboardPoint().getX();
        int ny=this.getChessboardPoint().getY();
        for(int i=0;i<8;i++){
            if (dx[i] + nx < 0 || dx[i] + nx > 7 || dy[i] + ny < 0 || dy[i] + ny > 7)
                continue;
            if(this.getChessColor()==this.chessComponents[dx[i]+nx][dy[i]+ny].getChessColor())
                continue;
            l.add(new ChessboardPoint(dx[i] + nx, dy[i] + ny));
        }
        return l;
    }
}

