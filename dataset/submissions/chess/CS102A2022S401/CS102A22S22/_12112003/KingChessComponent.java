import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove=new ArrayList<>();
        ChessComponent[][] board=ConcreteChessGame.getChessComponents();
        ChessboardPoint s = new ChessboardPoint(getSource().getX()-1, getSource().getY()-1);
        while (s.getX() <= getSource().getX() + 1) {
            while (s.getY() <= getSource().getY() + 1) {
                if (board[s.getX()][s.getY()].getName()=='_' || board[s.getX()][s.getY()].getChessColor()!=board[getSource().getX()][getSource().getY()].getChessColor()) {
                    if (s.getY() >= 0 && s.getY() <= 7 && s.getX() >= 0 && s.getX() <= 7) {
                        canMove.add(new ChessboardPoint(s.getX(),s.getY()));
                    }
                }
                s.setY(s.getY()+1);
            }
            s.setX(s.getX()+1);
            s.setY(getSource().getY()-1);
        }
        Comparator<ChessboardPoint> comparator = (o1, o2) -> {
            if (o1.getX()==o2.getX())
                return o1.getY()-o2.getY();
            return o1.getX()-o2.getX();
        };
        canMove.sort(comparator);
        return canMove;
    }



    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor color,char name) {
        super(chessboardPoint, color, name);
    }
}
