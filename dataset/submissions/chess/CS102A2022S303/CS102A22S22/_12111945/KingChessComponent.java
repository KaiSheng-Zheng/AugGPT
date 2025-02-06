import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(int x,int y,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        setSource(new ChessboardPoint(x,y));
        setChessColor(chessColor);
        this.name=name;
        this.chessComponents=chessComponents;
    }

    public String toString() {
        ChessColor chessColor = super.getChessColor();
        if (chessColor==ChessColor.WHITE){
            this.name = 'k';
        }
        if (chessColor==ChessColor.BLACK){
            this.name = 'K';
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
        ChessColor chessColor = super.getChessColor();
        if (chessComponents[source.getX()][source.getY()].getChessColor()==(chessComponents[destination.getX()][destination.getY()].getChessColor())){
            return false;
        }
        if (source.getX() == destination.getX()+1||source.getX() == destination.getX()-1) {
            int row = source.getX();
            int col = source.getY();
            if (destination.getY()!=col+1 && destination.getY()!=col-1 && destination.getY()!=col) {
                return false;
            }
        }
        else if (source.getY() == destination.getY()+1||source.getY() == destination.getY()-1) {
            int col = source.getY();
            int row = source.getX();
            if (destination.getX()!=row+1 && destination.getX()!=row-1 && destination.getX()!=row) {
                return false;
            }
        }
        else if (source.getY() == destination.getY()){
            int col = source.getY();
            int row = source.getX();
            if (destination.getX()!=row+1 && destination.getX()!=row-1){
                return false;
            }
        }
        else if (source.getX() == destination.getX()){
            int col = source.getY();
            int row = source.getX();
            if (destination.getY()!=col+1 && destination.getY()!=col-1){
                return false;
            }
        }
        else {
            return false;
        }
        return true;
    }
}

