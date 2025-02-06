import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> chesslist = new ArrayList<>();

    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int a=0; a<8; a++){
            for (int b=0; b<8; b++){
                if (Available(a,b) && decide(a,b)){
                    chesslist.add(new ChessboardPoint(a,b));
                }
            }
        }
        return chesslist;
    }

    public KnightChessComponent(ChessboardPoint point, ChessComponent[][] chessComponents,ChessColor chessColor, char a){
        super(point, chessColor, a);
        this.a=a;
        this.chessColor = chessColor;
        this.chessComponents =chessComponents;
    }

    public ChessColor getChessColor(){
        return chessColor;
    }

    public boolean Available(int a, int b){
        ChessboardPoint point = getpoint();
        int valueOfY=Math.abs(point.getY() - b);
        int valueOfX=Math.abs(point.getX() - a);
        return (valueOfX == 1 && valueOfY == 2) || (valueOfX == 2 && valueOfY == 1);
    }

    public boolean decide(int x, int y){
        ChessboardPoint point = getpoint();
        return chessComponents[x][y].getChessColor() != chessComponents[point.getX()][point.getY()].getChessColor() || chessComponents[x][y] instanceof EmptyChessComponent;
    }
}
