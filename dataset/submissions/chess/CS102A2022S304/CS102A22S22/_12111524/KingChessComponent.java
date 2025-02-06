import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {


    // Constructor
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {

        super(source, chessColor, name);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        // Attributes
        ChessboardPoint sourceCoordinate = getSource();
        int sourceX = sourceCoordinate.getX();
        int sourceY = sourceCoordinate.getY();
        ChessComponent[][] chessComponents = getChessComponents();
        List<ChessboardPoint> result = new ArrayList<>();


        // Operations
        if (sourceX - 1 <= 7 && sourceY + 1 <= 7 &&
                sourceX - 1 >= 0 && sourceY + 1 >= 0){

            if (chessComponents[sourceX - 1][sourceY + 1].getChessColor() == this.getChessColor()) {
            } else if (chessComponents[sourceX - 1][sourceY + 1].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX - 1,sourceY + 1));
            } else if (chessComponents[sourceX - 1][sourceY + 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX - 1,sourceY + 1));
            }

        }

        if (sourceX - 1 <= 7 && sourceY <= 7 &&
                sourceX - 1 >= 0 && sourceY >= 0){

            if (chessComponents[sourceX - 1][sourceY].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX - 1][sourceY].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX - 1,sourceY));

            } else if (chessComponents[sourceX - 1][sourceY] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX - 1,sourceY));

            }

        }


        if (sourceX + 1 <= 7 && sourceY + 1 <= 7 &&
                sourceX + 1 >= 0 && sourceY + 1 >= 0){

            if (chessComponents[sourceX + 1][sourceY + 1].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX + 1][sourceY + 1].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX + 1,sourceY + 1));

            } else if (chessComponents[sourceX + 1][sourceY + 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX + 1,sourceY + 1));

            }

        }

        if (sourceX + 1 <= 7 && sourceY <= 7 &&
                sourceX + 1 >= 0 && sourceY >= 0){

            if (chessComponents[sourceX + 1][sourceY].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX + 1][sourceY].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX + 1,sourceY));

            } else if (chessComponents[sourceX + 1][sourceY] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX + 1,sourceY));

            }

        }


        if (sourceX + 1 <= 7 && sourceY - 1 <= 7 &&
                sourceX + 1 >= 0 && sourceY - 1 >= 0){

            if (chessComponents[sourceX + 1][sourceY - 1].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX + 1][sourceY - 1].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX + 1,sourceY - 1));

            } else if (chessComponents[sourceX + 1][sourceY - 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX + 1,sourceY - 1));

            }

        }

        if (sourceX <= 7 && sourceY - 1 <= 7 &&
                sourceX >= 0 && sourceY - 1 >= 0){

            if (chessComponents[sourceX][sourceY - 1].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX][sourceY - 1].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX,sourceY - 1));

            } else if (chessComponents[sourceX][sourceY - 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX,sourceY - 1));

            }

        }


        if (sourceX - 1 <= 7 && sourceY - 1 <= 7 &&
                sourceX - 1 >= 0 && sourceY - 1 >= 0){

            if (chessComponents[sourceX - 1][sourceY - 1].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX - 1][sourceY - 1].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX - 1,sourceY - 1));

            } else if (chessComponents[sourceX - 1][sourceY - 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX - 1,sourceY - 1));

            }

        }

        if (sourceX <= 7 && sourceY + 1 <= 7 &&
                sourceX >= 0 && sourceY + 1 >= 0){

            if (chessComponents[sourceX][sourceY + 1].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX][sourceY + 1].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX,sourceY + 1));

            } else if (chessComponents[sourceX][sourceY + 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX,sourceY + 1));

            }

        }

        return result;
        
    }


}
