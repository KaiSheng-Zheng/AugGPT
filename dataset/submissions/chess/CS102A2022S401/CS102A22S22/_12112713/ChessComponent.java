import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessboard;
    public ChessComponent(ChessboardPoint source){
        this.source = source;
    }
    public ChessComponent(ChessColor chessColor){
        this.chessColor = chessColor;
    }
    public ChessComponent(char name){
        this.name = name;
    }

    public ChessComponent(ChessColor chessColor, char name) {
        this.chessColor = chessColor;
        this.name = name;
    }

    public void setChessboard(ChessComponent[][] chessboard){
        this.chessboard = chessboard;
    }
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.chessColor = chessColor;
        this.source = source;
        this.name = name;
    }

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public ChessComponent(){
    }
    public abstract List<ChessboardPoint> canMoveTo();
    public ChessboardPoint getSource(){
        return source;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    public void setChessColorToBlack(){
        chessColor = ChessColor.BLACK;
    }
    public void setChessColorToWhite(){
        chessColor = ChessColor.WHITE;
    }
    public void setChessColorToNone(){
        chessColor = ChessColor.NONE;
    }
    public void setSource(ChessboardPoint source){
        this.source = source;
    }
    public void setChessColor(ChessColor chessColor){ this.chessColor = chessColor;}
    public void setName(char name){ this.name = name; }
    public char getName(){
        return this.name;
    }
    public String toString(){
        return String.valueOf(this.name);
    }
}
