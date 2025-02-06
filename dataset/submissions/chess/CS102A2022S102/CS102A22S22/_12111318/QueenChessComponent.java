import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> chesslist = new ArrayList<>();

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
    public QueenChessComponent(ChessboardPoint point,ChessComponent[][] chessComponents, ChessColor chessColor, char a){
        super(point,chessColor,a);
        this.a=a;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }

    public ChessColor getChessColor(){
        return chessColor;
    }

    public boolean Available(int x, int y){
        ChessboardPoint point = getpoint();
        if (point.getX()-x == y-point.getY()){
            int valueOfX = Math.min(point.getX(),x)+1;
            int valueOfY = Math.max(point.getY(),y)-1;
            for (; valueOfX <Math.max(point.getX(),x) && valueOfY> Math.min(point.getY(),y);
                 valueOfX++,valueOfY--){
                boolean judge=chessComponents[valueOfX][valueOfY] instanceof EmptyChessComponent;
                if (!(judge)){
                    return false;
                }
            }
        }else if (point.getX()-x == point.getY() - y){
            int valueOfX = Math.min(point.getX(),x)+1;
            int valueOfY = Math.min(point.getY(),y)+1;
            for (; valueOfX <Math.max(point.getX(),x) && valueOfY< Math.max(point.getY(),y);
                 valueOfX++,valueOfY++){
                boolean judge=chessComponents[valueOfX][valueOfY] instanceof EmptyChessComponent;
                if (!(judge)){
                    return false;
                }
            }
        }
        else if (point.getX() == x){
            int valueOfX = point.getX();
            for (int valueOfY = Math.min(point.getY(), y) + 1;
                 valueOfY < Math.max(point.getY(), y);
                 valueOfY++) {
                boolean judge=chessComponents[valueOfX][valueOfY] instanceof EmptyChessComponent;
                if (!(judge)) {
                    return false;
                }
            }
        }else if (point.getY() == y) {
            int valueOfY = point.getY();
            for (int valueOfX = Math.min(point.getX(), x) + 1;
                 valueOfX < Math.max(point.getX(), x); valueOfX++) {
                boolean judge=chessComponents[valueOfX][valueOfY] instanceof EmptyChessComponent;
                if (!(judge)) {
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
