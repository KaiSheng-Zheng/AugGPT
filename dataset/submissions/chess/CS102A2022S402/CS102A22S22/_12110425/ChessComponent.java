import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessComponents;
    int times;

    //should design
    public ChessComponent(){}
    public ChessComponent(int x,int y){
        this.source = new ChessboardPoint(x,y);
    }

    public ChessColor getChessColor() {

        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
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

    public ChessboardPoint getSource() {
        return source;
    }
    public void setSource(int x,int y){
        this.source.setX(x);
        this.source.setY(y);
    }
    public boolean test(int x,int y){
        boolean a;
        a = (getSource().getX()+x<=7)&&(getSource().getY()+y<=7)&&(getSource().getX()+x>=0&&getSource().getY()+y>=0);
        return a;
    }

    public void setName(char name) {
        this.name = name;
    }
}

