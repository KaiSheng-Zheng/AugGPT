
import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
private int checkPolymorphism;
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setCheckPolymorphism(int checkPolymorphism) {
        this.checkPolymorphism = checkPolymorphism;
    }

    public int getCheckPolymorphism() {
        return checkPolymorphism;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent() {
        checkPolymorphism=0;
    }

    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }



    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
