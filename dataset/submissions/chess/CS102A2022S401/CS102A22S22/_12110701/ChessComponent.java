import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent[][] p=new ChessComponent[8][8];

//    public void setConcreteChessGame(ConcreteChessGame concreteChessGame) {
//        this.concreteChessGame = concreteChessGame;
//    }2


    public void setP(ChessComponent[][] p) {
        this.p = p;
    }

    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ChessComponent[][] op) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        p=op;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
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

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}