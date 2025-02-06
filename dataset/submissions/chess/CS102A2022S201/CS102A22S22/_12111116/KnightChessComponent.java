import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessColor currentPlayer;

    public KnightChessComponent(int x, int y, ChessColor a) {
        this.x=x;
        this.y=y;
        getSource().setX(x);
        getSource().setY(y);
        this.currentPlayer=a;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        x = getSource().getX();
        y = getSource().getY();
        List<ChessboardPoint> chessboardPoint = new ArrayList<>();
        ChessboardPoint c;
        int[] a = {1,1,2,2,-1,-1,-2,-2};
        int[] b = {2,-2,1,-1,2,-2,1,-1};
        for (int i = 0; i < 8; i++) {
            c = new ChessboardPoint(x, y);
            if (c.offset(a[i], b[i])!=null){
                if (!getChess(x+a[i],y+b[i]).getChessColor() .equals( currentPlayer)) {
                    chessboardPoint.add(c.offset(a[i], b[i]));
                }
            }
        }
        return chessboardPoint;
    }
}
