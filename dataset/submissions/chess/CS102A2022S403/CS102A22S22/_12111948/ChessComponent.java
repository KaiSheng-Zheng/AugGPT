import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public ChessComponent[][] getChessBoard(){
        return chessComponents;
    }
    public void setChessBoard(ChessComponent[][] board){
        chessComponents = board;
    }

    
    public ChessComponent(){}

    public ChessComponent(int x,int y){
        source = new ChessboardPoint(x,y);
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public int getX(){
        return source.getX();
    }

    public int getY(){
        return source.getY();
    }

    public void setX(int x){
        source.setX(x);
    }

    public void setY(int y){
        source.setY(y);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public boolean isOpposite(ChessComponent chessComponent){
        if(Character.isUpperCase(chessComponent.name)){
            return Character.isLowerCase(name);
        }
        if(Character.isLowerCase(chessComponent.name)){
            return Character.isUpperCase(name);
        }
        return false;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
