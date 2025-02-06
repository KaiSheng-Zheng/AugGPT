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
        StringBuilder path = new StringBuilder();
        path.append("(");
        path.append(getX());
        path.append(",");
        path.append(getY());
        path.append(")");
        return String.valueOf(path);

    }

    
    public ChessboardPoint offset(int dx, int dy) {
        int a = getX()+dx;
        int b =getY()+dy;
        ChessboardPoint aa = new ChessboardPoint(a,b);
        if ((a>=0&&a<=7)&&(b>=0&&b<=7)){
            return aa;
        }
else {
    return null;
        }
    }
}
