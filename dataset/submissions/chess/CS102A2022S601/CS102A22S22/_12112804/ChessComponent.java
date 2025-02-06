import java.util.List;

public abstract class ChessComponent {
    //should design
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    ChessComponent[][] chessBoard;
    public void setChessBoard(ChessComponent[][] chessBoard) {
        this.chessBoard = chessBoard;
    }
    protected char name;
    protected static int[][] nokoru=new int[2][6];
    //{{1,1,2,2,2,8},{1,1,2,2,2,8}};

    public static void chessset(int BW,int type)
    {
        nokoru[BW][type]++;
    }
    public static int[][] getNokoru() {
        return nokoru;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }

    //should design
    public ChessComponent(){

    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    //    public abstract int getType();
}
