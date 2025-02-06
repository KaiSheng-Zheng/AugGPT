import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends  ChessComponent{
    public KnightChessComponent(ChessColor chessColor,ChessboardPoint source){
        super(chessColor,source);
        if(chessColor==ChessColor.BLACK)
            this.name='N';
        else this.name='n';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int [][]base=new int[][]{{-1,2},{2,-1},{1,2},{2,1},{-2,-1},{-2,1},{-1,-2},{1,-2}};
        ChessboardPoint cp=this.getPoint();
        List<ChessboardPoint> pos=new ArrayList<ChessboardPoint>();
        for(int i=0;i<8;i++){
            if(cp.getX()+base[i][0]<0||cp.getX()+base[i][0]>=8||cp.getY()+base[i][1]<0||cp.getY()+base[i][1]>=8)
                continue;
            else{
                if(chessComponents[cp.getX()+base[i][0]][cp.getY()+base[i][1]].getColor()==chessComponents[cp.getX()][cp.getY()].getColor())
                    continue;
                pos.add(new ChessboardPoint(base[i][0]+cp.getX(),base[i][1]+cp.getY()));
            }
        }
        return pos;
    }
}
