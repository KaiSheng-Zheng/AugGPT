import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessColor white, ChessboardPoint source) {
        setChessColor(white);
        setSource(source);
        if (white.equals(ChessColor.WHITE)){
            name='q';
        }else {
            name='Q';
        }
    }

    public QueenChessComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l=new ArrayList<>();
        int[] dx={-1,-1,1,1};
        int[] dy={-1,1,1,-1};
        int nx=this.getChessboardPoint().getX();
        int ny=this.getChessboardPoint().getY();
        for(int i=0;i<4;i++){
            for(int j=1;j<9;j++) {
            if (dx[i]*j + nx < 0 || dx[i]*j + nx > 7 || dy[i] *j+ ny < 0 || dy[i]*j+ ny > 7)
                break;
            if(this.chessComponents[dx[i]*j+nx][dy[i]*j+ny].getChessColor()==this.getChessColor())
                break;
            l.add(new ChessboardPoint(dx[i]*j + nx, dy[i]*j+ ny));
            if(this.chessComponents[dx[i]*j+nx][dy[i]*j+ny].getChessColor()!=ChessColor.NONE)
                break;
            }
        }
        int[] dx1={-1,1};
        int[] dy1={-1,1};
        for(int i=0;i<2;i++){
            for(int j=1;j<9;j++) {
                if (dx1[i]*j + nx < 0 || dx1[i]*j + nx > 7)
                    break;
            if(this.chessComponents[dx1[i]*j+nx][ny].getChessColor()==this.getChessColor())
                break;
            l.add(new ChessboardPoint(dx1[i]*j + nx,ny));
            if(this.chessComponents[dx1[i]*j+nx][ny].getChessColor()!=ChessColor.NONE)
                break;
            }
        }for(int i=0;i<2;i++){
            for(int j=1;j<9;j++) {
                if ( dy1[i] *j+ ny < 0 || dy1[i]*j+ ny > 7)
                    break;
                if(this.chessComponents[nx][dy1[i]*j+ny].getChessColor()==this.getChessColor())
                    break;
                l.add(new ChessboardPoint(nx, dy1[i]*j + ny));
                if(this.chessComponents[nx][dy1[i]*j+ny].getChessColor()!=ChessColor.NONE)
                    break;
            }
        }
        return l;
    }
}
    
    

