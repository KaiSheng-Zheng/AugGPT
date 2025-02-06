import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {


    public RookChessComponent() {
        super();
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        ConcreteChessGame Rook = new ConcreteChessGame();
        boolean flag;
        if ((this.getSource().getX() != x2 && this.getSource().getY() != y2) || (this.getSource().getX() == x2 && this.getSource().getY() == y2)) {
            flag = false;
        } else {
            if (this.getSource().getY() == y2) {
                if (x2 > this.getSource().getX()) {
                    for (int i = this.getSource().getX() + 1; i < x2; i++) {
                        if (!(Rook.getChess(i, y2) instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = this.getSource().getX() - 1; i > x2; i--) {
                        if (!(Rook.getChess(i, y2) instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
            } else {
                if (y2 > this.getSource().getY()) {
                    for (int i = this.getSource().getY() + 1; i < y2; i++) {
                        if (!(Rook.getChess(x2, i) instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = this.getSource().getY() - 1; i > y2; i--) {
                        if (!(Rook.getChess(x2, i) instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
            }
        }

        if (!(Rook.getChess(x2, y2) instanceof EmptySlotComponent) && this.getChessColor() == (Rook.getChess(x2, y2).getChessColor())) {
            return false;
        } else {
            return true;
        }


    }
}
