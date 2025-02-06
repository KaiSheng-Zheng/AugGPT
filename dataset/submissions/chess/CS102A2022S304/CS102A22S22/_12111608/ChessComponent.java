import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessboard;

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }
    public boolean isInBoard(ChessboardPoint source,int dx,int dy){
        return (source.getX()+dx>=0&&source.getX()+dx<=7&&source.getY()+dy<=7&&source.getY()+dy>=0);
    }
    public boolean isEmpty(ChessboardPoint source,int dx,int dy){
        return getChessboard()[source.getX()+dx][source.getY()+dy].getChessColor()==ChessColor.NONE;
    }
    public boolean isDifferentColor(ChessboardPoint source,int dx,int dy){
        return (getChessboard()[source.getX()+dx][source.getY()+dy].getChessColor()==ChessColor.BLACK&&this.getChessColor()==ChessColor.WHITE)||(getChessboard()[source.getX()+dx][source.getY()+dy].getChessColor()==ChessColor.WHITE&&this.getChessColor()==ChessColor.BLACK);
    }
    //should design
    public ChessComponent(){}

    public void loadChessBoardComponent(ChessComponent[][] chessComponents){
        this.chessboard=chessComponents;
    }

    public ChessComponent(ChessboardPoint source,ChessColor chessColor){
        this.chessColor=chessColor;
        this.source=source;
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

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
}
