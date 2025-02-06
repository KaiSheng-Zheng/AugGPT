import java.util.ArrayList;
import java.util.List;
public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponent;
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.source = source;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK){
            name = 'B';
        }else {
            name = 'b';
        }
    }
    @Override
    public void setChessboardPoint(ChessboardPoint chessboardPoint){
        source=chessboardPoint;
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
    public ChessColor getChessColor(){
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(i - source.getX()) == Math.abs(j - source.getY()) && chessComponent[i][j].getChessColor() != chessColor) {
                    if (canMoveTo(chessComponent, new ChessboardPoint(i, j))) {
                        list.add(new ChessboardPoint(i, j));
                    }
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