

import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponent;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor,ChessComponent[][] chessComponent) {
        setSource(source);
        setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            name = 'P';
        } else if (chessColor == ChessColor.WHITE){
            name = 'p';
        }
        this.chessComponent = chessComponent;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessboardPoint destination ;
        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                destination = new ChessboardPoint(i,j);
                if (!(chessComponent[i][j].getChessColor() == getChessColor())){
                    if (getChessColor() == ChessColor.WHITE){
                        if (destination.getY() - getSource().getY() == 0){
                            if (getSource().getX() == 6) {
                                if (getSource().getX() - destination.getX() == 2) {
                                    if (chessComponent[destination.getX() + 1][destination.getY()] instanceof EmptySlotComponent && chessComponent[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                                        canMoveTo.add(destination);
                                    }
                                } else if (getSource().getX() - destination.getX() == 1) {
                                    if (chessComponent[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                                        canMoveTo.add(destination);
                                    }
                                }
                            } else {
                                if (getSource().getX() - destination.getX() == 1) {
                                    if (chessComponent[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                                        canMoveTo.add(destination);
                                    }
                                }
                            }
                        } else if (destination.getX() - getSource().getX() == -1 && Math.abs(destination.getY() - getSource().getY()) == 1){
                            if (!(chessComponent[destination.getX()][destination.getY()] instanceof EmptySlotComponent)){
                                canMoveTo.add(destination);
                            }
                        }
                    } else if (getChessColor() == ChessColor.BLACK){
                        if (destination.getY() - getSource().getY() == 0) {
                            if (getSource().getX() == 1) {
                                if (getSource().getX() - destination.getX() == -2){
                                    if (chessComponent[destination.getX() - 1][destination.getY()] instanceof EmptySlotComponent && chessComponent[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                                        canMoveTo.add(destination);
                                    }
                                } else if (getSource().getX() - destination.getX() == -1) {
                                    if (chessComponent[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                                        canMoveTo.add(destination);
                                    }
                                }
                            } else {
                                if (getSource().getX() - destination.getX() == -1) {
                                    if (chessComponent[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                                        canMoveTo.add(destination);
                                    }
                                }
                            }
                        } else if (destination.getX() - getSource().getX() == 1 && Math.abs(destination.getY() - getSource().getY()) == 1){
                            if (!(chessComponent[destination.getX()][destination.getY()] instanceof EmptySlotComponent)){
                                canMoveTo.add(destination);
                            }
                        }
                    }
                }
            }
        }
        return canMoveTo;
    }
}