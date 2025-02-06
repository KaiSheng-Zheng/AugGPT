import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public PawnChessComponent(){
        if (this.getChessColor() == ChessColor.BLACK){
            setName('P');
        }else if (this.getChessColor() == ChessColor.WHITE){
            setName('p');
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        int row = getSource().getX();
        int col = getSource().getY();

        if (this.getChessColor() == ChessColor.WHITE){
            if (row == 6){ //first step
                if (chessComponents[row - 1][col] instanceof EmptySlotComponent){
                    points.add(new ChessboardPoint(row - 1, col));
                }
                if (chessComponents[row - 2][col] instanceof EmptySlotComponent){
                    points.add(new ChessboardPoint(row - 2, col));
                }
                //go straight
                if (col - 1 >= 0){
                    if (chessComponents[row - 1][col - 1].getChessColor() != this.getChessColor() && !(chessComponents[row - 1][col - 1] instanceof EmptySlotComponent)){
                        points.add(new ChessboardPoint(row - 1, col - 1));
                    }
                }
                if (col + 1 < 8){
                    if (chessComponents[row - 1][col + 1].getChessColor() != this.getChessColor() && !(chessComponents[row - 1][col + 1] instanceof EmptySlotComponent)){
                        points.add(new ChessboardPoint(row - 1, col + 1));
                    }
                }
                //diagonal eat
            }else if (row < 6 && row >= 0){//other step
                if (row - 1 >= 0){//didn't reach bottom line
                    if (chessComponents[row - 1][col] instanceof EmptySlotComponent){
                        points.add(new ChessboardPoint(row - 1, col));
                    }
                    //go straight

                    if (col - 1 >= 0){
                        if (!(chessComponents[row - 1][col - 1] instanceof EmptySlotComponent) && (chessComponents[row - 1][col - 1].getChessColor() != this.getChessColor())){
                            points.add(new ChessboardPoint(row - 1, col - 1));
                        }
                    }

                    if (col + 1 < 8){
                        if (!(chessComponents[row - 1][col + 1] instanceof EmptySlotComponent) && (chessComponents[row - 1][col + 1].getChessColor() != this.getChessColor())){
                            points.add(new ChessboardPoint(row - 1, col + 1));
                        }
                    }
                    //diagonal eat
                }
            }
        }else if (this.getChessColor() == ChessColor.BLACK){
            if (row == 1){ //first step
                if (chessComponents[row + 1][col] instanceof EmptySlotComponent){
                    points.add(new ChessboardPoint(row + 1, col));
                }
                if (chessComponents[row + 2][col] instanceof EmptySlotComponent){
                    points.add(new ChessboardPoint(row + 2, col));
                }
                //go straight
                if (col - 1 >= 0){
                    if (chessComponents[row + 1][col - 1].getChessColor() != this.getChessColor() && !(chessComponents[row + 1][col - 1] instanceof EmptySlotComponent)){
                        points.add(new ChessboardPoint(row + 1, col - 1));
                    }
                }
                if (col + 1 < 8){
                    if (chessComponents[row + 1][col + 1].getChessColor() != this.getChessColor() && !(chessComponents[row + 1][col + 1] instanceof EmptySlotComponent)){
                        points.add(new ChessboardPoint(row + 1, col + 1));
                    }
                }
                //diagonal eat
            }else if (row > 1 && row < 8){//other step
                if (row + 1 < 8){//didn't reach bottom line
                    if (chessComponents[row + 1][col] instanceof EmptySlotComponent){
                        points.add(new ChessboardPoint(row + 1, col));
                    }
                    //go straight

                    if (col - 1 >= 0){
                        if (!(chessComponents[row + 1][col - 1] instanceof EmptySlotComponent) && (chessComponents[row + 1][col - 1].getChessColor() != this.getChessColor())){
                            points.add(new ChessboardPoint(row + 1, col - 1));
                        }
                    }

                    if (col + 1 < 8){
                        if (!(chessComponents[row + 1][col + 1] instanceof EmptySlotComponent) && (chessComponents[row + 1][col + 1].getChessColor() != this.getChessColor())){
                            points.add(new ChessboardPoint(row + 1, col + 1));
                        }
                    }
                    //diagonal eat
                }
            }
        }

        return points;
    }
}
