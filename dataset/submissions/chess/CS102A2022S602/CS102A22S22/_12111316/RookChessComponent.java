import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> list = new ArrayList<>();
    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if (canMove(i,j) && chick(i,j)){
                    list.add(new ChessboardPoint(i,j));
                }
            }
        }
        return list;
    }
    public RookChessComponent(){}
    public RookChessComponent(ChessboardPoint source, ChessComponent[][] chessComponents,ChessColor chessColor, char name){
        super(source,chessComponents, chessColor, name);
        this.name = name;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }
    public ChessColor getChessColor(){
        return this.chessColor;
    }

    public boolean canMove(int x, int y){
        ChessboardPoint source = getSource();
        if (source.getX() == x) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), y) +1;
                 col < Math.max(source.getY(), y); col++) {
                if (!(chessComponents[row][col] instanceof EmptyChessComponent) ) {
                    return false;
                }
            }
        } else if (source.getY() == y) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), x) +1;
                 row < Math.max(source.getX(), x); row++) {
                if (!(chessComponents[row][col] instanceof EmptyChessComponent)) {
                    return false;
                }
            }
        } else { // Not on the same row or the same column.
            return false;
        }
        return true;

    }

    public boolean chick(int x, int y){
        ChessboardPoint source = getSource();
        if (chessComponents[x][y].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor() || chessComponents[x][y] instanceof EmptyChessComponent){
            return true;
        }
        return false;
    }
}
