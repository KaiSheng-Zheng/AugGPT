import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove=new ArrayList<>();
        ChessComponent[][] board=ConcreteChessGame.getChessComponents();
        ChessboardPoint s = new ChessboardPoint(getSource().getX()-1, getSource().getY()-2);
        if (s.getX() >= 0 && s.getY() >= 0 && s.getX() <= 7 && s.getY() <= 7) {
            if ( board[s.getX()][s.getY()].getName()=='_'|| board[s.getX()][s.getY()].getChessColor()!=(board[getSource().getX()][getSource().getY()].getChessColor())) {
                canMove.add(s);
            }
        }
        ChessboardPoint s2 = new ChessboardPoint(getSource().getX()+1, getSource().getY()-2);
        if (s2.getX() >= 0 && s2.getY() >= 0 && s2.getX() <= 7 && s2.getY() <= 7) {
            if ( board[s2.getX()][s2.getY()].getName()=='_'|| board[s2.getX()][s2.getY()].getChessColor()!=(board[getSource().getX()][getSource().getY()].getChessColor())) {
                canMove.add(s2);
            }
        }
        ChessboardPoint s3 = new ChessboardPoint(getSource().getX()+2, getSource().getY()-1);
        if (s3.getX() >= 0 && s3.getY() >= 0 && s3.getX() <= 7 && s3.getY() <= 7) {
            if ( board[s3.getX()][s3.getY()].getName()=='_'|| board[s3.getX()][s3.getY()].getChessColor()!=(board[getSource().getX()][getSource().getY()].getChessColor())) {
                canMove.add(s3);
            }
        }
        ChessboardPoint s4 = new ChessboardPoint(getSource().getX()+2, getSource().getY()+1);
        if (s4.getX() >= 0 && s4.getY() >= 0 && s4.getX() <= 7 && s4.getY() <= 7) {
            if ( board[s4.getX()][s4.getY()].getName()=='_'|| board[s4.getX()][s4.getY()].getChessColor()!=(board[getSource().getX()][getSource().getY()].getChessColor())) {
                canMove.add(s4);
            }
        }
        ChessboardPoint s5 = new ChessboardPoint(getSource().getX()-1, getSource().getY()+2);
        if (s5.getX() >= 0 && s5.getY() >= 0 && s5.getX() <= 7 && s5.getY() <= 7) {
            if ( board[s5.getX()][s5.getY()].getName()=='_'|| board[s5.getX()][s5.getY()].getChessColor()!=(board[getSource().getX()][getSource().getY()].getChessColor())) {
                canMove.add(s5);
            }
        }
        ChessboardPoint s6 = new ChessboardPoint(getSource().getX()+1, getSource().getY()+2);
        if (s6.getX() >= 0 && s6.getY() >= 0 && s6.getX() <= 7 && s6.getY() <= 7) {
            if ( board[s6.getX()][s6.getY()].getName()=='_'|| board[s6.getX()][s6.getY()].getChessColor()!=(board[getSource().getX()][getSource().getY()].getChessColor())) {
                canMove.add(s6);
            }
        }
        ChessboardPoint s7 = new ChessboardPoint(getSource().getX()-2, getSource().getY()-1);
        if (s7.getX() >= 0 && s7.getY() >= 0 && s7.getX() <= 7 && s7.getY() <= 7) {
            if ( board[s7.getX()][s7.getY()].getName()=='_'|| board[s7.getX()][s7.getY()].getChessColor()!=(board[getSource().getX()][getSource().getY()].getChessColor())) {
                canMove.add(s7);
            }
        }
        ChessboardPoint s8 = new ChessboardPoint(getSource().getX()-2, getSource().getY()+1);
        if (s8.getX() >= 0 && s8.getY() >= 0 && s8.getX() <= 7 && s8.getY() <= 7) {
            if (board[s8.getX()][s8.getY()].name=='_'|| board[s8.getX()][s8.getY()].getChessColor()!=(board[getSource().getX()][getSource().getY()].getChessColor())) {
                canMove.add(s8);
            }
        }
        Comparator<ChessboardPoint> comparator = (o1, o2) -> {
            if (o1.getX()==o2.getX())
                return o1.getY()-o2.getY();
            return o1.getX()-o2.getX();
        };
        canMove.sort(comparator);
        return canMove;
    }
    public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor color, char name) {
        super(chessboardPoint, color, name);
    }
}
