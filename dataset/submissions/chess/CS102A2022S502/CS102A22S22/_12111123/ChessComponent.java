import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor ;
    protected char name;
    private ChessComponent[][] chessComponents ;

    public ChessComponent(){
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents = chessComponents;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public boolean fuck(int dx , int dy){
        boolean D = false;
        ChessboardPoint point = new ChessboardPoint(getSource().getX(),getSource().getY() );
        if(point.offset(dx,dy) != null ){
            if(this.getChessColor() != this.getChessComponents()[getSource().getX()+dx][getSource().getY()+dy].getChessColor() ){
                D = true;
            }
        }
        return D;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}
