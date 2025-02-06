import java.util.List;
public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;
    public void changeSource(int x,int y){
        this.source=new ChessboardPoint(x,y);
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

    public void setChessColor(char name) {
        if(name<90){
            this.chessColor=ChessColor.BLACK;
        }else {
            this.chessColor=ChessColor.WHITE;
        }
    }

    public ChessComponent(){

    }
    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
