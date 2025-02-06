import java.util.ArrayList;
import java.util.List;
public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(int x,int y,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        setSource(new ChessboardPoint(x,y));
        setChessColor(chessColor);
        this.name=name;
        this.chessComponents=chessComponents;
    }

    public String toString() {
        ChessColor chessColor = super.getChessColor();
        if (chessColor==ChessColor.WHITE){
            this.name = 'b';
        }
        if (chessColor==ChessColor.BLACK){
            this.name = 'B';
        }
        return String.valueOf(this.name);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (canMove(new ChessboardPoint(i,j))){
                    canMoveTo.add(new ChessboardPoint(i,j));
                }
            }
        }
        return canMoveTo;
    }

    public boolean canMoveTo(int targetX,int targetY){
        List<ChessboardPoint> chessboardPoints =canMoveTo();
        for (ChessboardPoint chessboardPoint:chessboardPoints){
            if (targetX==chessboardPoint.getX() && targetY==chessboardPoint.getY())return true;
        }
        return false;
    }

    public boolean canMove(ChessboardPoint destination) {
        ChessboardPoint source = super.getSource();
        ChessColor chessColor = super.getChessColor();
        if (chessComponents[source.getX()][source.getY()].getChessColor() == chessComponents[destination.getX()][destination.getY()].getChessColor()) {
            return false;
        }
        else {
            if (destination.getX() - source.getX() == destination.getY() - source.getY()) {
                int d = source.getX() - source.getY();
                for (int col = Math.min(source.getY(), destination.getY()) + 1;
                     col < Math.max(source.getY(), destination.getY()); col++) {
                    if (!(getChessComponents()[col + d][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else if (destination.getX() - source.getX() == source.getY() - destination.getY()) {
                int d = source.getX() + source.getY();
                for (int row = Math.min(source.getX(), destination.getX()) + 1;
                     row < Math.max(source.getX(), destination.getX()); row++) {
                    if (!(getChessComponents()[row][d - row] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        }
    }
}



