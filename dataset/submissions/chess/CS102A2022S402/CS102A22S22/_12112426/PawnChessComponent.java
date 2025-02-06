import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor white, ChessboardPoint source) {
        setChessColor(white);
        setSource(source);
        if (white.equals(ChessColor.WHITE)){
            name='p';
        }else {
            name='P';
        }
    }
    public PawnChessComponent() {}

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l= new ArrayList<>();
        int[] dy={1};
        int nx=this.getChessboardPoint().getX();
        int ny=this.getChessboardPoint().getY();
        for(int i=0;i<1;i++){
            if (nx==6||nx==1){
                    for(int k=0;k<1;k++){
                        for(int j=1;j<3;j++) {
                            if (dy[k]*j + ny < 0 || dy[k]*j + ny > 7)
                                break;
                            if(this.chessComponents[nx][dy[k]*j+ny].getChessColor()==this.getChessColor())
                                break;
                            l.add(new ChessboardPoint(nx, dy[k]*j + ny));
                            if(this.chessComponents[nx][dy[k]*j+ny].getChessColor()!=ChessColor.NONE)
                                break;
                        }
                }
            }else {
                if (dy[i] + ny < 0 || dy[i] + ny > 7)
                   continue;

                if(this.chessComponents[nx][dy[i]+ny].getChessColor()==ChessColor.NONE)
                    l.add(new ChessboardPoint(nx, dy[i]+ ny));
                if(nx-1>=0)
                    if(this.chessComponents[nx-1][dy[i]+ny].getChessColor()!=this.getChessColor())
                        l.add(new ChessboardPoint(nx-1, dy[i]+ ny));
                if(nx+1<=7)
                if(this.chessComponents[nx+1][dy[i]+ny].getChessColor()!=this.getChessColor())
                    l.add(new ChessboardPoint(nx+1, dy[i]+ ny));
            }
        }
        return l;
    }
}


