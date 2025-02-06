import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;
    public int step=0;

    //should design
    public ChessComponent(){}

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent(ChessColor chessColor, int x, int y, char name){
        this.chessColor=chessColor;
        source=new ChessboardPoint(x,y);
        this.name=name;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
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
    public boolean canEat(int x,int y){
            if (chessboard[x][y].chessColor!=null&&chessboard[x][y].chessColor!=this.chessColor){
                return true;
            }
            else {return false;}
    }

    public boolean canEatPro(int x,int y){
        if (x>=0&&x<8&&y>=0&&y<8){
            if (canEat(x,y)){
                return true;
            }
            else {return false;}
        }
        else {return false;}
    }
    public boolean exactBlank(int x,int y){
        if (x>=0&&x<8&&y>=0&&y<8){
            if (chessboard[x][y].name=='_'){
                return true;
            }
            else {return false;}
        }
        else {return false;}
    }
    public boolean exactBlankMini(int x,int y){
        if (chessboard[x][y].name=='_'){
            return true;
        }
        else {return false;}
    }

}