import java.util.Collections;
import java.util.List;

public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public String toString() {
        return String.format("(%d,%d)",x,y);
    }
    public static boolean ontheboard(int x,int y) {
        if(x>7||x<0) return false;
        if(y>7||y<0) return false;
        return true;
    }
    public ChessboardPoint offset(int dx, int dy) {
        if(ontheboard(x+dx,x+dy)) return new ChessboardPoint(x+dx,y+dy);
        return null;
    }
    public static boolean cmp(ChessboardPoint a,ChessboardPoint b){
        if(a.getX()>b.getX()) return false;
        if(a.getX()<b.getX()) return true;
        if(a.getY()>b.getY()) return false;
        return true;
    }
    public static void sort(List<ChessboardPoint> arrayList) {
        int n=arrayList.size();
        for(int i=0;i<n;i++)
            for(int j=0;j<i;j++)
                if(ChessboardPoint.cmp(arrayList.get(i),arrayList.get(j))) Collections.swap(arrayList,i,j);
    }
}
