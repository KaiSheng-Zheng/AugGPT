import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(int x,int y,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        setSource(new ChessboardPoint(x,y));
        setChessColor(chessColor);
        this.name=name;
        this.chessComponents=chessComponents;
    }

    public String toString() {
        ChessColor chessColor = super.getChessColor();
        if (chessColor==ChessColor.WHITE){
            this.name = 'r';
        }
        if (chessColor==ChessColor.BLACK){
            this.name = 'R';
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
    public boolean canMoveTo(ChessboardPoint target){
        List<ChessboardPoint> chessboardPoints =canMoveTo();
        for (ChessboardPoint chessboardPoint:chessboardPoints){
            if (target.getX()==chessboardPoint.getX() && target.getY()==chessboardPoint.getY())return true;
        }
        return false;
    }

    public boolean canMove(ChessboardPoint destination) {
        ChessboardPoint source = super.getSource();
        if (chessComponents[source.getX()][source.getY()].getChessColor() != chessComponents[destination.getX()][destination.getY()].getChessColor()) {
            if (source.getX() == destination.getX()) {
                if (Math.max(source.getY(), destination.getY())-Math.min(source.getY(), destination.getY())==1)return true;
                for (int col = Math.min(source.getY(), destination.getY()) + 1; col < Math.max(source.getY(), destination.getY()); col++) {
                    if (chessComponents[source.getX()][col].getChessColor()!=ChessColor.NONE )return false;}
                return true;}
            else if (source.getY() == destination.getY()) {
                if (Math.max(source.getX(), destination.getX())-Math.min(source.getX(), destination.getX())==1)return true;
                for (int row = Math.min(source.getX(), destination.getX()) + 1; row < Math.max(source.getX(), destination.getX()); row++) {
                    if (chessComponents[row][source.getY()].getChessColor()!=ChessColor.NONE) return false;}
                return true;}
            else return false;
        }
        return false;
    }
}