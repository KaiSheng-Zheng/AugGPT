import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(int x,int y,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        setSource(new ChessboardPoint(x,y));
        setChessColor(chessColor);
        this.name=name;
        this.chessComponents=chessComponents;
    }

    public String toString() {
        ChessColor chessColor = super.getChessColor();
        if (chessColor == ChessColor.WHITE) {
            this.name = 'n';
        }
        if (chessColor == ChessColor.BLACK) {
            this.name = 'N';
        }
        return String.valueOf(this.name);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMove(new ChessboardPoint(i, j))) {
                    canMoveTo.add(new ChessboardPoint(i, j));
                }
            }
        }
        if (canMoveTo.size()!=0){
            return canMoveTo;
        }
        else {
            return new ArrayList<>();
        }
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
        if (source.getX() == destination.getX()+1||source.getX() == destination.getX()-1) {
            if (destination.getY()!=source.getY()+2 && destination.getY()!=source.getY()-2) {
                return false;
            }
            if (chessComponents[source.getX()][source.getY()].getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()){
                return false;
            }
        }
        else if (source.getY() == destination.getY()+1||source.getY() == destination.getY()-1) {
            if (destination.getX()!=source.getX()+2 && destination.getX()!=source.getX()-2) {
                return false;
            }
            if (chessComponents[source.getX()][source.getY()].getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()){
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}


