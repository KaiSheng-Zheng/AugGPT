import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public ChessComponent(){}

    public ChessComponent(int x,int y){
        source = new ChessboardPoint(x,y);
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public int getX(){
        return source.getX();
    }

    public int getY(){
        return source.getY();
    }

    public void setX(int x){
        source.setX(x);
    }

    public void setY(int y){
        source.setY(y);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public boolean isOpposite(ChessComponent chessComponent){
        if(!(chessComponent.chessColor == chessColor))
            return chessComponent.chessColor == ChessColor.NONE ? false:true;
        return false;
    }

    public boolean isValid(int pos){
        return pos >= 0 & pos < 8;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
