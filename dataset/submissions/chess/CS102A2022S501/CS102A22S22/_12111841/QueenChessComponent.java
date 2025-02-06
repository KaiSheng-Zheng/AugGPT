import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        canMoveTo.addAll(this.Move(1,1));
        canMoveTo.addAll(this.Move(-1,1));
        canMoveTo.addAll(this.Move(1,-1));
        canMoveTo.addAll(this.Move(-1,-1));
        canMoveTo.addAll(this.Move(1,0));
        canMoveTo.addAll(this.Move(-1,0));
        canMoveTo.addAll(this.Move(0,-1));
        canMoveTo.addAll(this.Move(0,1));
        return canMoveTo;
    }

    public List<ChessboardPoint> Move(int dx,int dy){
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        int changeX = dx;
        int changeY = dy;
        while (this.getSource().offset(dx, dy) != null){
            if (chessboard[x+dx][y+dy].getChessColor() != this.getChessColor()){
                canMoveTo.add(new ChessboardPoint(x+dx,y+dy));
            }
            if (chessboard[x+dx][y+dy].getChessColor() != ChessColor.NONE){
                break;
            }
            dx += changeX; dy += changeY;
        }
        return canMoveTo;
    }
}