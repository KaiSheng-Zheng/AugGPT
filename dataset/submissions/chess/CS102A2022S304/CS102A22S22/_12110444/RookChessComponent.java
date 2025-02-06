import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
      public ChessComponent[][] chessComponents;
        public RookChessComponent(int x, int y, char name, ChessComponent[][] chessComponent) {
            super(x, y, name);
            this.chessComponents=chessComponent;

        }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (moveChess(chessComponents,chessComponents[i][j].getChessboardPoint() )) {
                    move.add(chessComponents[i][j].getChessboardPoint());
                }
            }
        }
        if(move.size()==0){
            return new ArrayList<>();
        }else {
            return move;
        }
    }public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }
    public boolean moveChess(ChessComponent chessComponent[][], ChessboardPoint target) {
        ChessboardPoint source = getChessboardPoint();
        if(chessComponent[source.getX()][source.getY()].getChessColor() != chessComponent[target.getX()][target.getY()].getChessColor()){
            if(source.getX()== target.getX()){
                int row= source.getX();
                for(int col=Math.min(source.getY(), target.getY())+1;col<Math.max(source.getY(),target.getY());col++){
                    if(!(chessComponent[row][col] instanceof EmptySlotComponent)){
                        return false;
                    }
                } return true;
            }
            else if(source.getY()== target.getY()){
                int col = source.getY();
                for(int row=Math.min(source.getX(),target.getX())+1; row<Math.max(source.getX(), target.getX()); row++){
                    if(!(chessComponent[row][col] instanceof EmptySlotComponent)){
                        return false;
                    }
                    }return true;
            }
            else return false;
                }
    return false;}


}



