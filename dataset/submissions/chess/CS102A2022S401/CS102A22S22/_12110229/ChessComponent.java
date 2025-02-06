import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString(){
        return String.valueOf(this.name);
    }
    public void setSource(ChessboardPoint source){
        this.source = source;
    }

    public ChessboardPoint getSource(){
        return source;
    }

    public ChessColor getChessColor(){
        return chessColor;
    }

    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
    }

    public boolean boundary(int x,int y){
        if (y>=0 && y<=7 && x>=0 && x<=7){
            return true;
        } else {
            return false;
        }
    }
    public boolean checkChess(int x,int y,ChessColor chessColor){
        if (chessComponents[x][y].getChessColor() != chessColor){
            return true;
        } else {
            return false;
        }
    }
}
