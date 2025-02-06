import java.util.ArrayList;
import java.util.List;
public class QueenChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponent;
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK){
            name = 'Q';
        }else {
            name = 'q';
        }
    }
    @Override
    public void setChessboardPoint(ChessboardPoint chessboardPoint){
        source=chessboardPoint;
    }
    @Override
    public void setChessComponent(ChessComponent[][] chessComponent){
        this.chessComponent=chessComponent;
    }
    @Override
    public ChessComponent[][] getChessComponent(){
        return chessComponent;
    }
    @Override
    public ChessColor getChessColor(){
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponent[i][j].getChessColor() != chessColor && canMoveTo(chessComponent,new ChessboardPoint(i,j))){
                    list.add(new ChessboardPoint(i,j));
                }
            }
        }
        return list;
    }
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        if (source.getX() + source.getY() == destination.getX() + destination.getY()) {
            int col = Math.min(source.getY(), destination.getY()) + 1;
            int row = Math.max(source.getX(), destination.getX()) - 1;
            while (col < Math.max(source.getY(), destination.getY())) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
                col++;
                row--;
            }
        } else if (source.getY() - source.getX() == destination.getY() - destination.getX()) {
            int col = Math.min(source.getY(), destination.getY()) + 1;
            int row = Math.min(source.getX(), destination.getX()) + 1;
            while (col < Math.max(source.getY(), destination.getY())) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
                col++;
                row++;
            }
        } else if (source.getX() == destination.getX() && source.getY() != destination.getY()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY() && source.getX() != destination.getX()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
   
}