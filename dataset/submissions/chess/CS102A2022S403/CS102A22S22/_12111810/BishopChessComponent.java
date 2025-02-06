
import java.util.ArrayList;
import java.util.List;


public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name) {
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        if(getSource().getX()+1<8&&getSource().getY()+1<8) {
            for (int i = 1; (getSource().getX() + i < 8 && getSource().getY() + i < 8); i++) {
                if (ChessComponent.chessComponents[getSource().getX()+i][getSource().getY()+i].getChessColor() == ChessColor.NONE) {
                    points.add(new ChessboardPoint((getSource().getX()+i),(getSource().getY() + i)));
                } 
                else if (ChessComponent.chessComponents[getSource().getX()+i][getSource().getY() + i].getChessColor() != getChessColor()
                        && ChessComponent.chessComponents[getSource().getX()+i][getSource().getY() + i].getChessColor() != ChessColor.NONE) {
                    points.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()+ i));
                    break;
                } 
                else if(ChessComponent.chessComponents[getSource().getX()+i][getSource().getY()+i].getChessColor() == getChessColor()){
                    break;
                }
            }
        }
        if(getSource().getX()-1>=0&&getSource().getY()-1>=0) {
            for (int i = 1; (getSource().getX() - i >= 0 && getSource().getY() - i >= 0); i++) {
                if (ChessComponent.chessComponents[getSource().getX() + i][getSource().getY() - i].getChessColor() == ChessColor.NONE) {
                    points.add(new ChessboardPoint((getSource().getX() - i), (getSource().getY() - i)));
                } else if (ChessComponent.chessComponents[getSource().getX() - i][getSource().getY() - i].getChessColor() != getChessColor()
                        && ChessComponent.chessComponents[getSource().getX() - i][getSource().getY() - i].getChessColor() != ChessColor.NONE) {
                    points.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
                    break;
                } else if(ChessComponent.chessComponents[getSource().getX()+i][getSource().getY()+i].getChessColor() == getChessColor()){
                    break;
                }
            }
        }
        if(getSource().getX()-1>=0&&getSource().getY()+1<8) {
            for (int i = 1; (getSource().getX() - i >= 0 && getSource().getY() + i < 8); i++) {
                if (ChessComponent.chessComponents[getSource().getX() - i][getSource().getY() + i].getChessColor() == ChessColor.NONE) {
                    points.add(new ChessboardPoint((getSource().getX() - i), (getSource().getY() + i)));
                } else if (ChessComponent.chessComponents[getSource().getX() - i][getSource().getY() + i].getChessColor() != getChessColor()
                        && ChessComponent.chessComponents[getSource().getX() - i][getSource().getY() + i].getChessColor() != ChessColor.NONE) {
                    points.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));
                    break;
                } else if(ChessComponent.chessComponents[getSource().getX()+i][getSource().getY()+i].getChessColor() == getChessColor()){
                    break;
                }
            }
        }
        if(getSource().getX()+1<8&&getSource().getY()-1>=0) {
            for (int i = 1; (getSource().getX() + i < 8 && getSource().getY() - i >= 0); i++) {
                if (ChessComponent.chessComponents[getSource().getX() + i][getSource().getY() - i].getChessColor() == ChessColor.NONE) {
                    points.add(new ChessboardPoint((getSource().getX() + i), (getSource().getY() - i)));
                } else if (ChessComponent.chessComponents[getSource().getX() + i][getSource().getY() - i].getChessColor() != getChessColor()
                        && ChessComponent.chessComponents[getSource().getX() + i][getSource().getY() - i].getChessColor() != ChessColor.NONE) {
                    points.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));
                    break;
                } else if(ChessComponent.chessComponents[getSource().getX()+i][getSource().getY()+i].getChessColor() == getChessColor()){
                    break;
                }
            }
        }
        return points;
    }
}
