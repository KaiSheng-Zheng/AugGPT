
import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
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
        }else {
            return canMoveToList;
        }
    }

    public boolean canMoveChess(int sourceX, int sourceY, int targetX, int targetY){
        int dx=targetX-sourceX;
        int dy=targetY-sourceY;
        if(super.getChessComponents()[targetX][targetY].getChessColor()==this.getChessColor()){
            return false;
        }
        if (Math.abs(dx) != Math.abs(dy)) {
            return false;
        } else {
            for (int i = 1; i < Math.abs(dx); i++) {
                if((sourceX<targetX)&&(sourceY<targetY)){
                    if(!(super.getChessComponents()[sourceX+i][sourceY+i] instanceof EmptySlotComponent)){
                        return false;
                    }
                }else if((sourceX<targetX)&&(sourceY>targetY)){
                    if(!(super.getChessComponents()[sourceX+i][sourceY-i] instanceof EmptySlotComponent)){
                        return false;
                    }
                }else if((sourceX>targetX)&&(sourceY>targetY)){
                    if(!(super.getChessComponents()[sourceX-i][sourceY-i] instanceof EmptySlotComponent)){
                        return false;
                    }
                }else {
                    if(!(super.getChessComponents()[sourceX-i][sourceY+i] instanceof EmptySlotComponent)){
                        return false;
                    }
                }
            }
    }
        return true;
}

}
