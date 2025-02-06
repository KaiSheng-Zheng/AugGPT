public class ChessboardPoint {
    private int x;
    private int y;
    private boolean onBoard;

    public ChessboardPoint(int x, int y) {
        if(x<0||x>7||y<0||y>7){
            onBoard = false;
            return;
        }
        onBoard = true;
        this.x = x;
        this.y = y;
    }

    public boolean getOnBoard() {
        return onBoard;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return String.format("(%d,%d)",x,y);
    }

    public ChessboardPoint offset(int dx, int dy) {
        if(x+dx < 0 || y+dy < 0 || x+dx>7||y+dy>7){
            return null;
        }else {
            return new ChessboardPoint(x+dx, y+dy);
        }
    }

    public static void main(String[] args) {
        ChessboardPoint test = new ChessboardPoint(3,4);
        System.out.println(test.toString());
    }
}
