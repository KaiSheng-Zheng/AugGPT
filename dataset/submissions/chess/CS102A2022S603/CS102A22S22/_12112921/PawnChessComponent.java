import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor chessColor){
        setChessColor(chessColor);
        if(chessColor==ChessColor.BLACK){
            setName('P');
        }
        else{
            setName('p');
        }
    }

    public boolean canMove(ChessComponent[][] chessComponents, ChessboardPoint source, ChessboardPoint destination) {
        if (chessColor.equals(ChessColor.BLACK)) {
            if (source.getX()==1) {
                if (destination.getX() < source.getX()) {
                    return false;
                }
                else {
                    if (destination.getX() - source.getX() == 2) {
                        if (destination.getY() == source.getY()) {
                            if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent) || !(chessComponents[destination.getX() - 1][destination.getY()] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        }
                        else {
                            return false;
                        }
                    }
                    else if (destination.getX() - source.getX() == 1) {
                        if (destination.getY() == source.getY()) {
                            if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        }
                        else if (Math.abs(destination.getY() - source.getY()) == 1) {
                            if (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent || chessComponents[destination.getX()][destination.getY()].getChessColor().equals(chessColor)) {
                                return false;
                            }
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                }
                return true;
            }
            else {
                if (destination.getX() < source.getX()) {
                    return false;
                }
                else if (destination.getX() > source.getX()) {
                    if (destination.getX() - source.getX() != 1) {
                        return false;
                    } else {
                        if (destination.getY() == source.getY()) {
                            if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        } else if (Math.abs(destination.getY() - source.getY()) == 1) {
                            if (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent || chessComponents[destination.getX()][destination.getY()].getChessColor().equals(chessColor)) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }
                else {
                    return false;
                }
                return true;
            }
        }
        else {
            if (source.getX()==6) {
                if (destination.getX() >= source.getX()) {
                    return false;
                }
                else {
                    if (destination.getX() - source.getX() == -2) {
                        if (destination.getY() == source.getY()) {
                            if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent) || !(chessComponents[destination.getX() + 1][destination.getY()] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else if (destination.getX() - source.getX() == -1) {
                        if (destination.getY() == source.getY()) {
                            if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        } else if (Math.abs(destination.getY() - source.getY()) == 1) {
                            if (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent || chessComponents[destination.getX()][destination.getY()].getChessColor().equals(chessColor)) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                return true;
            }

            else {
                if (destination.getX() >= source.getX()) {
                    return false;
                }
                else  {
                    if (destination.getX() - source.getX() != -1) {
                        return false;
                    }
                    else {
                        if (destination.getY() == source.getY()) {
                            if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        }
                        else if (Math.abs(destination.getY() - source.getY()) == 1) {
                            if (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent||chessComponents[destination.getX()][destination.getY()].getChessColor().equals(chessColor)) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint>list = new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(canMove(chessComponents,source,new ChessboardPoint(i,j))){
                    list.add(new ChessboardPoint(i,j));
                }
            }
        }
        return list;
    }
}
