import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    private final ChessboardPoint source;
    private final ChessColor chessColor;

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    public ChessColor getChessColor() {
        return this.chessColor;
    }

    public ChessboardPoint getSource() {
        return this.source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        int x=this.source.getX();
        int y=this.source.getY();
        for(int i=-2;i<=2;i++){
            for(int j=-2;j<=2;j++){
                int dx=x+i;
                int dy=y+j;
                if((i!=0 && j!=0 && Math.abs(i)!=Math.abs(j)) && (dx>=0 && dx<=7) && (dy>=0 && dy<=7)){
                    if (this.chessboard[dx][dy].getChessColor() != this.chessColor) {
                        canMovePoints.add(new ChessboardPoint(dx, dy));
                    }
                }
            }
        }
        return canMovePoints;
    }
}
