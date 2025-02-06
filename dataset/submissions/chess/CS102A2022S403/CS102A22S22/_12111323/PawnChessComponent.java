import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends  ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> r = new ArrayList<>();
        if (getChessColor() == ChessColor.WHITE) {
            if (getSource().getX() - 1 >= 0&&ConcreteChessGame.getC()[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE) {
                r.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
            }
            if (getSource().getX() == 6&&ConcreteChessGame.getC()[getSource().getX()-2][getSource().getY()].getChessColor()==ChessColor.NONE) {
                r.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY()));
            }
            if (getSource().getX() - 1 >= 0&&getSource().getY()-1>=0&&ConcreteChessGame.getC()[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK) {
                r.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()-1));
            }
            if (getSource().getX() - 1 >= 0&&getSource().getY()+1<8&&ConcreteChessGame.getC()[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK) {
                r.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()+1));
            }
        }
      else {
            if (getSource().getX() + 1 < 8&&ConcreteChessGame.getC()[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.NONE) {
                r.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
            }
            if (getSource().getX() == 1&&ConcreteChessGame.getC()[getSource().getX()+2][getSource().getY()].getChessColor()==ChessColor.NONE) {
                r.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY()));
            }
            if (getSource().getX() + 1 >= 0&&getSource().getY()-1>=0&&ConcreteChessGame.getC()[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE) {
                r.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()-1));
            }
            if (getSource().getX() + 1 >= 0&&getSource().getY()+1<8&&ConcreteChessGame.getC()[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE) {
                r.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()+1));
            }


        }
        return r;
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}
