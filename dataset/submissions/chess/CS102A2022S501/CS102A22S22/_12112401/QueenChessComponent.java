
import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponent;

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor,ChessComponent[][] chessComponent) {
        setSource(source);
        setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            name = 'Q';
        } else if (chessColor == ChessColor.WHITE){
            name = 'q';
        }
        this.chessComponent=chessComponent;
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
                    } else if (destination.getY() - getSource().getY() > 0 && destination.getX() - getSource().getX() > 0 && Math.abs(destination.getY() - getSource().getY()) == Math.abs(destination.getX() - getSource().getX())){
                        int row0 = getSource().getX() + 1;
                        int col0 = getSource().getY() + 1;
                        while (row0 < destination.getX()) {
                            if (!(chessComponent[row0][col0] instanceof EmptySlotComponent)) {
                                judge = false;
                                break;
                            }
                            row0++;
                            col0++;
                        }
                    } else if (destination.getY() - getSource().getY() > 0 && destination.getX() - getSource().getX() < 0 && Math.abs(destination.getY() - getSource().getY()) == Math.abs(destination.getX() - getSource().getX())){
                        int row0 = getSource().getX() - 1;
                        int col0 = getSource().getY() + 1;
                        while (col0 < destination.getY()) {
                            if (!(chessComponent[row0][col0] instanceof EmptySlotComponent)) {
                                judge = false;
                                break;
                            }
                            row0--;
                            col0++;
                        }
                    } else if (destination.getY() - getSource().getY() < 0 && destination.getX() - getSource().getX() > 0 && Math.abs(destination.getY() - getSource().getY()) == Math.abs(destination.getX() - getSource().getX())){
                        int row0 = destination.getX() - 1;
                        int col0 = destination.getY() + 1;
                        while (row0 > getSource().getX()) {
                            if (!(chessComponent[row0][col0] instanceof EmptySlotComponent)){
                                judge = false;
                                break;
                            }
                            row0--;
                            col0++;
                        }
                    } else if (destination.getY() - getSource().getY() < 0 && destination.getX() - getSource().getX() < 0 && Math.abs(destination.getY() - getSource().getY()) == Math.abs(destination.getX() - getSource().getX())){
                        int row0 = destination.getX() + 1;
                        int col0 = destination.getY() + 1;
                        while (row0 < getSource().getX()) {
                            if (!(chessComponent[row0][col0] instanceof EmptySlotComponent)){
                                judge = false;
                                break;
                            }
                            row0++;
                            col0++;
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