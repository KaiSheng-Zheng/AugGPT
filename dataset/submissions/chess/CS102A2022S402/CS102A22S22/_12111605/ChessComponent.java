import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name;// What's the name
    private ChessComponent[][] chessComponents;
    private ChessColor getCurrentColor;


    public ChessColor getGetCurrentColor() {
        return getCurrentColor;
    }


    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }


    public void loadChessGame(ChessComponent[][] chessComponents,ChessColor chessColor){
        this.chessComponents=chessComponents;
        this.getCurrentColor=chessColor;
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

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent(){

    }
    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
