import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l= new ArrayList<>();
        int[] dx={-1,-1,-1,0,1,1,1,0};
        int[] dy={-1,0,1,1,1,0,-1,-1};
        int nx=this.getChessboardPoint().getX();
        int ny=this.getChessboardPoint().getY();
        for(int i=0;i<8;i++){
            for(int j=1;;j++) {
                if (dx[i]*j + nx < 0 || dx[i]*j + nx > 7 || dy[i]*j + ny < 0 || dy[i]*j + ny > 7)
                    break;
                if(this.chessComponents[dx[i]*j+nx][dy[i]*j+ny].getChessColor()==this.getChessColor())
                    break;
                l.add(new ChessboardPoint(dx[i]*j + nx, dy[i]*j + ny));
                if(this.chessComponents[dx[i]*j+nx][dy[i]*j+ny].getChessColor()!=ChessColor.NONE)
                    break;
            }
        }
        return l;
    }
}
