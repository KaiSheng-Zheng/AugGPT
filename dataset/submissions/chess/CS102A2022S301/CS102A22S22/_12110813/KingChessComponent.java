
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveToList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(canMoveChess(getSource().getX(), getSource().getY(), i,j)){
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
//    public boolean canMoveChess(ChessboardPoint destination) {
//        if ((Math.abs(source.getX() - destination.getX()) <= 1) && (Math.abs(source.getY() - destination.getY()) <= 1))
//            return (getChessComponents()[destination.getX()][destination.getY()].chessColor != chessColor);
//        else
//            return false;
//    }
//}

        public boolean canMoveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int dx=targetX-sourceX;
        int dy=targetY-sourceY;
        if(this.getChessColor()==getChessComponents()[targetX][targetY].getChessColor()){
            return false;
        }else{
            if((Math.abs(dx)<=1)&&(Math.abs(dy)<=1)){
                return true;
            }else {
                return false;
            }
        }
    }

}
