


import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponent;

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessComponent) {
        setSource(source);
        setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK) {
            name = 'R';
        } else if (chessColor == ChessColor.WHITE) {
            name = 'r';
        }
        this.chessComponent = chessComponent;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessboardPoint destination;
        boolean judge ;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                judge = true;
                destination = new ChessboardPoint(i, j);
                if (!(chessComponent[i][j].getChessColor() == getChessColor())) {
                    if (getSource().getX() == destination.getX()) {
                        int row = getSource().getX();
                        for (int col = Math.min(getSource().getY(), destination.getY()) + 1;
                             col < Math.max(getSource().getY(), destination.getY()); col++) {
                            if (!(chessComponent[row][col] instanceof EmptySlotComponent)) {
                                judge = false;
                                break;
                            }
                        }
                    } else if (getSource().getY() == destination.getY()) {
                        int col = getSource().getY();
                        for (int row = Math.min(getSource().getX(), destination.getX()) + 1;
                             row < Math.max(getSource().getX(), destination.getX()); row++) {
                            if (!(chessComponent[row][col] instanceof EmptySlotComponent)) {
                                judge = false;
                                break;
                            }
                        }
                    } else {
                        judge = false;
                    }
                    if (judge){
                        canMoveTo.add(destination);
                    }
                }
            }
        }
        return canMoveTo;
    }
}