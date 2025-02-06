import java.util.ArrayList;
import java.util.List;

public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * should design
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * should design
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return "("+this.x+","+this.y+")" ;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (this.x+dx<=7&&this.x+dx>=0&&this.y+dy<=7&&this.y+dy>=0) {
            ChessboardPoint newChessboardPoint = new ChessboardPoint(this.x + dx, this.y + dy);
            return newChessboardPoint;
        }
        else {
            return null;
        }
    }
    public boolean contain(List<ChessboardPoint> chessboardPoints){
        for (int i = 0; i < chessboardPoints.size(); i++) {
            if (chessboardPoints.get(i).toString().equals(new ChessboardPoint(this.x, this.y).toString())) return true;
        }
        return false;
    }

    public boolean cando(int dx, int dy){
        return this.x + dx <= 7 && this.x + dx >= 0 && this.y + dy <= 7 && this.y + dy >= 0;
    }
}
