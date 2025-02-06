import java.util.ArrayList;
import java.util.List;
//Changed
public class KingChessComponent extends ChessComponent{
    private List<ChessboardPoint> chesslist = new ArrayList<>();
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;


    @Override
    public List<ChessboardPoint> canMoveTo() {

        for (int a=0; a<8; a++){
            for (int b=0;b<8; b++){
                if (canMove(a,b) && decide(a,b)){
                    chesslist.add(new ChessboardPoint(a,b));
                }
            }
        }
        return chesslist;
    }

    public KingChessComponent(ChessboardPoint point,ChessComponent[][] chessComponents, ChessColor chessColor, char a){
        super(point, chessColor, a);
        this.chessComponents = chessComponents;
        this.a=a;
        this.chessColor = chessColor;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }

    public boolean canMove(int a, int b){
        ChessboardPoint point = getpoint();
        return (Math.abs(point.getY()-b)+Math.abs(point.getX()-a)) == 1
                || Math.abs(point.getX() - a) == 1
                && (Math.abs(point.getX() - a) == Math.abs(point.getY() - b));

    }

    public boolean decide(int a, int b){
        ChessboardPoint point = getpoint();
        return  chessComponents[a][b] instanceof EmptyChessComponent
                ||chessComponents[a][b].getChessColor() != chessComponents[point.getX()][point.getY()].getChessColor();
    }
}

