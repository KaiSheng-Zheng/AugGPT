

import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveToList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
//                if(canMoveChess(this.getSource().getX(),this.getSource().getY(),i,j)){
                if (canMoveChess(new ChessboardPoint(i, j)))
                    canMoveToList.add(new ChessboardPoint(i,j));
                }
        }
        if(canMoveToList.size()==0){
            return new ArrayList<>();
        }else {
            return canMoveToList;
        }
    }

//    @Override
//    public List<ChessboardPoint> canMoveTo() {
//        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();
//        for (int x = 0; x < 8; x++)
//            for (int y = 0; y < 8; y++) {
//                ChessboardPoint destination = new ChessboardPoint(x, y);
//                if (CMT(destination))
//                    chessboardPoints.add(destination);
//            }
//        return chessboardPoints;
//    }

//    public boolean CMT(ChessboardPoint destination) {
//        if (getChessComponents()[destination.getX()][destination.getY()].getChessColor() != getChessColor()) {
//            if (getSource().getX() == destination.getX()) {
//                int row = getSource().getX();
//                for (int col = Math.min(getSource().getY(), destination.getY()) + 1;
//                     col < Math.max(getSource().getY(), destination.getY()); col++) {
//                    if (!(getChessComponents()[row][col] instanceof EmptySlotComponent)) {
//                        return false;
//                    }
//                }
//            } else if (getSource().getY() == destination.getY()) {
//                int col = getSource().getY();
//                for (int row = Math.min(getSource().getX(), destination.getX()) + 1;
//                     row < Math.max(getSource().getX(), destination.getX()); row++) {
//                    if (!(getChessComponents()[row][col] instanceof EmptySlotComponent)) {
//                        return false;
//                    }
//                }
//            } else { // Not on the same row or the same column.
//                return false;
//            }
//            return true;
//        }
//        return false;
//    }


    public boolean canMoveChess(ChessboardPoint destination) {
        if (this.getChessColor() == getChessComponents()[destination.getX()][destination.getY()].getChessColor()) {
            return false;
        }
        if ((getSource().getX() != destination.getX()) && (getSource().getY() != destination.getY())) {
            return false;
        } else {
            if (getSource().getX() == destination.getX()) {
                for (int i = Math.min(getSource().getY(), destination.getY()) + 1; i < Math.max(getSource().getY(), destination.getY()); i++) {
                    if (!(getChessComponents()[getSource().getX()][i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
            if (getSource().getY() == destination.getY()) {
                for (int i = Math.min(getSource().getX(), destination.getX()) + 1; i < Math.max(getSource().getX(), destination.getX()); i++) {
                    if (!(getChessComponents()[i][getSource().getY()] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }
}
