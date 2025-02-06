import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    private ChessComponent[][] chessComponents;
    protected char name;

    public ChessComponent(){

    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public abstract List<ChessboardPoint> canMoveTo();


    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public ChessboardPoint getChessboardPoint(){
        return source;
    }



    public char getName() {
        return name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


}
