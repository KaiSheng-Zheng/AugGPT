import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public boolean canmoveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(sourceX>7||sourceY>7||targetX>7||targetY>7) return false;
        if(sourceX<0||sourceY<0||targetX<0||targetY<0) return false;
        if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()) return false;



            if(sourceY==targetY&&Math.abs(targetX-sourceX)==1){
               if(this.chessComponents[targetX][targetY].getChessColor()!=ChessColor.NONE) return false;
               return true;
            }
            else if(sourceY==targetY&&Math.abs(targetX-sourceX)==2){
                int x=1;
                if(sourceX>targetX) x=-1;
                int i=sourceX+x;
                for(;i!=targetX;i+=x){
                    if(this.chessComponents[i][sourceY].getChessColor()!=ChessColor.NONE) return false;
                }
                return true;
            }
            else if(this.chessComponents[targetX][targetY].getChessColor()==ChessColor.NONE) return false;
            return true;



    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a=new ArrayList<>();
        ChessboardPoint chessboardPoint=this.getSource();
        ChessboardPoint source=this.getSource();
        ChessboardPoint nc;
        if(this.name=='p'){
            nc=chessboardPoint.offset(-1,0);
            if(nc!=null) a.add(nc);
            nc=chessboardPoint.offset(-1,1);
            if(nc!=null) a.add(nc);
            nc=chessboardPoint.offset(-1,-1);
            if(nc!=null) a.add(nc);
            if(chessboardPoint.getX()==6)
                a.add(new ChessboardPoint(chessboardPoint.getX()-2,chessboardPoint.getY()));
        }
        if(this.name=='P'){
            nc=chessboardPoint.offset(1,0);
            if(nc!=null) a.add(nc);
            nc=chessboardPoint.offset(1,1);
            if(nc!=null) a.add(nc);
            nc=chessboardPoint.offset(1,-1);
            if(nc!=null) a.add(nc);
            if(chessboardPoint.getX()==1)
                a.add(new ChessboardPoint(chessboardPoint.getX()+2,chessboardPoint.getY()));
        }
        List<ChessboardPoint> b=new ArrayList<>();
        for(int i=0;i<a.size();i++){
            if(canmoveChess(source.getX(),source.getY(), a.get(i).getX(),a.get(i).getY())){
                b.add(a.get(i));
            }
        }
        Collections.sort(b);
        return b;
    }
}




