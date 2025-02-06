import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;			// What's the name
    protected static ChessComponent[][] chessboard = new ChessComponent[8][8];

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessboard = chessComponents;
    }
    public ChessComponent[][] getChessComponents() {
        return chessboard;
    }

    public ChessComponent(){}
    public ChessComponent(int x,int y, char name){
        source = new ChessboardPoint(x,y);
        this.name = name;
        if(name == '_'){
            this.chessColor = ChessColor.NONE;
        }
        if(Character.isUpperCase(name))
            this.chessColor = ChessColor.BLACK;
        if(Character.isLowerCase(name))
            this.chessColor = ChessColor.WHITE;

        this.source = new ChessboardPoint(x,y);
        chessboard[x][y] = this;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent[][] getChessBoard() {
        return chessboard;
    }
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setX(int x){
        source.setX(x);
    }

    public void setY(int y){
        source.setY(y);
    }

    public int getX(){
        return source.getX();
    }

    public int getY(){
        return source.getY();
    }

    public char getName() {
        return name;
    }
    

    public void setChessBoard(ChessComponent[][] board){
        this.chessboard = board;
    }
}