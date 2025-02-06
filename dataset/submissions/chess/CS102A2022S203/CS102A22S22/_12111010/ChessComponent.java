import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;

    private ChessComponent[][] chessComponents;

    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public boolean attack(ChessComponent component){
        if (component.name == '_')
            return false;
        return this.isWhite() != component.isWhite();
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public boolean isWhite(){
        return name >= 'a' && name <= 'z';
    }

    public boolean isBlack(){
        return name >= 'A' && name <= 'Z';
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent getChessComponent(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()];
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    //    public abstract void myShowCanMoveTo();
}
