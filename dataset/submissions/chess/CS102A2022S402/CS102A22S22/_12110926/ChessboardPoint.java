import java.util.Collections;
import java.util.List;

public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
     *
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static List<ChessboardPoint> sort(List<ChessboardPoint> chessboardPoints){
        for(int i=1;i< chessboardPoints.size();i++) {
            for (int j = 0; j < i; j++){
                if (chessboardPoints.get(i).getX()<chessboardPoints.get(j).getX()){
                        Collections.swap(chessboardPoints,i,j);
                }
                if (chessboardPoints.get(i).getX()==chessboardPoints.get(j).getX()){
                    if (chessboardPoints.get(i).getY()<chessboardPoints.get(j).getY()){
                        Collections.swap(chessboardPoints,i,j);
                    }
                }
            }
        }
        return chessboardPoints;
    }


    /**
     * should design
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * should design
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return null;
        } else if (this.x + dx < 0 || this.x + dx > 7 || this.y + dy < 0 || this.y + dy > 7) {
            return null;
        } else return new ChessboardPoint(x + dx, y + dy);
    }
}