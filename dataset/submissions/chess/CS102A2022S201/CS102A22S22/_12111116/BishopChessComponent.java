import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessColor currentPlayer;

    public BishopChessComponent(int x, int y, ChessColor a) {
        this.x=x;
        this.y=y;
        getSource().setX(x);
        getSource().setY(y);
        this.currentPlayer=a;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        x = getSource().getX();
        y = getSource().getY();
        List<ChessboardPoint> chessboardPoint = new ArrayList<>();
        ChessboardPoint c;
        for (int i=1;i<8;i++){
            c = new ChessboardPoint(this.x, this.y);
            if (c.offset(i,i)!=null){
            if (weather(x+i,y+i)){
                if (getChess(this.x+i,this.y+i).getChessColor() != currentPlayer) {
                    chessboardPoint.add(c.offset(i,i));
                }
            }
            }
            if (c.offset(i,-i)!=null){
            if (weather(x+i,y-i)){
                if (getChess(this.x+i,this.y-i).getChessColor() != currentPlayer) {
                    chessboardPoint.add(c.offset(i,-i));
                }
            }
            }
            if (c.offset(-i,-i)!=null){
            if (weather(x-i,y-i)){
                if (getChess(this.x-i,this.y-i).getChessColor() != currentPlayer) {
                    chessboardPoint.add(c.offset(-i,-i));
                }
            }
            }
            if (c.offset(-i,i)!=null){
            if (weather(x-i,y+i)){
                if (getChess(this.x-i,this.y+i).getChessColor() != currentPlayer) {
                    chessboardPoint.add(c.offset(-i,i));
                }
            }
            }
        }
        return chessboardPoint;
    }
    public boolean weather(int a,int b){
        x = getSource().getX();
        y = getSource().getY();
        ChessboardPoint d=new ChessboardPoint(a,b);
        int c=1;
        if (d.offset(0,0)!=null){
            c=0;
            List<Integer> x1= new ArrayList<>();
            List<Integer> y1= new ArrayList<>();
            for (int i=1;i<Math.abs(a-this.x);i++){
                if(this.x>a){x1.add(this.x-i);}
                else {x1.add(this.x+i);}
                if(this.y>b){y1.add(this.y-i);}
                else {y1.add(this.y+i);}
            }
            if (x1.size()!=0){
                for (int i=0;i<x1.size();i++){
                    if (getChess(x1.get(i),y1.get(i)).getChessColor() != ChessColor.NONE)
                        c=1;
                }
            }
        }
        return c == 0;
    }
}
