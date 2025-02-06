import java.util.Collections;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
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
        return String.format("(%d,%d)",x,y);
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if(dx+getX()<=7&dx+getX()>=0&dy+getY()>=0&dy+getY()<=7) {                                        //
            return new ChessboardPoint(dx+getX(),dy+getY());
        }else {
            return null;
        }
    }

    public static boolean compare(ChessboardPoint f,ChessboardPoint l) {
        if (f.getX() > l.getX()){ return false;}
        if (f.getX() < l.getX()){ return true;}
        if (f.getY() > l.getY()) {
            return false;
        } else {
            return true;
        }
    }
    public static List<ChessboardPoint> sort(List<ChessboardPoint> arrayList) {
        int n=arrayList.size();
        for(int i=0;i<n;i++)
            for(int j=0;j<i;j++)
                if(ChessboardPoint.compare(arrayList.get(i),arrayList.get(j))) {
                    Collections.swap(arrayList, i, j);
                }

        return arrayList;
    }

}
