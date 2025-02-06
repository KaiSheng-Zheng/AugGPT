import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent{
    private ChessColor chessColor;
    private List<ChessboardPoint> chesslist = new ArrayList<>();
    private ChessComponent[][] chessComponents;
    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int a=0; a<8; a++){
            for (int b=0; b<8; b++){
                if (Available(a,b) && decide(a,b)){
                    chesslist.add(new ChessboardPoint(a,b));
                }
            }
        }return chesslist;
    }
    public PawnChessComponent(ChessboardPoint point,ChessComponent[][] chessComponents, ChessColor chessColor, char a){
        super(point, chessColor, a);
        this.a=a;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    public boolean Available(int x, int y){
        ChessboardPoint point = getpoint();
        boolean judge=chessComponents[x][y] instanceof EmptyChessComponent;
        if (point.getY() == y){
            if (chessComponents[point.getX()][point.getY()].getChessColor() == ChessColor.BLACK){
                if (point.getX() == 1){
                    return (point.getX() - x == -1 || point.getX() - x == -2) && (judge);
                }else {
                    if (point.getX()-x != -1){
                        return false;
                    }
                }
            }
            if (chessComponents[point.getX()][point.getY()].getChessColor() == ChessColor.WHITE){
                if (point.getX() == 6){
                    return (point.getX() - x == 1 || point.getX() - x == 2) && (judge);
                }else {
                    if (point.getX()- x != 1){
                        return false;
                    }
                }
            }
            return chessComponents[x][y] instanceof EmptyChessComponent;
        }else if (Math.abs(point.getY()-y) == 1){
            if (chessComponents[point.getX()][point.getY()].getChessColor() == ChessColor.BLACK &&  point.getX()-x == -1
                    && !(judge)){
                return true;
            }
            return chessComponents[point.getX()][point.getY()].getChessColor() == ChessColor.WHITE && point.getX() - x == 1
                    && !(judge);
        } else {
            return false;
        }
    }public boolean decide(int x, int y){
        boolean judge=chessComponents[x][y] instanceof EmptyChessComponent;
        ChessboardPoint point = getpoint();
        return chessComponents[x][y].getChessColor() != chessComponents[point.getX()][point.getY()].getChessColor()
                || judge;
    }

}
