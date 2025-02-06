import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessColor chessColor,ChessboardPoint source){
        this.setChessColor(chessColor);
        this.setSource(source);
        this.name=chessColor==ChessColor.WHITE?'b':'B';
    }

    public  List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint>chessboardPoints=new ArrayList<>();
        for (int i = 1; ; i++) {
            if (getSource().offset(i, i) != null &&
                    (chessComponents[getSource().getX()+i][getSource().getY() + i] instanceof EmptySlotComponent)) {
                chessboardPoints.add(getSource().offset(i, i));
            } else if (getSource().offset(i, i) != null &&
                    Occupied(chessComponents[getSource().getX()+i][getSource().getY() + i], chessComponents[getSource().getX()][getSource().getY()])) {
                chessboardPoints.add(getSource().offset(i, i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; ; i++) {
            if (getSource().offset(-i, i) != null &&
                    (chessComponents[getSource().getX()-i][getSource().getY() + i] instanceof EmptySlotComponent)) {
                chessboardPoints.add(getSource().offset(-i, i));
            } else if (getSource().offset(-i, i) != null &&
                    Occupied(chessComponents[getSource().getX()-i][getSource().getY() + i], chessComponents[getSource().getX()][getSource().getY()])) {
                chessboardPoints.add(getSource().offset(-i, i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; ; i++) {
            if (getSource().offset(i,- i) != null &&
                    (chessComponents[getSource().getX()+i][getSource().getY() - i] instanceof EmptySlotComponent)) {
                chessboardPoints.add(getSource().offset(i, -i));
            } else if (getSource().offset(i, -i) != null &&
                    Occupied(chessComponents[getSource().getX()+i][getSource().getY() + -i], chessComponents[getSource().getX()][getSource().getY()])) {
                chessboardPoints.add(getSource().offset(i, -i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; ; i++) {
            if (getSource().offset(-i, -i) != null &&
                    (chessComponents[getSource().getX()-i][getSource().getY() - i] instanceof EmptySlotComponent)) {
                chessboardPoints.add(getSource().offset(-i, -i));
            } else if (getSource().offset(-i, -i) != null &&
                    Occupied(chessComponents[getSource().getX()-i][getSource().getY() - i], chessComponents[getSource().getX()][getSource().getY()])) {
                chessboardPoints.add(getSource().offset(-i, -i));
                break;
            } else {
                break;
            }
        }

        return chessboardPoints;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
