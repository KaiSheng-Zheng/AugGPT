import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessColor chessColor,ChessboardPoint source){
        this.setChessColor(chessColor);
        this.setSource(source);
        this.name=chessColor==ChessColor.WHITE?'r':'R';
    }

    public  List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = 1; ; i++) {
            if (getSource().offset(0, i) != null &&
                    (chessComponents[getSource().getX()][getSource().getY() + i] instanceof EmptySlotComponent)) {
                chessboardPoints.add(getSource().offset(0, i));
            } else if (getSource().offset(0, i) != null &&
                    Occupied(chessComponents[getSource().getX()][getSource().getY() + i], chessComponents[getSource().getX()][getSource().getY()])) {
                chessboardPoints.add(getSource().offset(0, i));
                break;
            } else {
                break;
            }
        }

        for(int i=-1;;i--) {
            if (getSource().offset(0, i)!=null&&
                    (chessComponents[getSource().getX()][getSource().getY()+i]instanceof EmptySlotComponent) ){
                chessboardPoints.add(getSource().offset(0, i));
            }else if(getSource().offset(0, i)!=null&&
                    Occupied(chessComponents[getSource().getX()][getSource().getY()+i],chessComponents[getSource().getX()][getSource().getY()])){
                chessboardPoints.add(getSource().offset(0, i));
                break;
            }else {break;}
        }


        for(int i=1;;i++) {
            if (getSource().offset(i, 0)!=null&&
                    (chessComponents[getSource().getX()+i][getSource().getY()]instanceof EmptySlotComponent) ){
                chessboardPoints.add(getSource().offset(i, 0));
            }else if(getSource().offset(i, 0)!=null&&
                    Occupied(chessComponents[getSource().getX()+i][getSource().getY()],chessComponents[getSource().getX()][getSource().getY()])){
                chessboardPoints.add(getSource().offset(i, 0));
                break;
            }else {break;}
        }


        for(int i=-1;;i--) {
            if (getSource().offset(i, 0)!=null&&
                    (chessComponents[getSource().getX()+i][getSource().getY()]instanceof EmptySlotComponent) ){
                chessboardPoints.add(getSource().offset(i, 0));
            }else if(getSource().offset(i, 0)!=null&&
                    Occupied(chessComponents[getSource().getX()+i][getSource().getY()],chessComponents[getSource().getX()][getSource().getY()])){
                chessboardPoints.add(getSource().offset(i, 0));
                break;
            }else {break;}
        }
        return chessboardPoints;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
