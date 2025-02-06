import java.util.List;

public abstract class ChessComponent {
    public  ConcreteChessGame belonging;
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
   // private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    public int steps=0;

   // private ChessboardPoint chessboardPoint;

    public ConcreteChessGame getBelonging() {
        return belonging;
    }

    public void setBelonging(ConcreteChessGame belonging) {
        this.belonging = belonging;
    }

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.source = chessboardPoint;
    }

    public ChessComponent(int x, int y, ChessColor color,ConcreteChessGame concreteChessGame) {
       source=new ChessboardPoint(x,y);
        chessColor=color;
        belonging=concreteChessGame;
    }

    public ChessComponent() {
    }

    public ChessboardPoint getChessboardPoint() {
        return this.source;
    }



    public abstract List<ChessboardPoint> canMoveTo();

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



    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
