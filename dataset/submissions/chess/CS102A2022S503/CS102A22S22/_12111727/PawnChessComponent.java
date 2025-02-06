import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
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
        ChessboardPoint source = getChessboardPoint();
        if(this.getChessColor()==ChessColor.BLACK){
            if(source.getX()==1) {
                if (destination.getY() == source.getY() && (destination.getX() - source.getX() > 0 && destination.getX() - source.getX() <= 2)) {
                    int col = source.getY();
                    if(!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent))
                        return false;
                    for (int row = Math.min(source.getX(), destination.getX()) + 1;
                         row < Math.max(source.getX(), destination.getX()); row++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
                else if(destination.getX()- source.getX()==1&&Math.abs(destination.getY()- source.getY())==1){
                    int row=destination.getX();
                    int col=destination.getY();
                    if(chessComponents[row][col] instanceof EmptySlotComponent)
                        return false;
                }
                else
                    return false;
            }
            else{
                if (destination.getY() == source.getY() && destination.getX() - source.getX()==1) {
                    int col = source.getY();
                    if(!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent))
                        return false;
                    for (int row = Math.min(source.getX(), destination.getX()) + 1;
                         row < Math.max(source.getX(), destination.getX()); row++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {//
                            return false;
                        }
                    }
                }
                else if(destination.getX()- source.getX()==1&&Math.abs(destination.getY()- source.getY())==1){
                    int row=destination.getX();
                    int col=destination.getY();
                    if(chessComponents[row][col] instanceof EmptySlotComponent)
                        return false;
                }
                else
                    return false;
            }

            return true;
        }
        else{//
            if(source.getX()==6) {
                if (destination.getY() == source.getY() && (destination.getX() - source.getX() < 0 && destination.getX() - source.getX() >= -2)) {
                    int col = source.getY();
                    if(!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent))
                        return false;
                    for (int row = Math.min(source.getX(), destination.getX()) + 1;
                         row < Math.max(source.getX(), destination.getX()); row++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {//
                            return false;
                        }
                    }
                }
                else if(destination.getX()- source.getX()==-1&&Math.abs(destination.getY()- source.getY())==1){
                    int row=destination.getX();
                    int col=destination.getY();
                    if(chessComponents[row][col] instanceof EmptySlotComponent)
                        return false;
                }
                else
                    return false;
            }
            else{
                if (destination.getY() == source.getY() && destination.getX() - source.getX()==-1) {
                    int col = source.getY();
                    if(!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent))
                        return false;
                    for (int row = Math.min(source.getX(), destination.getX()) + 1;
                         row < Math.max(source.getX(), destination.getX()); row++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {//
                            return false;
                        }
                    }
                }
                else if(destination.getX()- source.getX()==-1&&Math.abs(destination.getY()- source.getY())==1){
                    int row=destination.getX();
                    int col=destination.getY();
                    if(chessComponents[row][col] instanceof EmptySlotComponent)
                        return false;
                }
                else
                    return false;
            }

            return true;
        }
    }
}
