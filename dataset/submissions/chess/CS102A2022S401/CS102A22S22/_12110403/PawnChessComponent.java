import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class PawnChessComponent extends ChessComponent{
    private char name;
    ChessboardPoint point;
    ChessColor color;
    ChessComponent[][] chessComponents=new ChessComponent[8][8];
    public PawnChessComponent(char name,ChessboardPoint point,ChessComponent[][] chessComponents) {
        this.name = name;
        this.point=point;
        this.chessComponents=chessComponents;
        color='a'<=name&&name<='z'?ChessColor.WHITE:ChessColor.BLACK;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint a=point;
        List<ChessboardPoint> A=new ArrayList<>();
        int x=a.getX();int y=a.getY();
        if (color==ChessColor.BLACK){
            if (x==1){
                A.add(a.offset(1,0));
                A.add(a.offset(2,0));
            }else A.add(a.offset(1,0));
        }
        if (color==ChessColor.WHITE){
            if (x==6){
                A.add(a.offset(-1,0));
                A.add(a.offset(-2,0));
            }else A.add(a.offset(-1,0));
        }
        A.removeIf(Objects::isNull);
        Iterator<ChessboardPoint> iterator = A.iterator();
        while(iterator.hasNext()){
            ChessboardPoint yz = iterator.next();
            if(!canMove(yz)){
                iterator.remove();
            }
        }
        if (color==ChessColor.BLACK){
          if (chessComponents[x+1][y+1].getChessColor()==ChessColor.WHITE){
              A.add(a.offset(1,1));
          }else if (chessComponents[x+1][y-1].getChessColor()==ChessColor.WHITE)
              A.add(a.offset(1,-1));
        }
        if (color==ChessColor.WHITE){
            if (chessComponents[x-1][y-1].getChessColor()==ChessColor.BLACK){
                A.add(a.offset(-1,-1));
            }else if (chessComponents[x-1][y+1].getChessColor()==ChessColor.BLACK)
                A.add(a.offset(-1,1));
            }
        A.removeIf(Objects::isNull);
        return A;
    }
    public boolean canMove(ChessboardPoint yz){
        int x=yz.getX();int y=yz.getY();
        if (chessComponents[x][y].getChessColor()==ChessColor.WHITE||chessComponents[x][y].getChessColor()==ChessColor.BLACK)
            return false;
        else return true;
        }
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor(){return color;}
    public void moveTo(ChessboardPoint target) {
        point = target;
    }
}