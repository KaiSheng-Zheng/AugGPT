import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public KnightChessComponent(){
        if (this.getChessColor() == ChessColor.BLACK){
            setName('N');
        }else if (this.getChessColor() == ChessColor.WHITE){
            setName('n');
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        int row = getSource().getX();
        int col = getSource().getY();

        if (row - 2 >= 0){
            if (col - 1 >= 0){
                if (chessComponents[row - 2][col - 1] instanceof EmptySlotComponent || chessComponents[row - 2][col - 1].getChessColor() != this.getChessColor()){
                    points.add(new ChessboardPoint(row - 2, col - 1));
                }
            }

            if (col + 1 < 8){
                if (chessComponents[row - 2][col + 1] instanceof EmptySlotComponent || chessComponents[row - 2][col + 1].getChessColor() != this.getChessColor()){
                    points.add(new ChessboardPoint(row - 2, col + 1));
                }
            }
        }


        if (row - 1 >= 0){
            if (col - 2 >= 0){
                if (chessComponents[row - 1][col - 2] instanceof EmptySlotComponent || chessComponents[row - 1][col - 2].getChessColor() != this.getChessColor()){
                    points.add(new ChessboardPoint(row - 1, col - 2));
                }
            }

            if (col + 2 < 8){
                if (chessComponents[row - 1][col + 2] instanceof EmptySlotComponent || chessComponents[row - 1][col + 2].getChessColor() != this.getChessColor()){
                    points.add(new ChessboardPoint(row - 1, col + 2));
                }
            }
        }


        if (row + 1 < 8){
            if (col - 2 >= 0){
                if (chessComponents[row + 1][col - 2] instanceof EmptySlotComponent || chessComponents[row + 1][col - 2].getChessColor() != this.getChessColor()){
                    points.add(new ChessboardPoint(row + 1, col - 2));
                }
            }

            if (col + 2 < 8){
                if (chessComponents[row + 1][col + 2] instanceof  EmptySlotComponent || chessComponents[row + 1][col + 2].getChessColor() != this.getChessColor()){
                    points.add(new ChessboardPoint(row + 1, col + 2));
                }
            }
        }


        if (row + 2 < 8){
            if (col - 1 >= 0){
                if (chessComponents[row + 2][col - 1] instanceof EmptySlotComponent || chessComponents[row + 2][col - 1].getChessColor() != this.getChessColor()){
                    points.add(new ChessboardPoint(row + 2, col - 1));
                }
            }

            if (col + 1 < 8){
                if (chessComponents[row + 2][col + 1] instanceof EmptySlotComponent || chessComponents[row + 2][col + 1].getChessColor() != this.getChessColor()){
                    points.add(new ChessboardPoint(row + 2, col + 1));
                }
            }
        }


        return points;
    }
}
