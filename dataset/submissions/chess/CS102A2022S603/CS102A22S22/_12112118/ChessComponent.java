import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent  {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private List<String> ChessList=new ArrayList<>();


    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name,List<String> chessList) {
        this.chessColor=chessColor;
        this.source=source;
        this.name=name;
        this.ChessList=chessList;
    }
    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public void setName(char name) {
        this.name = name;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public ChessboardPoint getSource() {
        return source;
    }

    public char getName() {
        return name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
}