import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessColor currentPlayer;


    public KingChessComponent(int x, int y, ChessColor a) {
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
        ChessboardPoint a;
        List<ChessboardPoint> chessboardPoint=new ArrayList<>();
        for (int i=y-1;i<y+2;i++){
            for (int j=x-1;j<x+2;j++){
                a=new ChessboardPoint(x,y);
                if (a.offset(j-x,i-y)!=null){
                    if (getChess(j,i).getChessColor()!=currentPlayer){
                        chessboardPoint.add(a.offset(j-x,i-y));
                    }
                }
            }
        }
        return chessboardPoint;
    }
}
