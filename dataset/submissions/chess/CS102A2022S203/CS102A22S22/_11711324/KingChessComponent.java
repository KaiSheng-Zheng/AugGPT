import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor chessColor,ChessboardPoint source){
        super(chessColor,source);
        if(chessColor==ChessColor.BLACK)
        this.name='K';
        else this.name='k';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int [][]base;
        base=new int[][]{{-1,0},{0,-1},{1,0},{0,1},{1,-1},{-1,1},{-1,-1},{1,1}};
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
