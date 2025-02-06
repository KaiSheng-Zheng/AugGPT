import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor){
        super();
        super.setSource(chessboardPoint);
        super.setChessColor(chessColor);
    }
    private ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveposition=new ArrayList<>();
        int xstart,xend,ystart,yend;
        int a=super.getSource().getX(),b=super.getSource().getY();
        while(b<7&&chessComponents[super.getSource().getX()][b+1] instanceof EmptySlotComponent){
            b++;
        }
        if(b<7&&(!chessComponents[super.getSource().getX()][b+1].getChessColor().equals(super.getChessColor()))){
            b++;
        }
        yend=b;
        b=super.getSource().getY();
        while (b>0&&chessComponents[super.getSource().getX()][b-1] instanceof EmptySlotComponent){
            b--;
        }
        if(b>0&&(!chessComponents[super.getSource().getX()][b-1].getChessColor().equals(super.getChessColor()))){
            b--;
        }
        ystart=b;
        b=super.getSource().getY();
        while (a<7&&chessComponents[a+1][super.getSource().getY()] instanceof EmptySlotComponent){
            a++;
        }
        if(a<7&&(!chessComponents[a+1][super.getSource().getY()].getChessColor().equals(super.getChessColor()))){
            a++;
        }
        xend=a;
        a=super.getSource().getX();
        while (a>0&&chessComponents[a-1][super.getSource().getY()] instanceof EmptySlotComponent){
            a--;
        }
        if(a>0&&(!chessComponents[a-1][super.getSource().getY()].getChessColor().equals(super.getChessColor()))){
            a--;
        }
        xstart=a;
        a=super.getSource().getX();
        for(int i=xstart;i<=xend;i++){
            if(i!=super.getSource().getX()){
                canmoveposition.add(new ChessboardPoint(i,super.getSource().getY()));
            }
        }
        for (int i=ystart;i<=yend;i++){
            if (i!=super.getSource().getY()){
                canmoveposition.add(new ChessboardPoint(super.getSource().getX(),i));
            }
        }
         for (int i=0;i<canmoveposition.size();i++){
            for (int j=i;j<canmoveposition.size();j++){
                if(canmoveposition.get(i).getX()>canmoveposition.get(j).getX()){
                    ChessboardPoint chessboardPoint=canmoveposition.get(i);
                    canmoveposition.remove(i);
                    canmoveposition.add(i,canmoveposition.get(j-1));
                    canmoveposition.remove(j);
                    canmoveposition.add(j,chessboardPoint);
                }
            }
        }
        for (int i=0;i<canmoveposition.size();i++){
            for (int j=i;j<canmoveposition.size();j++){
                if(canmoveposition.get(i).getX()==canmoveposition.get(j).getX()&&canmoveposition.get(i).getY()>canmoveposition.get(j).getY()){
                    ChessboardPoint chessboardPoint=canmoveposition.get(i);
                    canmoveposition.remove(i);
                    canmoveposition.add(i,canmoveposition.get(j-1));
                    canmoveposition.remove(j);
                    canmoveposition.add(j,chessboardPoint);
                }
            }
        }
        return canmoveposition;
    }

    public String toString(){
        if(super.getChessColor().equals(ChessColor.BLACK)){
            return "R";
        }else{
            return "r";
        }
    }
}
