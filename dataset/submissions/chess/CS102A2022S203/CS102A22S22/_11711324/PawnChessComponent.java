import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor chessColor,ChessboardPoint source){
        super(chessColor,source);
        if(chessColor==ChessColor.BLACK)
            this.name='P';
        else this.name='p';
    }
    public boolean check_clean(int sourceX, int sourceY, int targetX, int targetY){
        boolean result=true;
        if (chessComponents[targetX][targetY].getColor() != ChessColor.NONE)
            result = false;
        return result;
    }
    public boolean check_clean1(int sourceX, int sourceY, int targetX, int targetY){
        boolean result=check_clean(sourceX,sourceY,targetX,targetY);
        if(result) {
            if (chessComponents[sourceX][sourceY].getColor() != ChessColor.NONE && sourceX == 1 && targetX == 3 && chessComponents[2][sourceY].name != '_')
                result = false;
            if (chessComponents[sourceX][sourceY].getColor() != ChessColor.NONE && sourceX == 6 && targetX == 4 && chessComponents[5][sourceY].name != '_')
                result = false;
        }
        return result;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pos=new ArrayList<>();
        ChessboardPoint cp=getPoint();
        if(this.getColor()==ChessColor.BLACK){
            if(cp.getX()==1){
                if(check_clean(cp.getX(),cp.getY(),cp.getX()+1, cp.getY()))
                    pos.add(new ChessboardPoint(cp.getX()+1, cp.getY()));
                if(check_clean1(cp.getX(),cp.getY(),cp.getX()+2, cp.getY()))
                    pos.add(new ChessboardPoint(cp.getX()+2, cp.getY()));
            }
            else{
                if(cp.getX()+1<8)
                    if(check_clean(cp.getX(),cp.getY(),cp.getX()+1, cp.getY()))
                    pos.add(new ChessboardPoint(cp.getX()+1,cp.getY()));
            }
            if(cp.getY()+1<=7&&cp.getX()+1<=7&& chessComponents[cp.getX()+1][cp.getY()+1].getColor()==ChessColor.WHITE)
                    pos.add(new ChessboardPoint(cp.getX()+1, cp.getY()+1));
            if(cp.getY()-1>=0&& cp.getX()+1<=7&&chessComponents[cp.getX()+1][cp.getY()-1].getColor()==ChessColor.WHITE)
                pos.add(new ChessboardPoint(cp.getX()+1, cp.getY()-1));
        }
        else{
            if(cp.getX()==6){
                if(check_clean(cp.getX(),cp.getY(),cp.getX()-1, cp.getY()))
                pos.add(new ChessboardPoint(cp.getX()-1, cp.getY()));
                if(check_clean1(cp.getX(),cp.getY(),cp.getX()-2, cp.getY()))
                pos.add(new ChessboardPoint(cp.getX()-2, cp.getY()));
            }
            else{
                if(cp.getX()-1<0)
                    if(check_clean(cp.getX(),cp.getY(),cp.getX()-1, cp.getY()))
                    pos.add(new ChessboardPoint(cp.getX()-1,cp.getY()));
            }
            if(cp.getY()+1<=7&&cp.getX()-1>=0&& chessComponents[cp.getX()-1][cp.getY()+1].getColor()==ChessColor.BLACK)
                pos.add(new ChessboardPoint(cp.getX()-1, cp.getY()+1));
            if(cp.getY()-1>=0&&cp.getX()-1>=0&& chessComponents[cp.getX()-1][cp.getY()-1].getColor()==ChessColor.BLACK)
                pos.add(new ChessboardPoint(cp.getX()-1, cp.getY()-1));
        }
        return pos;
    }
}
