import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class BishopChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> chesslist = new ArrayList<>();
    public BishopChessComponent(ChessboardPoint point, ChessComponent[][] chessComponents, ChessColor chessColor, char a) {
        super(point,chessColor,a);
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
        this.a = a;
    }
    @Override
    public ChessColor getChessColor(){
        return this.chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if (canMove(i,j) && decide(i,j)){
                    chesslist.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chesslist.stream().distinct().collect(Collectors.toList());
    }
    public boolean canMove(int x, int y){
        ChessboardPoint point = getpoint();
        if (((x- point.getX())==(y- point.getY())) && Math.abs(x- point.getX())!=0){
            int row = Math.min(point.getX(),x)+1;
            int col = Math.min(point.getY(),y)+1;
            for (; row<Math.max(point.getX(),x)&&col < Math.max(point.getY(), y);
                 row++,col++){
                if (!(chessComponents[row][col] instanceof EmptyChessComponent)){
                    return false;
                }
            }
        }else if (((x- point.getX()) == (point.getY() - y)) && (x - point.getX() != 0)){
            int row = Math.min(point.getX(),x)+1;
            int col = Math.max(point.getY(),y)-1;
            for (; row<Math.max(point.getX(),x)&&col > Math.min(point.getY(), y);
                 row++,col--){
                if (!(chessComponents[row][col] instanceof EmptyChessComponent)){
                    return false;}
            }
        }else {
            return false;
        }
        return true;
    }
    public boolean decide(int x, int y){
        ChessboardPoint point = getpoint();
        return chessComponents[x][y].getChessColor() != (chessComponents[point.getX()][point.getY()].getChessColor()) || chessComponents[x][y] instanceof EmptyChessComponent;
    }
}
