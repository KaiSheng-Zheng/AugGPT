import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponent;
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK){
            name = 'P';
        }else {
            name = 'p';
        }
    }
    @Override
    public void setChessboardPoint(ChessboardPoint chessboardPoint){
        source = chessboardPoint;
    }
    @Override
    public ChessColor getChessColor(){
        return chessColor;
    }
    @Override
    public void setChessComponent(ChessComponent[][] chessComponent){
        this.chessComponent = chessComponent;
    }
    @Override
    public ChessComponent[][] getChessComponent(){
        return chessComponent;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(source.getY()!=j){
                    if (chessColor == ChessColor.BLACK && chessComponent[i][j].getChessColor() == ChessColor.WHITE) {
                        if (canMoveTo(chessComponent,new ChessboardPoint(i,j))) {
                            list.add(new ChessboardPoint(i, j));
                        }
                    }else if(chessColor == ChessColor.WHITE && chessComponent[i][j].getChessColor() == ChessColor.BLACK){
                        if (canMoveTo(chessComponent,new ChessboardPoint(i,j))) {
                            list.add(new ChessboardPoint(i, j));
                        }
                    }
                }else if(canMoveTo(chessComponent,new ChessboardPoint(i,j))) {
                    list.add(new ChessboardPoint(i,j));
                }
            }
        }
        return list;
    }
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        if (getChessColor()==ChessColor.BLACK){
            if (source.getX()==1){
                if (source.getX()==destination.getX()-2&&destination.getY()==source.getY()){
                    if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)||!(chessComponents[destination.getX()-1][destination.getY()] instanceof EmptySlotComponent)){
                        return  false;
                    }
                }
                else if (source.getX()==destination.getX()-1&&destination.getY()==source.getY()){
                    if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)){
                        return  false;
                    }
                }
                else if((source.getX()==destination.getX()-1&&source.getY()==destination.getY()-1)||(source.getX()==destination.getX()-1&&source.getY()==destination.getY()+1)){
                    if ((chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)){
                        return  false;
                    }
                }
                else {
                    return false;
                }
                return true;
            }
            if (source.getX()==7){

                return false;
            }
            if (source.getX()!=1&&source.getX()!=7){
                if (source.getX()==destination.getX()-1&&destination.getY()==source.getY()){
                    if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)){
                        return  false;
                    }
                }
                else if ((source.getX() == destination.getX() -1 && source.getY() == destination.getY() - 1) || (source.getX() == destination.getX() - 1 && source.getY() == destination.getY() + 1)) {
                    if ((chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
        if (getChessColor()==ChessColor.WHITE){
            if (source.getX()==6){
                if (source.getX()==destination.getX()+2&&destination.getY()==source.getY()){
                    if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)||!(chessComponents[destination.getX()+1][destination.getY()] instanceof EmptySlotComponent)){
                        return  false;
                    }
                }
                else if (source.getX()==destination.getX()+1&&destination.getY()==source.getY()){
                    if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)){
                        return  false;
                    }
                }

                else if ((source.getX() == destination.getX() +1 && source.getY() == destination.getY() - 1) || (source.getX() == destination.getX() + 1 && source.getY() == destination.getY() + 1)) {
                    if ((chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (source.getX()!=6){
                if (source.getX()==destination.getX()+1&&destination.getY()==source.getY()){
                    if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)){
                        return  false;
                    }
                }
                else if ((source.getX() == destination.getX() +1 && source.getY() == destination.getY() - 1) || (source.getX() == destination.getX() + 1 && source.getY() == destination.getY() + 1)) {
                    if ((chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
    
}