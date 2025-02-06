import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{


    private final ChessboardPoint source;
    private final ChessColor chessColor;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int dx=x+i;
                int dy=y+j;
                if((i!=0 || j!=0) && (dx>=0 && dx<=7) && (dy>=0 && dy<=7)){
                    if(this.chessboard[dx][dy].getChessColor()== ChessColor.NONE){
                        canMovePoints.add(new ChessboardPoint(dx, dy));
                    }
                }
            }
        }
        return canMovePoints;
    }
}