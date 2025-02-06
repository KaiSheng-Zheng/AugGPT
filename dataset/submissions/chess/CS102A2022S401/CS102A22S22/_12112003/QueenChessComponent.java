import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove=new ArrayList<>();
        ChessComponent[][] board=ConcreteChessGame.getChessComponents();
        ChessboardPoint sq = new ChessboardPoint(getSource().getX()+ 1, getSource().getY());
        while (sq.getX() <= 7) {
            if ( board[sq.getX()][getSource().getY()].getName()=='_'||board[sq.getX()][getSource().getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                canMove.add(new ChessboardPoint(sq.getX(),sq.getY()));
            } else break;
            sq.setX(sq.getX()+1);
        }
        ChessboardPoint s1q = new ChessboardPoint(getSource().getX()- 1, getSource().getY());
        while (s1q.getX() >=0) {
            if ( board[s1q.getX()][getSource().getY()].getName()=='_'||board[s1q.getX()][getSource().getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                canMove.add(new ChessboardPoint(s1q.getX(),s1q.getY()));
            } else break;
            s1q.setX(s1q.getX()-1);
        }
        ChessboardPoint s2q = new ChessboardPoint(getSource().getX(), getSource().getY()+1);
        while (s2q.getY() <= 7) {
            if ( board[getSource().getX()][s2q.getY()].getName()=='_'||board[s2q.getX()][s2q.getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                canMove.add(new ChessboardPoint(s2q.getX(),s2q.getY()));
            } else break;
            s2q.setY(s2q.getY()+1);
        }
        ChessboardPoint s3q = new ChessboardPoint(getSource().getX(), getSource().getY()-1);
        while (s3q.getY() >=0) {
            if ( board[getSource().getX()][s3q.getY()].getName()=='_'||board[s3q.getX()][s3q.getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                canMove.add(new ChessboardPoint(s3q.getX(),s3q.getY()));
            } else break;
            s3q.setY(s3q.getY()-1);
        }ChessboardPoint s = new ChessboardPoint(getSource().getX()+ 1, getSource().getY()+1);
        while (s.getX() <= 7&&s.getY()<=7) {
            if ( board[s.getX()][getSource().getY()].getName()=='_'||board[s.getX()][getSource().getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                canMove.add(new ChessboardPoint(s.getX(),s.getY()));
            } else break;
            s.setX(s.getX()+1);
            s.setY(s.getY()+1);
        }
        ChessboardPoint s1 = new ChessboardPoint(getSource().getX()- 1, getSource().getY()-1);
        while (s1.getX() >=0&&s1.getY()>=0) {
            if ( board[s1.getX()][getSource().getY()].getName()=='_'||board[s1.getX()][getSource().getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                canMove.add(new ChessboardPoint(s1.getX(),s1.getY()));
            } else break;
            s1.setX(s1.getX()-1);
            s1.setY(s1.getY()-1);
        }
        ChessboardPoint s2 = new ChessboardPoint(getSource().getX()-1, getSource().getY()+1);
        while (s2.getY() <= 7&&s2.getX()>=0) {
            if ( board[getSource().getX()][s2.getY()].getName()=='_'||board[s2.getX()][s2.getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                canMove.add(new ChessboardPoint(s2.getX(),s2.getY()));
            } else break;
            s2.setY(s2.getY()+1);
            s2.setX(s2.getX()-1);
        }
        ChessboardPoint s3 = new ChessboardPoint(getSource().getX()+1, getSource().getY()-1);
        while (s3.getY() >=0&&s3.getX()<=7) {
            if ( board[getSource().getX()][s3.getY()].getName()=='_'||board[s3.getX()][s3.getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                canMove.add(new ChessboardPoint(s3.getX(),s3.getY()));
            } else break;
            s3.setY(s3.getY()-1);
            s3.setX(s3.getX()+1);
        }
        Comparator<ChessboardPoint> comparator = (o1, o2) -> {
            if (o1.getX()==o2.getX())
                return o1.getY()-o2.getY();
            return o1.getX()-o2.getX();
        };
        canMove.sort(comparator);
        return canMove;
    }

    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor color, char name) {
        super(chessboardPoint, color, name);
    }
}
