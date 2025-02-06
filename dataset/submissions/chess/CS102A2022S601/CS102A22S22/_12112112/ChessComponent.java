import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private List<String> chessboard=new ArrayList<>();
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name,List<String> chessboard) {
        this.chessColor=chessColor;
        this.source=source;
        this.name=name;
        this.chessboard=chessboard;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }


}
