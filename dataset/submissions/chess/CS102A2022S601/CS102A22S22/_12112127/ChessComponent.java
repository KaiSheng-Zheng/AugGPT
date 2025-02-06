import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent{

    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    private List<String> chessboard=new ArrayList<>();

    public ChessComponent() {
   }
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name,List<String> chessboard) {
    this.chessColor=chessColor;
    this.source=source;
    this.name=name;
    this.chessboard=chessboard;
    }
    public static ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public ChessboardPoint getChessboardPoint() {
        return source;
    }
    public static ChessComponent[][] chessComponents;
    public static void setChessComponents (ChessComponent[][] chessComponents) {
        ChessComponent.chessComponents = chessComponents;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
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

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }
}