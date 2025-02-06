import java.util.List;
public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessComponent;
    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
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

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }
    public void setChessComponent(ChessComponent[][] chessComponent){
        this.chessComponent=chessComponent;
    }
    public boolean isSameColor(ChessboardPoint a,ChessboardPoint b){
        if(chessComponent[a.getX()][a.getY()].getChessColor()==chessComponent[b.getX()][b.getY()].getChessColor()){
            return true;
        }else {return false;}
    }
    public boolean isOppositeColor(ChessboardPoint a,ChessboardPoint b){
        if(chessComponent[a.getX()][a.getY()].getChessColor()==ChessColor.BLACK &&
        chessComponent[b.getX()][b.getY()].getChessColor()==ChessColor.WHITE){return true;}
        if(chessComponent[a.getX()][a.getY()].getChessColor()==ChessColor.WHITE&&
                chessComponent[b.getX()][b.getY()].getChessColor()==ChessColor.BLACK){return true;}
        else {return false;}
    }
}