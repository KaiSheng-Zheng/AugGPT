import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Q = new ArrayList<>();
        for (int i=1; getSource().getX()+i<8; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()].getChessColor() ==
                    ChessColor.NONE) {
                Q.add(getSource().offset(i,0));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()].getChessColor()) {
                    Q.add(getSource().offset(i,0));
                }
                break;
            }
        }
        for (int i=1; getSource().getX()-i>=0; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()-i][getSource().getY()].getChessColor() ==
                    ChessColor.NONE) {
                Q.add(getSource().offset(-i,0));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()-i][getSource().getY()].getChessColor()) {
                    Q.add(getSource().offset(-i,0));
                }
                break;
            }
        }
        for (int i=1; getSource().getY()+i<8; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()+i].getChessColor() ==
                    ChessColor.NONE) {
                Q.add(getSource().offset(0,i));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()+i].getChessColor()) {
                    Q.add(getSource().offset(0,i));
                }
                break;
            }
        }
        for (int i=1; getSource().getY()-i>=0; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()-i].getChessColor() ==
                    ChessColor.NONE) {
                Q.add(getSource().offset(0,-i));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()-i].getChessColor()) {
                    Q.add(getSource().offset(0,-i));
                }
                break;
            }
        }
        for (int i=1; getSource().getX()+i<8 && getSource().getY()+i<8; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()+i].getChessColor() ==
                    ChessColor.NONE) {
                Q.add(getSource().offset(i,i));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()+i].getChessColor()) {
                    Q.add(getSource().offset(i,i));
                }
                break;
            }
        }
        for (int i=1; getSource().getX()+i<8 && getSource().getY()-i>=0; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()-i].getChessColor() ==
                    ChessColor.NONE) {
                Q.add(getSource().offset(i,-i));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()-i].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()-i].getChessColor()) {
                    Q.add(getSource().offset(i,-i));
                }
                break;
            }
        }
        for (int i=1; getSource().getX()-i>=0 && getSource().getY()+i<8; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()-i][getSource().getY()+i].getChessColor() ==
                    ChessColor.NONE) {
                Q.add(getSource().offset(-i,i));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()-i][getSource().getY()+i].getChessColor()) {
                    Q.add(getSource().offset(-i,i));
                }
                break;
            }
        }
        for (int i=1; getSource().getX()-i>=0 && getSource().getY()-i>=0; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()-i][getSource().getY()-i].getChessColor() ==
                    ChessColor.NONE) {
                Q.add(getSource().offset(-i,-i));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()-i][getSource().getY()-i].getChessColor()) {
                    Q.add(getSource().offset(-i,-i));
                }
                break;
            }
        }
        return Q;
    }
}