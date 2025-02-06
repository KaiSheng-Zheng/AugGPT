import java.util.ArrayList;
import java.util.List;



    public class KnightChessComponent extends ChessComponent{

        public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name,ChessComponent[][] chessComponents) {
            super();
            this.setSource(chessboardPoint);
            this.setChessColor(chessColor);
            this.name = name;
            this.chessComponents = chessComponents;
        }
        public List<ChessboardPoint> canMoveTo(){
            List<ChessboardPoint> result = new ArrayList<>();
            for (int i = 0; i <=7 ; i++) {
                for (int j = 0; j <=7 ; j++) {
                    if(this.canBeMovedTo(i,j)){
                        result.add(new ChessboardPoint(i,j));
                    }
                }
            }
            return result;

        }

        public boolean canBeMovedTo(int x,int y){
            if(getChessComponents()[x][y] instanceof EmptySlotComponent ||!getChessComponents()[x][y].getChessColor().equals(this.getChessColor())){
                if(Math.abs(x-this.getChessboardPoint().getX())==2&&Math.abs(y-this.getChessboardPoint().getY())==1){
                    return true;
                }
                if(Math.abs(x-this.getChessboardPoint().getX())==1&&Math.abs(y-this.getChessboardPoint().getY())==2){
                    return true;
                }
                return false;
            }
            return false;

        }
    }


