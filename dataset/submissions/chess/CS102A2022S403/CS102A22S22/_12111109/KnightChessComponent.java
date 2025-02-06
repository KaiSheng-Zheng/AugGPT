import java.util.ArrayList;
import java.util.List;
public class KnightChessComponent extends ChessComponent{
    public ChessComponent[][] c;
    public KnightChessComponent(){
        c = new ChessComponent[8][8];
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                c[i][j] = new ChessComponent() {
                    @Override
                    public List<ChessboardPoint> canMoveTo() {
                        return null;
                    }
                };
            }
        }
    }

    public void setC(ChessComponent[][] c) {
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                this.c[i][j] = c[i][j];
            }
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList a = new ArrayList<ChessboardPoint>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        int[] dx = {1,1,-1,-1,2,2,-2,-2};
        int[] dy = {2,-2,2,-2,1,-1,1,-1};
        for(int i=0;i<8;i++){
            int xx= x+dx[i];
            int yy = y+dy[i];
            if(xx>=8||yy>=8||xx<0||yy<0) continue;
            if(c[xx][yy].getChessColor()!=c[x][y].getChessColor()) a.add(new ChessboardPoint(xx,yy));
        }
        return a;
    }
}
