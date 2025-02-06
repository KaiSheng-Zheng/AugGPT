
import java.util.List;

public abstract class ChessComponent {
    private ChessComponent[][] chessComponents;
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessboardPoint getSource() {return source;}
    public ChessColor getChessColor() {return chessColor;}
    public void setSource(ChessboardPoint source) {this.source = source;}
    public void setColor(ChessColor chessColor) {this.chessColor = chessColor;}
    public void setName(char name) {this.name = name;}

    public void setChessComponents(ChessComponent[][] chessComponents) {this.chessComponents = chessComponents;}

    public ChessComponent[][] getChessComponents() {return chessComponents;}

    public char getName() {return name;}

    public ChessComponent() {}
    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void moveTo(ChessboardPoint source){
        this.source = source;
    }

    public void move(Integer dx,Integer dy){
        this.source = this.source.offset(dx,dy);
    }
    public boolean whetherhava(int a,int b){
        if (chessComponents[a][b].getName() == '_'){
            return true;
        }else {
            return false;
        }
    }

    public void build(ChessComponent chess){
        this.setSource(chess.getSource());
        this.setName(chess.getName());
        this.setColor(chess.getChessColor());
    }
}
