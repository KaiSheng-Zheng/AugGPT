import java.util.ArrayList;
import java.util.List; 


public abstract class ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessComponents;
    final int [][] destination = new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

    public ChessComponent() {}
    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    ChessColor PlayerColor(char a){
        if (a == '_'){
            return ChessColor.NONE;
        }else if (a >= 'a' && a<= 'z'){
            return ChessColor.WHITE;
        }else return ChessColor.BLACK;
    }
    void currentboard(ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}



