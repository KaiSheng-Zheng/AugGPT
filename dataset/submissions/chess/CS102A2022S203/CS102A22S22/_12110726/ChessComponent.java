import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
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
        if( this.judgecolor() != component.judgecolor())
        return true;
        else
            return  false;
    }
    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }
    public boolean judgecolor(){
        if (name >= 'a' && name <= 'z')
            return true;
        else
            return  false;
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
}
