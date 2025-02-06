import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private boolean startStep = true;

    public PawnChessComponent(ChessColor chessColor, ChessComponent[][] chessComponents) {
        super(chessComponents);
        setChessColor(chessColor);
    }

    @Override
    public String toString() {
        switch (getChessColor()) {
            case BLACK:
                return "P";
            case WHITE:
                return "p";
            default:
                return "_";
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX(), y = getSource().getY();
        ArrayList<ChessboardPoint> canMove = new ArrayList<>();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                boolean can = true;
                ChessComponent destination = chessComponents[i][j];
                int x1 = destination.getSource().getX(), y1 = destination.getSource().getY();
                switch (getChessColor()) {
                    case WHITE: {
                        int a = x - x1, b = y1 - y;
                        if (a * b == 0) {
                            if(a==1)can = destination instanceof EmptySlotComponent;
                            else if(a==2) can = (x == 6 && destination instanceof EmptySlotComponent);
                            else can = false;
                        } else if (Math.abs(b) * a == 1) {
                            can = destination.getChessColor() == ChessColor.BLACK;
                        } else can = false;
                        break;
                    }
                    case BLACK: {
                        int a = x1 - x, b = y1 - y;
                        if (a * b == 0) {
                            if(a==1) can = destination instanceof EmptySlotComponent;
                            else if(a==2) can = (x == 1 && destination instanceof EmptySlotComponent);
                            else can = false;
                        } else if (Math.abs(b) * a == 1) {
                            can = destination.getChessColor() == ChessColor.WHITE;
                        } else can = false;
                    }
                    if (can && canEat(this, destination)) canMove.add(new ChessboardPoint(i,j)); // should be placed outside the switch branch
                }
            }
        }
        return canMove;
    }

}