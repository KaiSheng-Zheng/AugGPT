import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    private final ChessboardPoint source;
    private final ChessColor chessColor;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    @Override

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
        if(this.chessColor==ChessColor.BLACK){
            if(x+1>=0 && x+1<=7){
                if(this.chessboard[x+1][y].getChessColor() ==ChessColor.NONE) {
                    canMovePoints.add(new ChessboardPoint(x + 1, y));
                    if (x + 2 <=7) {
                        if(this.chessboard[x + 2][y].getChessColor() == ChessColor.NONE && x==1) {
                            canMovePoints.add(new ChessboardPoint(x + 2, y));
                        }
                    }
                }
            }
            for(int i=-1;i<=1;i+=2){
                int dx = x+1;
                int dy = y+i;
                if (dx >= 0 && dx <= 7 && dy >= 0 && dy <= 7) {
                    if (this.chessboard[dx][dy].getChessColor() ==ChessColor.WHITE) {
                        canMovePoints.add(new ChessboardPoint(dx, dy));
                    }
                }
            }
        }else if(this.chessColor==ChessColor.WHITE){
            if(x-1>=0 && x-1<=7){
                if(this.chessboard[x-1][y].getChessColor() ==ChessColor.NONE) {
                    canMovePoints.add(new ChessboardPoint(x - 1, y));
                    if (x - 2 >= 0) {
                        if(this.chessboard[x - 2][y].getChessColor() == ChessColor.NONE && x==6) {
                            canMovePoints.add(new ChessboardPoint(x - 2, y));
                        }
                    }
                }
            }
            for(int i=-1;i<=1;i+=2){
                int dx = x-1;
                int dy = y+i;
                if (dx >= 0 && dx <= 7 && dy >= 0 && dy <= 7) {
                    if (this.chessboard[dx][dy].getChessColor() ==ChessColor.BLACK) {
                        canMovePoints.add(new ChessboardPoint(dx, dy));
                    }
                }
            }
        }
        return canMovePoints;
    }
}