import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> R = new ArrayList<>();
        for (int i=1; getSource().getX()+i<8; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()].getChessColor() ==
                    ChessColor.NONE) {
                R.add(getSource().offset(i,0));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()+i][getSource().getY()].getChessColor()) {
                    R.add(getSource().offset(i,0));
                }
                break;
            }
        }
        for (int i=1; getSource().getX()-i>=0; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()-i][getSource().getY()].getChessColor() ==
                    ChessColor.NONE) {
                R.add(getSource().offset(-i,0));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()-i][getSource().getY()].getChessColor()) {
                    R.add(getSource().offset(-i,0));
                }
                break;
            }
        }
        for (int i=1; getSource().getY()+i<8; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()+i].getChessColor() ==
                    ChessColor.NONE) {
                R.add(getSource().offset(0,i));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()+i].getChessColor()) {
                    R.add(getSource().offset(0,i));
                }
                break;
            }
        }
        for (int i=1; getSource().getY()-i>=0; i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()-i].getChessColor() ==
                    ChessColor.NONE) {
                R.add(getSource().offset(0,-i));
            }
            else {
                if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                        ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()-i].getChessColor()) {
                    R.add(getSource().offset(0,-i));
                }
                break;
            }
        }
        return R;
    }
}