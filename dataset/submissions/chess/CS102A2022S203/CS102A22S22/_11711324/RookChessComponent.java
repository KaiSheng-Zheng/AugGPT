import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor chessColor,ChessboardPoint source){
        super(chessColor,source);
        if(chessColor==ChessColor.BLACK)
            this.name='R';
        else this.name='r';
    }
    public boolean check_clean(int sourceX, int sourceY, int targetX, int targetY){
        boolean result=true;
        int disx=sourceX-targetX;
        int disy=sourceY-targetY;
        if (chessComponents[targetX][targetY].getColor() == chessComponents[sourceX][sourceY].getColor())
            result = false;
        if(disx==0){
            int diry = disy / Math.abs(disy);
            for (int i =  1; i<Math.abs(disy); i++) {
                if (chessComponents[sourceX][sourceY - i * diry].name != '_') {
                    result = false;
                    break;
                }
            }
        }
        else{
            int dirx = disx / Math.abs(disx);
            for (int i =  1; i<Math.abs(disx); i++) {
                if (chessComponents[sourceX-i*dirx][sourceY].name != '_') {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pos=new ArrayList<>();
        ChessboardPoint cp=getPoint();
        for(int i=0;i<8;i++){
            if(cp.getX()==i)
                continue;
            else {
                if (check_clean(cp.getX(),cp.getY(),i, cp.getY()))
                    pos.add(new ChessboardPoint(i, cp.getY()));
            }
        }
        for(int i=0;i<8;i++){
            if(cp.getY()==i)
                continue;
            else {
                if(check_clean(cp.getX(),cp.getY(),cp.getX(),i))
                pos.add(new ChessboardPoint(cp.getX(), i));
            }
        }
        return pos;
    }
}
