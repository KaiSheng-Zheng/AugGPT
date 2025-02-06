import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(ChessColor white, ChessboardPoint source) {
        setChessColor(white);
        setSource(source);
        if (white.equals(ChessColor.WHITE)){
            name='k';
        }else {
            name='K';
        }
    }
    public KingChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l= new ArrayList<>();
        int[] dx={-1,-1,1,1};
        int[] dy={-1,1,1,-1};
        int[] dx1={-1,1};
        int[] dy1={-1,1};

        int nx=this.getChessboardPoint().getX();
        int ny=this.getChessboardPoint().getY();
        for(int i=0;i<4;i++){
                if (dx[i] + nx < 0 || dx[i]+ nx > 7 || dy[i] + ny < 0 || dy[i]+ ny > 7)
                    continue;
                if(this.chessComponents[dx[i]+nx][dy[i]+ny].getChessColor()==this.getChessColor())
                    continue;
                l.add(new ChessboardPoint(dx[i]+ nx, dy[i]+ ny));
                if(this.chessComponents[dx[i]+nx][dy[i]+ny].getChessColor()!=ChessColor.NONE)
                    continue;
        }

        for(int j=0;j<2;j++){
                if (dx1[j] + nx < 0 || dx1[j]+ nx > 7 )
                    continue;
                if(this.chessComponents[dx1[j]+nx][ny].getChessColor()!=this.getChessColor())
                l.add(new ChessboardPoint(dx1[j]+ nx,ny));
                if(this.chessComponents[dx1[j]+nx][ny].getChessColor()!=ChessColor.NONE)
                    continue;
                }
        for(int k=0;k<2;k++){
                if (dy1[k] + ny < 0 || dy1[k]+ ny > 7)
                    continue;
                if(this.chessComponents[nx][dy1[k]+ny].getChessColor()!=this.getChessColor())
                l.add(new ChessboardPoint(nx, dy1[k]+ ny));
                if(this.chessComponents[nx][dy1[k]+ny].getChessColor()!=ChessColor.NONE)
                    continue;
            }
        return l;
    }
}



