import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessColor chessColor,ChessboardPoint source){
        super(chessColor,source);
        if(chessColor==ChessColor.BLACK)
            this.name='B';
        else this.name='b';
    }
    public boolean check_clean(int sourceX, int sourceY, int targetX, int targetY){
        boolean result=true;
        int disx=sourceX-targetX;
        int disy=sourceY-targetY;
        int dirx = disx / Math.abs(disx);
        int diry = disy / Math.abs(disy);
        if (chessComponents[targetX][targetY].getColor() == chessComponents[sourceX][sourceY].getColor())
            result = false;
        for (int i =  1; i<Math.abs(disx); i++) {
            if (chessComponents[sourceX - i * dirx][sourceY - i * diry].name != '_') {
                result = false;
                break;
            }
        }
        return result;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint cp=this.getPoint();
        List<ChessboardPoint> pos=new ArrayList<ChessboardPoint>();
        for(int i=0;i<8;i++){
            int satsu=Math.abs(cp.getY()-i);
            if(satsu==0) continue;
            if(cp.getX()+satsu<8){
                if(check_clean(cp.getX(),cp.getY(),cp.getX()+satsu, i))
                pos.add(new ChessboardPoint(cp.getX()+satsu, i));
            }
            if(cp.getX()-satsu>=0){
                if(check_clean(cp.getX(),cp.getY(),cp.getX()-satsu, i))
                pos.add(new ChessboardPoint(cp.getX()-satsu, i));
            }
        }

        return pos;
    }

}
