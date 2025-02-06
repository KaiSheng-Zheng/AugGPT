import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent() {
        super();
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }



    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(this.canMoveTo(i,j)){
                    ChessboardPoint kai=new ChessboardPoint(i,j);
                    canMoveTo.add(kai);
                }
            }
        }
        return canMoveTo;
    }

    public boolean canMoveTo(int x2, int y2) {
        ConcreteChessGame Bishop = new ConcreteChessGame();
        if ((x2 - this.getSource().getX() != y2 - this.getSource().getY() && x2 - this.getSource().getX() != -y2 + this.getSource().getY()) || (this.getSource().getX() == x2 && this.getSource().getY() == y2)) {
            return false;
        } else {
            if (x2 - this.getSource().getX() == y2 - this.getSource().getY()) {
                if (x2 > this.getSource().getX()) {
                    for (int i = this.getSource().getX() + 1; i < x2; i++) {
                        if (!(Bishop.getChess(i, this.getSource().getY() - this.getSource().getX() + i) instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = this.getSource().getX() - 1; i > x2; i--) {
                        if (!(Bishop.getChess(i, this.getSource().getY() - this.getSource().getX() + i) instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
            } else {
                if (x2 > this.getSource().getX()) {
                    for (int i = this.getSource().getX() + 1; i < x2; i++) {
                        if (!(Bishop.getChess(i, this.getSource().getY() + this.getSource().getX() - i) instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = this.getSource().getX() - 1; i > x2; i--) {
                        if (!(Bishop.getChess(i, this.getSource().getY() + this.getSource().getX() - i) instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
            }
            if (!(Bishop.getChess(x2, y2) instanceof EmptySlotComponent)&&this.getChessColor()==(Bishop.getChess(x2, y2).getChessColor())) {
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
