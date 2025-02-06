import java.util.ArrayList;
import java.util.List;

abstract public class ChessComponent {
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;
    public  ChessComponent(){};
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    public static boolean inBoard(int x,int y){
        if(x>=0&&y>=0&&x<=7&&y<=7){
            return true;
        }
        else {
            return false;
        }
    }
    public  boolean isSameColor(ChessComponent[][] X,int x,int y){
        if(X[x][y].getChessColor()==this.chessColor){
            return true;
        }
        else {
            return false;
        }
    }
    public   List<ChessboardPoint> realCanMoveTo(ChessComponent[][] X){
        return new ArrayList<>();
    };
    public boolean isOppositeColor(ChessComponent[][] X,int x,int y){
        if(X[x][y].getChessColor()==ChessColor.WHITE&&this.chessColor==ChessColor.BLACK||
                X[x][y].getChessColor()==ChessColor.BLACK&&this.chessColor==ChessColor.WHITE){
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isEmpty(ChessComponent[][] X,int x,int y){
        if(X[x][y].getChessColor()==ChessColor.NONE){
            return true;
        }
        else {
            return false;
        }
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
}