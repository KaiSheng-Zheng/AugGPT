import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove=new ArrayList<>();
        ChessComponent[][] board=ConcreteChessGame.getChessComponents();
        ChessboardPoint s = new ChessboardPoint(getSource().getX()+ 1, getSource().getY()+1);
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


    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor color, char name) {
        super(chessboardPoint, color, name);
    }
}
