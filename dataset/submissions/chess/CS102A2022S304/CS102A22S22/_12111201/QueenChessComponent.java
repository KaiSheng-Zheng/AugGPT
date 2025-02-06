import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor){
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
        int lstart,lend,rstart,rend,count=0;
        int c=super.getSource().getX(),d=super.getSource().getY();
        while(d<7&&c<7&&chessComponents[c+1][d+1] instanceof EmptySlotComponent){
            d++;
            c++;
            count++;
        }
        if(d<7&&c<7&&(!chessComponents[c+1][d+1].getChessColor().equals(super.getChessColor()))){
            count++;
        }
        rend=count;
        d=super.getSource().getY();
        c=super.getSource().getX();
        count=0;
        while (d>0&&c>0&&chessComponents[c-1][d-1] instanceof EmptySlotComponent){
            d--;
            c--;
            count++;
        }
        if(d>0&&c>0&&(!chessComponents[c-1][d-1].getChessColor().equals(super.getChessColor()))){
            count++;
        }
        rstart=count;
        d=super.getSource().getY();
        c=super.getSource().getX();
        count=0;
        while (c<7&&d>0&&chessComponents[c+1][d-1] instanceof EmptySlotComponent){
            c++;
            d--;
            count++;
        }
        if(c<7&&d>0&&!chessComponents[c+1][d-1].getChessColor().equals(super.getChessColor())){
            count++;
        }
        lstart=count;
        d=super.getSource().getY();
        c=super.getSource().getX();
        count=0;
        while (c>0&&d<7&&chessComponents[c-1][d+1] instanceof EmptySlotComponent){
            c--;
            d++;
            count++;
        }
        if(c>0&&d<7&&!chessComponents[c-1][d+1].getChessColor().equals(super.getChessColor())){
            count++;
        }
        lend=count;
        d=super.getSource().getY();
        c=super.getSource().getX();
        count=0;
        for(int i=c+lstart;i>=c-lend;i--){
            if(i!=super.getSource().getX()){
                canmoveposition.add(new ChessboardPoint(i,d+c-i));
            }
        }
        for (int i=c-rstart;i<=c+rend;i++){
            if (i!=super.getSource().getX()){
                canmoveposition.add(new ChessboardPoint(i,i-c+d));
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
    @Override
    public String toString(){
        if(super.getChessColor().equals(ChessColor.BLACK)){
            return "Q";
        }else{
            return "q";
        }
    }
}
