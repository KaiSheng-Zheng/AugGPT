import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class KingChessComponent extends ChessComponent{
    private char name;
    ChessColor color;
    ChessboardPoint point;
    ChessComponent[][] chessComponents = new ChessComponent[8][8];
    public KingChessComponent(char name, ChessboardPoint point, ChessComponent[][] chessComponents){
        this.name=name;
        color = 'a' <= name && name <= 'z' ? ChessColor.WHITE : ChessColor.BLACK;
        this.point = point;
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ChessboardPoint a=point;
        List<ChessboardPoint> A=new ArrayList<>();
        A.add(a.offset(1,0));
        A.add(a.offset(-1,0));
        A.add(a.offset(0,-1));
        A.add(a.offset(0,1));
        A.add(a.offset(-1,-1));
        A.add(a.offset(-1,1));
        A.add(a.offset(1,1));
        A.add(a.offset(1,-1));
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
        int x = yz.getX();int y = yz.getY();
        if(chessComponents[x][y].getChessColor() != color){
            return true;
        }
        return false;
    }

    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor(){return color;}
    public void moveTo(ChessboardPoint target) {
        point = target;
    }
}