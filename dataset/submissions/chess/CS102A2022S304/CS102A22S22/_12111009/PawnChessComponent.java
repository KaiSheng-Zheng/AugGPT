import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    int step;
    public PawnChessComponent(ChessboardPoint chessboardPoint,  char name) {
        if (name=='P'){
            this.setSource(chessboardPoint);
            this.setChessColor(ChessColor.BLACK);
            this.setName(name);
            chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
        }else if (name=='p'){
            this.setSource(chessboardPoint);
            this.setChessColor(ChessColor.WHITE);
            this.setName(name);
            chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
        }
    }
    public PawnChessComponent(ChessColor color){
        if (color==ChessColor.BLACK){
            this.setName('P');
        }else if (color==ChessColor.WHITE){
            this.setName('p');
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (canMoveTo(this.getChessboard(),new ChessboardPoint(i,j))){
                    chessboardPoints.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chessboardPoints;
    }
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        if (this.getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()){
            return false;
        }
        if (this.getChessColor()==ChessColor.WHITE){
            step =1;
        }else step=-1;
        ChessboardPoint source = this.getSource();
        if (source.getY()==destination.getY()) {
            if (chessComponents[source.getX() - step][source.getY()] instanceof EmptySlotComponent)
                if ((double)source.getX()==3.5+2.5*step) {
                    if (source.getX() == destination.getX() + step || (source.getX() == destination.getX() + 2 * step && chessComponents[source.getX() - 2 * step][source.getY()] instanceof EmptySlotComponent)) {
                        return true;
                    } else return false;
                } else {
                    if (source.getX() == destination.getX() + step) {
                        return true;
                    } else return false;
                }
            else return false;
        }else if (destination.getY()==source.getY()+1&&destination.getX()==source.getX()-step) {
            if (!(chessComponents[source.getX() - step][source.getY() + 1] instanceof EmptySlotComponent)) {
                return true;
            }
        }else if (destination.getY()==source.getY()-1&&destination.getX()==source.getX()-step) {
            if (!(chessComponents[source.getX() - step][source.getY() - 1] instanceof EmptySlotComponent)) {
                return true;
            }
        }return false;
    }
}