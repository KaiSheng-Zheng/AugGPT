import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessColor chessColor;
    private List<ChessboardPoint> chesslist = new ArrayList<>();
    private ChessComponent[][] chessComponents;
    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if (Available(i,j) && decide(i,j)){
                    chesslist.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chesslist;
    }

    public RookChessComponent(ChessboardPoint point, ChessComponent[][] chessComponents,ChessColor chessColor, char a){
        super(point, chessColor, a);
        this.a = a;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }
    public ChessColor getChessColor(){
        return this.chessColor;
    }

    public boolean Available(int x, int y){
        ChessboardPoint point = getpoint();
        if (point.getX() == x) {
            int row = point.getX();
            for (int col = Math.min(point.getY(), y) +1;
                 col < Math.max(point.getY(), y); col++) {
                if (!(chessComponents[row][col] instanceof EmptyChessComponent) ) {
                    return false;
                }
            }
        } else if (point.getY() == y) {
            int col = point.getY();
            for (int row = Math.min(point.getX(), x) +1;
                 row < Math.max(point.getX(), x); row++) {
                if (!(chessComponents[row][col] instanceof EmptyChessComponent)) {
                    return false;
                }
            }
        } else { 
            return false;
        }
        return true;

    }

    public boolean decide(int x, int y){
        ChessboardPoint point = getpoint();
        return chessComponents[x][y].getChessColor() != chessComponents[point.getX()][point.getY()].getChessColor()
                || chessComponents[x][y] instanceof EmptyChessComponent;
    }
}
