import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent{


    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor color, char name) {
        super(chessboardPoint, color, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove=new ArrayList<>();
        ChessComponent[][] board=ConcreteChessGame.getChessComponents();
        ChessboardPoint s = new ChessboardPoint(getSource().getX()+ 1, getSource().getY());
        while (s.getX() <= 7) {
            if ( board[s.getX()][getSource().getY()].getName()=='_'){
                canMove.add(new ChessboardPoint(s.getX(),s.getY()));
            } else if(board[s.getX()][getSource().getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                canMove.add(new ChessboardPoint(s.getX(),s.getY()));
                break;
            }else break;
         s.setX(s.getX()+1);
        }
        ChessboardPoint s1 = new ChessboardPoint(getSource().getX()- 1, getSource().getY());
        while (s1.getX() >=0) {
            if ( board[s1.getX()][getSource().getY()].getName()=='_'){
                canMove.add(new ChessboardPoint(s1.getX(),s1.getY()));
            } else if(board[s1.getX()][getSource().getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                canMove.add(new ChessboardPoint(s1.getX(),s1.getY()));
                break;
            }else break;
            s1.setX(s1.getX()-1);
        }
        ChessboardPoint s2 = new ChessboardPoint(getSource().getX(), getSource().getY()+1);
        while (s2.getY() <= 7) {
            if ( board[getSource().getX()][s2.getY()].getName()=='_'){
                canMove.add(new ChessboardPoint(s2.getX(),s2.getY()));
            } else if (board[s2.getX()][s2.getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                canMove.add(new ChessboardPoint(s2.getX(),s2.getY()));
                break;
            }else break;
            s2.setY(s2.getY()+1);
        }
        ChessboardPoint s3 = new ChessboardPoint(getSource().getX(), getSource().getY()-1);
        while (s3.getY() >=0) {
            if ( board[getSource().getX()][s3.getY()].getName()=='_'){
                canMove.add(new ChessboardPoint(s3.getX(),s3.getY()));
            } else if(board[s3.getX()][s3.getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                canMove.add(new ChessboardPoint(s3.getX(),s3.getY()));
                break;
            }else break;
            s3.setY(s3.getY()-1);
        }
        Comparator<ChessboardPoint> comparator = (o1, o2) -> {
            if (o1.getX()==o2.getX())
                return o1.getY()-o2.getY();
            return o1.getX()-o2.getX();
        };
        canMove.sort(comparator);
        return canMove;
    }

}
