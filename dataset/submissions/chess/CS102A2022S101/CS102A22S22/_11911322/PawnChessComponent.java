import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private boolean isXBigger = false; // default white

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessComponent[][] chessComponents = super.getConcreteChessGame().getChessComponents();

        setXBigger(super.getConcreteChessGame().getUpperPlayerAt0() == this.getChessColor());

        if (!super.isHasBeenMoved()) {
            if (this.isXBigger) {
                if (chessComponents[x+1][y] instanceof EmptySlotComponent && chessComponents[x+2][y] instanceof EmptySlotComponent)
                    canMoveTo.add(super.getSource().offset(2,0));
            } else {
                if (chessComponents[x-1][y] instanceof EmptySlotComponent && chessComponents[x-2][y] instanceof EmptySlotComponent)
                    canMoveTo.add(super.getSource().offset(-2,0));
            }
        }

        if (this.isXBigger) {
            if (super.getSource().offset(1,0) != null && chessComponents[x+1][y] instanceof EmptySlotComponent)
                canMoveTo.add(super.getSource().offset(1,0));
            if (super.getSource().offset(1,1) != null && !(chessComponents[x+1][y+1] instanceof EmptySlotComponent) && chessComponents[x+1][y+1].getChessColor() != super.getChessColor())
                canMoveTo.add(super.getSource().offset(1,1));
            if (super.getSource().offset(1,-1) != null && !(chessComponents[x+1][y-1] instanceof EmptySlotComponent) && chessComponents[x+1][y-1].getChessColor() != super.getChessColor())
                canMoveTo.add(super.getSource().offset(1,-1));
        } else {
            if (super.getSource().offset(-1,0) != null && chessComponents[x-1][y] instanceof EmptySlotComponent)
                canMoveTo.add(super.getSource().offset(-1,0));
            if (super.getSource().offset(-1,-1) != null && !(chessComponents[x-1][y-1] instanceof EmptySlotComponent) && chessComponents[x-1][y-1].getChessColor() != super.getChessColor())
                canMoveTo.add(super.getSource().offset(-1,-1));
            if (super.getSource().offset(-1,1) != null && !(chessComponents[x-1][y+1] instanceof EmptySlotComponent) && chessComponents[x-1][y+1].getChessColor() != super.getChessColor())
                canMoveTo.add(super.getSource().offset(-1,1));
        }
        return canMoveTo;
    }

    public void setXBigger(boolean judge) {
        this.isXBigger = judge;
    }
}