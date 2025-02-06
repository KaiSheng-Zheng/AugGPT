
import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
private ChessComponent[][] chessComponent;

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor,ChessComponent[][] chessComponent) {
        setSource(source);
        setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            name = 'B';
        } else if (chessColor == ChessColor.WHITE){
            name = 'b';
        }
        this.chessComponent = chessComponent;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                boolean judge ;
                ChessboardPoint destination = new ChessboardPoint(i,j);
                if (!(chessComponent[i][j].getChessColor() == getChessColor())){
                    judge = true;
                    if (destination.getY() - getSource().getY() > 0 && destination.getX() - getSource().getX() > 0 && Math.abs(destination.getY() - getSource().getY()) == Math.abs(destination.getX() - getSource().getX())){
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