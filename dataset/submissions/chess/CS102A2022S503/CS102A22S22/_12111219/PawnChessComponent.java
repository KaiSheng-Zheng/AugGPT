import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessColor chessColor,ChessboardPoint source){
        this.setChessColor(chessColor);
        this.setSource(source);
        this.name=chessColor==ChessColor.WHITE?'p':'P';
    }

    public  List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();
        if(getChessColor()==ChessColor.BLACK&&getSource().getX()==1) {
            for (int i = 1; i <= 2; i++) {
                if (getSource().offset(i, 0) != null &&
                        (chessComponents[getSource().getX() + i][getSource().getY()] instanceof EmptySlotComponent)) {
                    chessboardPoints.add(getSource().offset(i, 0));
                } else {
                    break;
                }
            }
            if (getSource().offset(1, 1) != null &&
                    Occupied2(chessComponents[getSource().getX() + 1][getSource().getY() + 1], chessComponents[getSource().getX()][getSource().getY()])
                    ) {
                chessboardPoints.add(getSource().offset(1, 1));
            }
            if (getSource().offset(1, -1) != null &&
                    Occupied2(chessComponents[getSource().getX() + 1][getSource().getY() - 1], chessComponents[getSource().getX()][getSource().getY()])
                    ) {
                chessboardPoints.add(getSource().offset(1, -1));
            }
        }else if (getChessColor() == ChessColor.BLACK && getSource().getX() != 1) {
                if (getSource().offset(1, 1) != null &&
                        Occupied2(chessComponents[getSource().getX() + 1][getSource().getY() + 1], chessComponents[getSource().getX()][getSource().getY()])
                        ) {
                    chessboardPoints.add(getSource().offset(1, 1));
                }
                if (getSource().offset(1, -1) != null &&
                        Occupied2(chessComponents[getSource().getX() + 1][getSource().getY() - 1], chessComponents[getSource().getX()][getSource().getY()])
                        ) {
                    chessboardPoints.add(getSource().offset(1, -1));
                }
                if (getSource().offset(1, 0) != null &&
                        (chessComponents[getSource().getX() + 1][getSource().getY()] instanceof EmptySlotComponent)) {
                    chessboardPoints.add(getSource().offset(1, 0));
                }
            }


            if (getChessColor() == ChessColor.WHITE && getSource().getX() == 6) {
                for (int i = 1; i <= 2; i++) {
                    if (getSource().offset(-i, 0) != null &&
                            (chessComponents[getSource().getX() - i][getSource().getY()] instanceof EmptySlotComponent)) {
                        chessboardPoints.add(getSource().offset(-i, 0));
                    } else {
                        break;
                    }
                }
                if (getSource().offset(-1, 1) != null &&
                        Occupied2(chessComponents[getSource().getX() - 1][getSource().getY() + 1], chessComponents[getSource().getX()][getSource().getY()])
                        ) {
                    chessboardPoints.add(getSource().offset(-1, +1));
                }
                if (getSource().offset(-1, -1) != null &&
                        Occupied2(chessComponents[getSource().getX() - 1][getSource().getY() - 1], chessComponents[getSource().getX()][getSource().getY()])
                        ) {
                    chessboardPoints.add(getSource().offset(-1, -1));
                }
            } else if (getChessColor() == ChessColor.WHITE && getSource().getX() != 6) {
                if (getSource().offset(-1, 1) != null &&
                        Occupied2(chessComponents[getSource().getX() - 1][getSource().getY() + 1], chessComponents[getSource().getX()][getSource().getY()])
                        ) {
                    chessboardPoints.add(getSource().offset(-1, +1));
                }
                if (getSource().offset(-1, -1) != null &&
                        Occupied2(chessComponents[getSource().getX() - 1][getSource().getY() - 1], chessComponents[getSource().getX()][getSource().getY()])
                        ) {
                    chessboardPoints.add(getSource().offset(-1, -1));
                }
                if (getSource().offset(-1, 0) != null &&
                        (chessComponents[getSource().getX() - 1][getSource().getY()] instanceof EmptySlotComponent)) {
                    chessboardPoints.add(getSource().offset(-1, 0));
                }
            }

        return chessboardPoints;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
