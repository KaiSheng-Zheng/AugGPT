import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove=new ArrayList<>();
        ChessComponent[][] board=ConcreteChessGame.getChessComponents();
        switch (getChessColor()) {
            case WHITE -> {
                if (getSource().getY() == 1 && board[getSource().getX()][2].getName()=='_' && board[getSource().getX()][2].getName()=='_') {
                    canMove.add(new ChessboardPoint(getSource().getX(),3));
                }
                if (getSource().getY() >= 1 && getSource().getY()<= 6) {
                    if (board[getSource().getX()][getSource().getY()+1].getName()=='_') {
                        canMove.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
                    }
                    if (board[getSource().getX()-1][getSource().getY()+1].getName()!='_' && board[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK) {
                        canMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
                    }
                    if (board[getSource().getX()+1][getSource().getY()+1].getName()!='_' && board[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.BLACK) {
                        canMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
                    }
                }
            }
            case BLACK -> {
                if (getSource().getY() == 6 && board[getSource().getX()][5].getName() == '_' && board[getSource().getX()][4].getName() == '_') {
                    canMove.add(new ChessboardPoint(getSource().getX(), 4));
                }
                if (getSource().getY() >= 1 && getSource().getY() <= 6) {
                    if (board[getSource().getX()][getSource().getY() - 1].getName() == '_') {
                        canMove.add(new ChessboardPoint(getSource().getX(), getSource().getY() - 1));
                    }
                    if (board[getSource().getX() - 1][getSource().getY() - 1].getName() != '_' && board[getSource().getX() - 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                        canMove.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                    if (board[getSource().getX() + 1][getSource().getY() - 1].getName() != '_' && board[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                        canMove.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }
                }
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


    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor color, char name) {
        super(chessboardPoint, color, name);
    }
}
