

import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveToList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(canMoveChess(i,j)){
                    canMoveToList.add(new ChessboardPoint(i,j));
                }
            }
        }
        if(canMoveToList.size()==0){
            return new ArrayList<>();
        }else{
            return canMoveToList;
        }
    }


    public boolean canMoveChess( int targetX, int targetY) {
        if (getChessColor()==ChessColor.BLACK){
            if (targetX<=getSource().getX()){
                return false;
            }
            if(getChessComponents()[targetX][targetY] instanceof EmptySlotComponent){
                if((getSource().getX()==1)&&(getSource().getY()==targetY)&&(targetX==3)&&(getChessComponents()[2][getSource().getY()] instanceof EmptySlotComponent)) {
                        return true;
                    }
                if((targetX==getSource().getX()+1)&&(getSource().getY()==targetY)){
                    return true;
                }
            }if(getChessComponents()[targetX][targetY].getChessColor()==ChessColor.WHITE){
                if((targetX==getSource().getX()+1)&&Math.abs(targetY-getSource().getY())==1){
                    return true;
                }
            }
        }
        if (getChessColor()==ChessColor.WHITE){
            if (targetX>=getSource().getX()){
                return false;
            }
            if(getChessComponents()[targetX][targetY] instanceof EmptySlotComponent){
                if((getSource().getX()==6)&&(getSource().getY()==targetY)&&(targetX==4)&&(getChessComponents()[5][getSource().getY()] instanceof EmptySlotComponent)) {
                        return true;
                }
                if((targetX==getSource().getX()-1)&&(getSource().getY()==targetY)){
                    return true;
                }
            }if(getChessComponents()[targetX][targetY].getChessColor()==ChessColor.BLACK){
                if((targetX==getSource().getX()-1)&&Math.abs(targetY-getSource().getY())==1){
                    return true;
                }
            }
        }
        return false;
    }
}
