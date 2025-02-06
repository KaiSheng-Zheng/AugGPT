import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class KnightChessComponent extends ChessComponent{
    private char name;
    ChessColor color;
    ChessboardPoint point;
    ChessComponent[][] chessComponents=new ChessComponent[8][8];
    public KnightChessComponent(char name,ChessboardPoint point,ChessComponent[][] chessComponents) {
        this.name = name;
        this.point=point;
        this.chessComponents=chessComponents;
        color='a'<=name&&name<='z'?ChessColor.WHITE:ChessColor.BLACK;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint a=point;
        List<ChessboardPoint> A=new ArrayList<>();
        A.add(a.offset(-2,1));
        A.add(a.offset(-1,2));
        A.add(a.offset(1,2));
        A.add(a.offset(2,1));
        A.add(a.offset(-2,-1));
        A.add(a.offset(-1,-2));
        A.add(a.offset(2,-1));
        A.add(a.offset(1,-2));
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
        int x= yz.getX();int y= yz.getY();
        if (chessComponents[x][y].getChessColor()!=color)
            return true;
        else return false;
    }
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor(){return color;}
    public void moveTo(ChessboardPoint target) {
        point = target;
    }
}