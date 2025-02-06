import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        super(chessboardPoint,chessColor,name,chessComponents);
    }
    public boolean handleSecond(ChessComponent chessComponent) {
        return chessComponent.getChessColor() != this.getChessColor() &&
                this.canMoveTo0(chessComponents, chessComponent.getChessboardPoint());
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list=new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(handleSecond(chessComponents[i][j]))
                    list.add(new ChessboardPoint(i,j));
            }
        }
        return list;
    }
    public boolean canMoveTo0(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source=getChessboardPoint();
        if(source==destination){
            return false;
        }
        else if (Math.abs(source.getX()-destination.getX())==Math.abs(source.getY()-destination.getY())){
            int row=Math.min(source.getX(),destination.getX()),col=Math.min(source.getY(),destination.getY());
            if (source.getX()!=destination.getX()&&source.getY()!=destination.getY()){
                if (source.getX() > row && source.getY() > col) {
                    for (int rowroad = row+1; rowroad < source.getX(); rowroad++) {
                        if (!(chessComponents[rowroad][col+rowroad-row]instanceof EmptySlotComponent)){
                            return false;
                        }

                    }
                } else if (source.getX() > row && source.getY() == col) {
                    for (int rowroad = row+1; rowroad < source.getX(); rowroad++) {
                        if (!(chessComponents[rowroad][destination.getY()-rowroad+row]instanceof EmptySlotComponent)){
                            return false;
                        }
                    }
                } else if (source.getX() == row && source.getY() == col) {
                    for (int rowroad = row+1; rowroad < destination.getX(); rowroad++) {
                        if (!(chessComponents[rowroad][col+rowroad-row]instanceof EmptySlotComponent)){
                            return false;
                        }
                    }
                } else if (source.getX() == row && source.getY() > col) {
                    for (int rowroad = row + 1; rowroad < destination.getX(); rowroad++) {
                        if (!(chessComponents[rowroad][source.getY() - rowroad + row] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }

            }
        }else if (source.getX() == destination.getX()&&source.getY()!=destination.getY()) {
            int row1 = source.getX();
            for (int col1 = Math.min(source.getY(), destination.getY()) + 1;
                 col1 < Math.max(source.getY(), destination.getY()); col1++) {
                if (!(chessComponents[row1][col1] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()&&source.getX()!=destination.getX()) {
            int col1 = source.getY();
            for (int row1 = Math.min(source.getX(), destination.getX()) + 1;
                 row1 < Math.max(source.getX(), destination.getX()); row1++) {
                if (!(chessComponents[row1][col1] instanceof EmptySlotComponent)) {
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
