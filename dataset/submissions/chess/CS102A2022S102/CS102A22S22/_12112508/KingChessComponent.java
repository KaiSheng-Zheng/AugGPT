import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
//    ConcreteChessGame concreteChessGame;


    private ChessComponent[][]chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public KingChessComponent(){
        if (this.getChessColor() == ChessColor.BLACK){
            setName('K');
        }else if (this.getChessColor() == ChessColor.WHITE){
            setName('k');
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        int row = getSource().getX();
        int col = getSource().getY();


        if (col - 1 >= 0){
            if (chessComponents[row][col - 1] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(row, col - 1));
            } else if (chessComponents[row][col - 1].getChessColor() != this.getChessColor()) {
                points.add(new ChessboardPoint(row, col - 1));
            }

            if (row - 1 >= 0){
                if (chessComponents[row - 1][col - 1] instanceof EmptySlotComponent){
                    points.add(new ChessboardPoint(row - 1, col - 1));
                } else if (chessComponents[row - 1][col - 1].getChessColor() != this.getChessColor()) {
                    points.add(new ChessboardPoint(row - 1, col - 1));
                }

            }

            if (row + 1 < 8){
                if (chessComponents[row + 1][col - 1] instanceof EmptySlotComponent){
                    points.add(new ChessboardPoint(row + 1, col - 1));
                } else if (chessComponents[row + 1][col - 1].getChessColor() != this.getChessColor()) {
                    points.add(new ChessboardPoint(row + 1, col - 1));
                }
            }
        }


        if (col + 1 < 8){
            if (chessComponents[row][col + 1] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(row, col + 1));
            } else if (chessComponents[row][col + 1].getChessColor() != this.getChessColor()) {
                points.add(new ChessboardPoint(row, col + 1));
            }


            if (row - 1 >= 0){
                if (chessComponents[row - 1][col + 1] instanceof EmptySlotComponent){
                    points.add(new ChessboardPoint(row - 1, col + 1));
                } else if (chessComponents[row - 1][col + 1].getChessColor() != this.getChessColor()) {
                    points.add(new ChessboardPoint(row - 1, col + 1));
                }
            }

            if (row + 1 < 8){
                if (chessComponents[row + 1][col + 1] instanceof EmptySlotComponent){
                    points.add(new ChessboardPoint(row + 1, col + 1));
                } else if (chessComponents[row + 1][col + 1].getChessColor() != this.getChessColor()) {
                    points.add(new ChessboardPoint(row + 1, col + 1));
                }
            }

        }



        if (row - 1 >= 0){
            if (chessComponents[row - 1][col] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(row - 1, col));
            } else if (chessComponents[row - 1][col].getChessColor() != this.getChessColor()) {
                points.add(new ChessboardPoint(row - 1, col));
            }
        }


        if (row + 1 < 8){
            if (chessComponents[row + 1][col] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(row + 1, col));
            } else if (chessComponents[row + 1][col].getChessColor() != this.getChessColor()) {
                points.add(new ChessboardPoint(row + 1, col));
            }
        }


        return points;
    }
}
