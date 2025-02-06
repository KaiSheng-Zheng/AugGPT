import java.util.List;

public abstract class ChessComponent {

    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponent;


    public ChessComponent(){

    }


    public ChessComponent[][] getChessComponent() {
        return chessComponent;
    }

    public void setChessComponent(ChessComponent[][] chessComponent) {
        this.chessComponent = chessComponent;
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


    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
