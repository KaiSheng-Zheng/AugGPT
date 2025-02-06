import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class QueenChessComponent extends ChessComponent{
    private char name;
    ChessboardPoint point;
    ChessColor color;
    ChessComponent[][] chessComponents=new ChessComponent[8][8];
    public QueenChessComponent(char name,ChessboardPoint point,ChessComponent[][] chessComponents) {
        this.name = name;
        this.point=point;
        this.chessComponents=chessComponents;
        color='a'<=name&&name<='z'?ChessColor.WHITE:ChessColor.BLACK;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint a=point;
        List<ChessboardPoint> A=new ArrayList<>();
        for (int i=1;i<8;i++){
            A.add(a.offset(i,0));
            A.add(a.offset(-i,0));
            A.add(a.offset(0,i));
            A.add(a.offset(0,-i));
            A.add(a.offset(i,i));
            A.add(a.offset(-i,i));
            A.add(a.offset(i,-i));
            A.add(a.offset(-i,-i));
        }
        A.removeIf(Objects::isNull);
        Iterator<ChessboardPoint> iterator = A.iterator();
        while(iterator.hasNext()){
            ChessboardPoint yz = iterator.next();
            if(!canMove(yz)){
                iterator.remove();
            }
        }
        return A;
    }
    public boolean canMove(ChessboardPoint yz){
        int x= yz.getX();int y= yz.getY();int x0= point.getX();int y0= point.getY();
        if (chessComponents[x][y].getChessColor()!=color){
            if (noChess(x0,y0,x,y,chessComponents))
                return true;
            else return false;
        }
        else return false;
    }
    public boolean noChess(int x0,int y0,int x,int y,ChessComponent[][] chessComponents){
        if (x0>x&&y0==y){
            for (int i=1;i<(x0-x);i++){
                if (chessComponents[x0-i][y0].getChessColor()!=ChessColor.NONE)
                    return false;
            }
        }
        if (x0<x&&y0==y){
            for (int i=1;i<(x-x0);i++){
                if (chessComponents[x0+i][y0].getChessColor()!=ChessColor.NONE)
                    return false;
            }
        }
        if (x0==x&&y0>y){
            for (int i=1;i<(y0-y);i++){
                if (chessComponents[x0][y0-i].getChessColor()!=ChessColor.NONE)
                    return false;
            }
        }
        if (x0==x&&y0<y){
            for (int i=1;i<(y-y0);i++){
                if (chessComponents[x0][y0+i].getChessColor()!=ChessColor.NONE)
                    return false;
            }
        }
        if (x0>x&&y0<y){
            for (int i=1;i<(x0-x);i++){
                if (chessComponents[x0-i][y0+i].getChessColor()!=ChessColor.NONE)
                    return false;
            }
        }
        if (x0>x&&y0>y){
            for (int i=1;i<(x0-x);i++){
                if (chessComponents[x0-i][y0-i].getChessColor()!=ChessColor.NONE)
                    return false;
            }
        }
        if (x0<x&&y0>y){
            for (int i=1;i<(x-x0);i++){
                if (chessComponents[x0+i][y0-i].getChessColor()!=ChessColor.NONE)
                    return false;
            }
        }
        if (x0<x&&y0<y){
            for (int i=1;i<(x-x0);i++){
                if (chessComponents[x0+i][y0+i].getChessColor()!=ChessColor.NONE)
                    return false;
            }
        }
        return true;
    }
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor(){return color;}
    public void moveTo(ChessboardPoint target) {
        point = target;
    }
}