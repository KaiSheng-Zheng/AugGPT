import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> B = new ArrayList<>();
        for (int i=1; getSource().getX()+i<8 && getSource().getY()+i<8; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()+i].getChessColor() ==
                    ChessColor.NONE) {
                B.add(getSource().offset(i,i));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()+i].getChessColor()) {
                    B.add(getSource().offset(i,i));
                }
                break;
            }
        }
        for (int i=1; getSource().getX()+i<8 && getSource().getY()-i>=0; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()-i].getChessColor() ==
                    ChessColor.NONE) {
                B.add(getSource().offset(i,-i));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()-i].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()-i].getChessColor()) {
                    B.add(getSource().offset(i,-i));
                }
                break;
            }
        }
        for (int i=1; getSource().getX()-i>=0 && getSource().getY()+i<8; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()-i][getSource().getY()+i].getChessColor() ==
                    ChessColor.NONE) {
                B.add(getSource().offset(-i,i));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()-i][getSource().getY()+i].getChessColor()) {
                    B.add(getSource().offset(-i,i));
                }
                break;
            }
        }
        for (int i=1; getSource().getX()-i>=0 && getSource().getY()-i>=0; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()-i][getSource().getY()-i].getChessColor() ==
                    ChessColor.NONE) {
                B.add(getSource().offset(-i,-i));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()-i][getSource().getY()-i].getChessColor()) {
                    B.add(getSource().offset(-i,-i));
                }
                break;
            }
        }
        return B;
    }
}