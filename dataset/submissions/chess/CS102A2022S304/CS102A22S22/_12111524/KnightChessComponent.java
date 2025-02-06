import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {


    // Constructors
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        if (sourceX - 2 <= 7 && sourceY + 1 <= 7 && 
                sourceX - 2 >= 0 && sourceY + 1 >= 0){
            
            if (chessComponents[sourceX - 2][sourceY + 1].getChessColor() == this.getChessColor()) {
            } else if (chessComponents[sourceX - 2][sourceY + 1].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX - 2,sourceY + 1));
            } else if (chessComponents[sourceX - 2][sourceY + 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX - 2,sourceY + 1));
            }
            
        }
        if (sourceX - 1 <= 7 && sourceY + 2 <= 7 &&
                sourceX - 1 >= 0 && sourceY + 2 >= 0){

            if (chessComponents[sourceX - 1][sourceY + 2].getChessColor() == this.getChessColor()) {
                
            } else if (chessComponents[sourceX - 1][sourceY + 2].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX - 1,sourceY + 2));
                
            } else if (chessComponents[sourceX - 1][sourceY + 2] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX - 1,sourceY + 2));
                
            }
            
        }
        if (sourceX + 1 <= 7 && sourceY + 2 <= 7 &&
                sourceX + 1 >= 0 && sourceY + 2 >= 0){

            if (chessComponents[sourceX + 1][sourceY + 2].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX + 1][sourceY + 2].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX + 1,sourceY + 2));

            } else if (chessComponents[sourceX + 1][sourceY + 2] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX + 1,sourceY + 2));

            }

        }
        if (sourceX + 2 <= 7 && sourceY + 1 <= 7 &&
                sourceX + 2 >= 0 && sourceY + 1 >= 0){

            if (chessComponents[sourceX + 2][sourceY + 1].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX + 2][sourceY + 1].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX + 2,sourceY + 1));

            } else if (chessComponents[sourceX + 2][sourceY + 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX + 2,sourceY + 1));

            }

        }
        if (sourceX + 2 <= 7 && sourceY - 1 <= 7 &&
                sourceX + 2 >= 0 && sourceY - 1 >= 0){

            if (chessComponents[sourceX + 2][sourceY - 1].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX + 2][sourceY - 1].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX + 2,sourceY - 1));

            } else if (chessComponents[sourceX + 2][sourceY - 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX + 2,sourceY - 1));

            }

        }
        if (sourceX + 1 <= 7 && sourceY - 2 <= 7 &&
                sourceX + 1 >= 0 && sourceY - 2 >= 0){

            if (chessComponents[sourceX + 1][sourceY - 2].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX + 1][sourceY - 2].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX + 1,sourceY - 2));

            } else if (chessComponents[sourceX + 1][sourceY - 2] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX + 1,sourceY - 2));

            }

        }
        if (sourceX - 1 <= 7 && sourceY - 2 <= 7 &&
                sourceX - 1 >= 0 && sourceY - 2 >= 0){

            if (chessComponents[sourceX - 1][sourceY - 2].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX - 1][sourceY - 2].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX - 1,sourceY - 2));

            } else if (chessComponents[sourceX - 1][sourceY - 2] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX - 1,sourceY - 2));

            }
            
        }
        if (sourceX - 2 <= 7 && sourceY - 1 <= 7 &&
                sourceX - 2 >= 0 && sourceY - 1 >= 0){

            if (chessComponents[sourceX - 2][sourceY - 1].getChessColor() == this.getChessColor()) {

            } else if (chessComponents[sourceX - 2][sourceY - 1].getChessColor() == this.getChessColorInverse()) {
                result.add(new ChessboardPoint(sourceX - 2,sourceY - 1));

            } else if (chessComponents[sourceX - 2][sourceY - 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(sourceX - 2,sourceY - 1));

            }

        }
        
            return result;
        
    }


}
