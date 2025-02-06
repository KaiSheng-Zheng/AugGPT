import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] game = new ChessComponent[8][8];

    public ChessComponent(){};

    public ChessComponent(int x, int y, ChessColor color, char name){
        this.source = new ChessboardPoint(x, y);
        chessColor = color;
        this.name = name;
    }

    public void setGame(ChessComponent[][] game){
        this.game = game;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public int validate(int x, int y){
        if(0 <= x && x <= 7 && 0 <= y && y <= 7) return 1;
        else return 0;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
}
