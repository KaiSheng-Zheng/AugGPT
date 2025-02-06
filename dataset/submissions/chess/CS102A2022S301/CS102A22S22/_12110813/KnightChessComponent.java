

import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveToList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(canMoveChess(this.getSource().getX(),this.getSource().getY(),i,j)){
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


    public boolean canMoveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(getChessComponents()[targetX][targetY].getChessColor()==getChessColor()){
            return false;
        }
        if(((Math.abs(sourceX-targetX)==2)&&(Math.abs(sourceY-targetY)==1))||((Math.abs(sourceY-targetY)==2)&&(Math.abs(sourceX-targetX)==1))){
            return true;
        } else {
            return false;
        }
    }
}
